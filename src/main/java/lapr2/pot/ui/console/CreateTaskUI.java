
package lapr2.pot.ui.console;

import java.util.List;
import lapr2.pot.controller.CreateTaskController;
import lapr2.pot.controller.EspecificarCompetenciaTecnicaController;
import lapr2.pot.model.AreaAtividade;
import lapr2.pot.ui.console.utils.Utils;


public class CreateTaskUI
{
    private CreateTaskController controller;
    public CreateTaskUI()
    {
        controller = new CreateTaskController();
    }

    public void run()
    {
        System.out.println("\nCreate New Task:");

        if(enterData())
        {
            apresentaDados();

            if (Utils.confirma("Confirm entered data (Y/N)")) {
                if (controller.registerTask()) {
                    System.out.println("Task successfully registered.");
                } else {
                    System.out.println("Unable to complete action.");
                }
            }
        }
        else
        {
            System.out.println("An error occured. Action canceled.");
        }
    }
    
    private boolean enterData() {
        String id = Utils.readLineFromConsole("Id: ");
        String briefDescription = Utils.readLineFromConsole("Brief Description: ");
        int timeDuration = Utils.readIntegerFromConsole("Time duration: ");
        double costPerHour = Utils.readDoubleFromConsole("Cost per hour: ");
        String category = Utils.readLineFromConsole("Category: ");
        
        return controller.newTask(id, briefDescription, timeDuration, costPerHour, category);
    }
    
    private void apresentaDados() 
    {
        System.out.println("\nTask: \n" + controller.getTaskAsString());
    }
      
}
