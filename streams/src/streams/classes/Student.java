package streams.classes;

import java.util.Comparator;

public class Student implements Comparable<Student> {

	private int id;
	private String name;
	private String school;
	private String address;

	@Override
	public int hashCode() {
		return 	this.id;
	}

	@Override
	public boolean equals(Object obj) {
		Student s = (Student) obj;
		if (this.id > s.id) {
			return false;
		} else {
			return true;
		}
	}

	public Student(int id, String name, String school, String address) {
		super();
		this.id = id;
		this.name = name;
		this.school = school;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", school=" + school + ", address=" + address + "]";
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return this.id - o.id;
	}

}
