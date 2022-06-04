package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Student {
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String CPR;
	
	public Student(String firstName, String lastName, String phoneNumber,String CPR) {
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getCPR() {
		return CPR;
	}
	public void setCPR(String CPR) {
		this.CPR = CPR;
	}
	//return all the parameter to string type for the requests
	public String toQuery() {
		return "'"+ CPR +"'"+","+"'"+ firstName +"'" +","+"'"+ lastName+"'" +","+"'"+ phoneNumber+"'";
	}
	//second constructor for the requests
	public Student(ResultSet rs) throws SQLException {
		this.firstName = rs.getString("firstName");
		this.lastName = rs.getString("lastName");
		this.phoneNumber = rs.getString("phoneNumber");
		this.CPR = rs.getString("CPR");
	}
	
}
