package state;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;

import javax.swing.*;
import controlLayer.BookingCtr;
import controlLayer.StudentCtr;
import model.Booking;
import model.Student;
import utils.Handler;

//third state, Menu where we enter the info of the student and the starting date

public class BookingState extends State{
	private static final long serialVersionUID = 1L;
	
	JTextField  firstNameField, lastNameField, phoneNumberField, cprField, startDateField;
	JLabel firstNameLabel, lastNameLabel, phoneNumberLabel, cprLabel, startDateLabel;

	public BookingState(Handler handler, String data) {
		super(handler);
		firstNameLabel = new JLabel("First Name");
		lastNameLabel = new JLabel("Last Name");
		phoneNumberLabel = new JLabel("Phone Number");
		cprLabel = new JLabel("CPR");
		startDateLabel = new JLabel("Start Date(YYYY-MM-DD)");
		firstNameField = new JTextField();
		lastNameField = new JTextField();
		phoneNumberField = new JTextField();
		cprField = new JTextField();
		startDateField = new JTextField();
		this.setLayout(new GridLayout(6, 2));
		this.add(firstNameLabel);
		this.add(firstNameField);
		this.add(lastNameLabel);
		this.add(lastNameField);
		this.add(phoneNumberLabel);
		this.add(phoneNumberField);
		this.add(cprLabel);
		this.add(cprField);
		this.add(startDateLabel);
		this.add(startDateField);
		//getting all the info
		System.out.println(BookingCtr.getInstance().getLastBookingId());
		JButton button = new JButton("Create Booking");
		button.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				//creating new Student 
				try {
					Student student = new Student(firstNameField.getText(),lastNameField.getText(),
							phoneNumberField.getText(),cprField.getText());
					StudentCtr.insertStudent(student);
					//creating new Booking
					try {
						BookingCtr.insertBooking(new Booking(BookingCtr.getInstance().getLastBookingId()+1, Date.valueOf(startDateField.getText())), 
								cprField.getText(), 
								Integer.parseInt(data.substring(0, data.length() - 1)) );
					} catch (NumberFormatException|SQLException e1) {
						StudentCtr.deleteStudent(student);
						e1.printStackTrace();
					}
				} catch (SQLException e2) {					
					e2.printStackTrace();
				}
				                 
				//returning to the dashboard
				State.changeState(new DashboardState(handler), handler);
			}
		});
		this.add(button);
		
		
	}

}
