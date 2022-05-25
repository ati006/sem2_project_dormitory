package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Student {
	private String firstName;
	private String lastName;
	private int phoneNumber;
	private int CPR;
	
	public Student(String firstName, String lastName,int phoneNumber,int CPR) {
		this.firstName=firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.CPR = CPR;
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getCPR() {
		return CPR;
	}
	public void setCPR(int CPR) {
		this.CPR = CPR;
	}
	//return all the parameter to string type for the requests
	public String toQuery() {
		return Integer.toString(CPR) +","+ firstName +","+ lastName +","+ Integer.toString(phoneNumber);
	}
	//second constructor for the requests
	public Student(ResultSet rs) throws SQLException {
		this.firstName = rs.getString("firstName");
		this.lastName = rs.getString("lastName");
		this.phoneNumber = rs.getInt("phoneNumber");
		this.CPR = rs.getInt("CPR");
	}
	
}
