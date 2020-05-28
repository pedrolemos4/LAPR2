

package lapr2.esoft.pot.ui;

import lapr2.pot.ui.console.MenuUI;


public class Main
{
    public static void main(String[] args)
    {
        try
        {   //Exemplo
            MenuUI uiMenu = new MenuUI();

            uiMenu.run();
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
    }
}
