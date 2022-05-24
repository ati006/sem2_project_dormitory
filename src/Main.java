
import Gfx.Display;
import state.*;
import utils.Handler;


public class Main {
    public static void main(String[] args) {
    	
        Handler handler = new Handler(500, 500);
        handler.setDisplay(new Display(handler));
        State.changeState(new DashboardState(handler),handler);
    }
}