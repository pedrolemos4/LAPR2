
package lapr2.pot.ui.console;

import java.util.ArrayList;
import java.util.List;
import lapr2.pot.ui.console.utils.Utils;


public class MenuAdministrativoUI
{

    public MenuAdministrativoUI()
    {
    }

    public void run() 
    {
        List<String> options = new ArrayList<String>();
        options.add("Especificar Área de Atividade ");
        options.add("Especificar Competência Técnica");
        options.add("Especificar Categoria de Tarefa");
        
        int opcao = 0;
        do
        {            
            opcao = Utils.apresentaESelecionaIndex(options, "\n\nMenu Administrativo");

            switch(opcao)
            {
                case 0:
                    EspecificarAreaAtividadeUI uiCat = new EspecificarAreaAtividadeUI();
                    uiCat.run();
                    break;
                case 1:
                    EspecificarCompetenciaTecnicaUI uiServ = new EspecificarCompetenciaTecnicaUI();
                    uiServ.run();
                    break;
                
                case 2:
                    break;
            }

            // Incluir as restantes opções aqui
            
        }
        while (opcao != -1 );
    }
}
