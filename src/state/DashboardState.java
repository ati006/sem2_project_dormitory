package state;

import utils.Handler;
import javax.swing.*;
import java.awt.event.*;

/*first state, main menu, inherit from State*/

public class DashboardState extends State {

	private static final long serialVersionUID = 1L;

	public DashboardState(Handler handler) {
		super(handler);
		JButton button = new JButton("Create Booking");
		button.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				State.changeState(new MapReservationState(handler), handler); 

				//on click the state change to the second one
			}
		});
		JButton button2 = new JButton("Student Gestion");
		button2.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				State.changeState(new StudentGestionState(handler), handler);
			}
		});
		this.add(button);
		this.add(button2);
	}
}
