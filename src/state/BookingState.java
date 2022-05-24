package state;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import javax.swing.*;
import controlLayer.BookingCtr;
import controlLayer.StudentCtr;
import model.Booking;
import model.Student;
import utils.Handler;


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
		startDateLabel = new JLabel("Start Date");
		firstNameField = new JTextField();
		lastNameField = new JTextField();
		phoneNumberField = new JTextField(10);
		cprField = new JTextField(11);
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
		JButton button = new JButton("Create Booking");
		button.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				StudentCtr.insertStudent(new Student(firstNameField.getText(),lastNameField.getText(),Integer.valueOf(phoneNumberField.getText()),Integer.valueOf(cprField.getText())));
				BookingCtr.insertBooking(new Booking(BookingCtr.getInstance().getLastBookingId()+1, Date.valueOf(startDateField.getText())));
				State.changeState(new DashboardState(handler), handler);
			}
		});
		this.add(button);
		
		
	}

}
