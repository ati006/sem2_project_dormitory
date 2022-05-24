package controlLayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import databaselayer.DBConnection;
import model.Student;


public class StudentCtr {
	private ArrayList<Student> students;
	private static StudentCtr instance;

	public StudentCtr() {
		readStudents();
	}
	public void readStudents() {
		students = new ArrayList<Student>();
		String query = "SELECT * FROM student";
		try {
			ResultSet response = DBConnection.getInstance().select(query);
			while(response.next()){
				students.add(new Student(response));
				
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public static StudentCtr getInstance(){
		  if(instance == null) instance = new StudentCtr();
		  return instance;
		}
	public ArrayList<Student> getStudents(){
		return students;
	}
	public static void insertStudent(Student s) {
		String query = "INSERT INTO Student VALUES(" + s.toQuery() + ");";
		try {
			DBConnection.getInstance().executeInsertWithIdentity(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void deleteStudent(Student s) {
		String query = "DELETE FROM Student WHERE CPR =" + s.getCPR();
		try {
			DBConnection.getInstance().executeDelete(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void updateStudent(Student s, String newFN, String newLN, int newPhoneNum) {
		String query = "UPDATE Student" 
				+ (newFN != ""? "SET FirstName =" + newFN :"")
				+ (newLN != ""? "SET LastName = " + newLN :"")
				+ (newPhoneNum != 0 ? "SET PhoneNumber = " + String.valueOf(newPhoneNum) : "")
				+ "WHERE CPR=" + s.getCPR();
		try {
			DBConnection.getInstance().executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	

}
