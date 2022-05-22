package state;

import utils.Handler;
import java.awt.*;
import javax.swing.JPanel;

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
    }
}