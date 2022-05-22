package state;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import utils.Handler;
import model.Bedroom;
import java.util.ArrayList;


public class MapReservationState extends State{

	private static final long serialVersionUID = 1L;

	public MapReservationState(Handler handler) {
		super(handler);
		this.setLayout(new GridLayout(3, 3));
		ArrayList<Bedroom> bedrooms = new ArrayList<Bedroom>();
		bedrooms.add(new Bedroom(1, "",1, "C"));
		bedrooms.add(new Bedroom(1, "",2, "E"));
		bedrooms.add(new Bedroom(1, "",3, "C"));
		bedrooms.add(new Bedroom(1, "",4, "E"));
		bedrooms.add(new Bedroom(1, "",5, "E"));
		bedrooms.add(new Bedroom(1, "",6, "E"));
		bedrooms.add(new Bedroom(1, "",7, "C"));
		bedrooms.add(new Bedroom(1, "",8, "C"));
		bedrooms.add(new Bedroom(1, "",61, "F"));
		createButtons(bedrooms);
		
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
