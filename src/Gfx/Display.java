package Gfx;

import utils.Handler;

import javax.swing.*;
import java.awt.*;

public class Display extends JFrame {
	private static final long serialVersionUID = 1L;

	public Display(Handler handler) {
        this.setTitle("Dashboard");
        this.setPreferredSize(new Dimension(handler.getWidth(), handler.getHeight()));
        this.setResizable(true);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
