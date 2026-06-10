package fileHandling.serializationDeserialization;

import java.io.Serializable;

public class Employ implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1000L;
	int empId;
	String empName;
	double empSal;
	String username;
	transient String password;

	public Employ() {

	}

	public Employ(int empId, String empName, double empSal, String username, String password) {
		this.empId = empId;
		this.empName = empName;
		this.empSal = empSal;
		this.username = username;
		this.password = password;
	}
	
	public String toString() {
		return "Id: "+empId+"\tName: "+empName+"\tSalary: "+empSal+"\tUsername: "+username+"\tPassword: "+password;
	}

}
