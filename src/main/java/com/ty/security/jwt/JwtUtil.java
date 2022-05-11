package com.ty.security.jwt;

import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.ty.security.service.AppuserDetails;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Service
public class JwtUtil {
	private static final Logger logger = LoggerFactory.getLogger(JwtUtil.class);

	private String jwtSecret="khan";
	private int jwtExpirationMs=86400000;
	
	
	BCryptPasswordEncoder b=new BCryptPasswordEncoder();

	public String generateJwtToken(Authentication authentication) {

		AppuserDetails userPrincipal = (AppuserDetails) authentication.getPrincipal();

		return Jwts.builder().setSubject((userPrincipal.getUsername())).
				claim("name", userPrincipal.getUsername())
				.claim("password", userPrincipal.getPassword()).
				setIssuedAt(new Date())
				.setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
				.signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
	}

	public String getUserNameFromJwtToken(String token) {
		System.out.println("inside validate");
		 String subject = Jwts.parser().setSigningKey("khan").parseClaimsJws(token).getBody().getSubject();
		 System.out.println(subject);
		 return subject;
	}

	public boolean validateJwtToken(String authToken) {
		System.out.println("inside validate token");
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
			return true;
		} catch (SignatureException e) {
			logger.error("Invalid JWT signature: {}", e.getMessage());
		} catch (MalformedJwtException e) {
			logger.error("Invalid JWT token: {}", e.getMessage());
		} catch (ExpiredJwtException e) {
			logger.error("JWT token is expired: {}", e.getMessage());
		} catch (UnsupportedJwtException e) {
			logger.error("JWT token is unsupported: {}", e.getMessage());
		} catch (IllegalArgumentException e) {
			logger.error("JWT claims string is empty: {}", e.getMessage());
		}

		return false;
	}

}
