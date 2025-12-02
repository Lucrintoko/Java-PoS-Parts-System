import javax.swing.SwingUtilities;
import menumodules.MainMenu;

public class PoSSystem
    {
        public static void main (String[] args)
            {
                //Executing
                SwingUtilities.invokeLater(() -> new MainMenu());
            }
    }