
package lapr2.pot.ui.console;

import java.util.ArrayList;
import java.util.List;
import lapr2.pot.ui.console.utils.Utils;


public class MenuGestorOrganizacaoUI
{
    
    public MenuGestorOrganizacaoUI()
    {
    }

    public void run()
    {
        List<String> options = new ArrayList<String>();
        options.add("Especificar Colaborador da Organização");
        // Adicionar Aqui Outras Opções
        
        int opcao = 0;
        do
        {            
            opcao = Utils.apresentaESelecionaIndex(options, "\n\nMenu Gestor de Organização");

            switch(opcao)
            {
                case 0:
                    
                    break;
                case 1:
                    break;
                    
            }

            // Incluir as restantes opções aqui
            
        }
        while (opcao != -1 );
    }
}
