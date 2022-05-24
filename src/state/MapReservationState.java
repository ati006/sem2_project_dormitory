package state;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import controlLayer.BedroomCtr;
import utils.Handler;
import model.Bedroom;
import java.util.ArrayList;

/*second state, map of the bedrooms*/

public class MapReservationState extends State{

	private static final long serialVersionUID = 1L;

	public MapReservationState(Handler handler) {
		super(handler);
		this.setLayout(new GridLayout(9, 6));
		createButtons(BedroomCtr.getInstance().getBedrooms());
		
	}
	private void createButtons(ArrayList<Bedroom> bedrooms){
		  for(Bedroom bedroom : bedrooms)
			  this.add(bedroomButton(String.valueOf(bedroom.getRoomNumber()) + bedroom.getBedroomType()));
		}
	
	private JButton bedroomButton(String name) { 
		  JButton button = new JButton(name);
		  button.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	JButton button = (JButton) e.getSource();
		    	State.changeState(new BookingState(handler,button.getActionCommand()), handler);
		    }
		  });
		  return button;
	}

}
