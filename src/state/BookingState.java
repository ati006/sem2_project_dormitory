package state;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

import databaselayer.DBConnection;
import utils.Handler;


public class BookingState extends State{
	JTextField  textField1, textField2, textField3, textField4, textField5, textField6;
	JLabel label1, label2, label3, label4, label5, label6;

	public BookingState(Handler handler, String data) {
		super(handler);
		label1 = new JLabel("First Name");
		label2 = new JLabel("Last Name");
		label3 = new JLabel("Email");
		label4 = new JLabel("Phone Number");
		label5 = new JLabel("CPR");
		label6 = new JLabel("Start Date");
		textField1 = new JTextField();
		textField2 = new JTextField();
		textField3 = new JTextField();
		textField4 = new JTextField(10);
		textField5 = new JTextField(11);
		textField6 = new JTextField();
		this.setLayout(new GridLayout(6, 2));
		this.add(label1);
		this.add(textField1);
		this.add(label2);
		this.add(textField2);
		this.add(label3);
		this.add(textField3);
		this.add(label4);
		this.add(textField4);
		this.add(label5);
		this.add(textField5);
		this.add(label6);
		this.add(textField6);
		JButton button = new JButton("Create Booking");
		button.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				String query = "INSERT INTO Student VALUES ("+ textField1.getText() + "," +
						textField2.getText() + "," + textField4.getText() + "," + 
						textField5.getText()+");";
				Statement statement;
				try {
					statement = DBConnection.getInstance().getDBcon().createStatement();
					statement.executeUpdate(query);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				State.changeState(new DashboardState(handler), handler);
			}
		});
		this.add(button);
		
		
	}

}
