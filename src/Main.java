import Gfx.Display;
import state.*;
import utils.Handler;


public class Main {
    public static void main(String[] args) {
        /* Creating our handler */
        Handler handler = new Handler(500, 500);
        handler.setDisplay(new Display(handler));
        handler.getDisplay().add(new DashboardState(handler));         
    }
}