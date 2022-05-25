package state;

import utils.Handler;
import java.awt.*;
import javax.swing.JPanel;

/*the state class is used to Manage the graphic part of all states at the same time
 * it is also used (static part) to manage the transition from one state to another*/

public abstract class State extends JPanel {
	
    /* --------------- STATIC --------------- */
	private static final long serialVersionUID = 1L;
	
	private static State currentState = null;
	
    public static void changeState(State state, Handler handler) {
    	handler.getMainPanel().add(state, "currentState");
    	if(currentState != null) handler.getMainPanel().remove(currentState);
    	currentState = state;
    	handler.getDisplay().show("currentState");
    	
    }

    public static State getState() {
        return currentState;
    }

    /* --------------- CLASS --------------- */

    protected Handler handler;

    State(Handler handler) {
        this.handler = handler;
        this.setPreferredSize(new Dimension(handler.getHeight(), handler.getHeight()));
        this.setBackground(new Color(0xe1e1e1)); 
        //background for all the states rather than putting it in each state
    }
}