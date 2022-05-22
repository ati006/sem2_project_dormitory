package state;

import utils.Handler;
import javax.swing.*;
import java.awt.event.*;

public class DashboardState extends State {

	private static final long serialVersionUID = 1L;

	public DashboardState(Handler handler) {
		super(handler);
		JButton button = new JButton("Create Booking");
		button.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				State.changeState(new MapReservationState(handler), handler);
			}
		});
		this.add(button);
	}
}
