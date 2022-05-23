package Gfx;

import utils.Handler;
import javax.swing.*;
import java.awt.*;

/*the class is used to display the differents states*/

public class Display extends JFrame {
	private static final long serialVersionUID = 1L;
	private CardLayout cl = new CardLayout();
	private JPanel mainPanel;

	public Display(Handler handler) {
        this.setTitle("Dashboard");
        this.setPreferredSize(new Dimension(handler.getWidth(), handler.getHeight()));
        this.setResizable(true);
        mainPanel = new JPanel(cl);
        this.add(mainPanel);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
    }	
	public JPanel getMainPanel() {
		return mainPanel; 
		}
	public void show(String state){
		cl.show(mainPanel, state);
		}
}
