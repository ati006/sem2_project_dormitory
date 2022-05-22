package state;

import java.awt.Color;
import utils.Handler;

public class DashboardState extends State {

	private static final long serialVersionUID = 1L;

	public DashboardState(Handler handler) {
		super(handler);
		this.setBackground(new Color(0x3C3F41));
	}

}
