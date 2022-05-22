package state;

import utils.Handler;

import java.awt.*;

import javax.swing.JPanel;

public abstract class State extends JPanel {
    /* --------------- STATIC --------------- */
	private static final long serialVersionUID = 1L;
	
	private static State currentState = null;
    public static void setState(State state) {
        currentState = state;
    }

    public static State getState() {
        return currentState;
    }

    /* --------------- CLASS --------------- */

    protected Handler handler;

    State(Handler handler) {
        this.handler = handler;
        this.setPreferredSize(new Dimension(handler.getHeight(), handler.getHeight()));        
    }
    
}