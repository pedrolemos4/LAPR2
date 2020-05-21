/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.ui.console;

import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.ui.console.utils.Utils;

/**
 *
 * @author paulomaio
 */
public class MenuAdministrativoUI
{

    public MenuAdministrativoUI()
    {
    }

    public void run() 
    {
        List<String> options = new ArrayList<String>();
        options.add("Especificar Categoria (de Serviço)");
        options.add("Especificar Serviço");
        options.add("Especificar Área Geográfica");
        
        int opcao = 0;
        do
        {            
            opcao = Utils.apresentaESelecionaIndex(options, "\n\nMenu Administrativo");

            switch(opcao)
            {
                case 0:
                    EspecificarCategoriaUI uiCat = new EspecificarCategoriaUI();
                    uiCat.run();
                    break;
                case 1:
                    EspecificarServicoUI uiServ = new EspecificarServicoUI();
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
