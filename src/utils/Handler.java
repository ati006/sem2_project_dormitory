package utils;

import javax.swing.JPanel;
import Gfx.Display;

/*the handler is intended to keep the information of the window in memory in order to reuse it during a change of state
currently only the size of the window is kept*/

public class Handler {
		private int width;
		private int height;
		private Display display;
		
		public Handler(int width, int height){
			this.width = width;
			this.height = height;
		}
		
		public int getWidth() {
			return width;
		}
		public int getHeight() {
			return height;
		}
		public Display getDisplay() {
			return display;
		}
		public void setDisplay(Display display) { 
			this.display = display; 
		} 
		public JPanel getMainPanel() {
			return display.getMainPanel(); 
			}
}
