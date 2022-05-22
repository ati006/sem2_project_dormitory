package utils;

import javax.swing.JPanel;
import Gfx.Display;

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
