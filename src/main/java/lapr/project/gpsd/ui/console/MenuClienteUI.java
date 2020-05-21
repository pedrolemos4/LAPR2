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
public class MenuClienteUI
{
    
    public MenuClienteUI()
    {
    }

    public void run()
    {
        List<String> options = new ArrayList<String>();
        options.add("Efetuar Pedido Prestação de Serviços");
        // Adicionar Aqui Outras Opções
        
        int opcao = 0;
        do
        {            
            opcao = Utils.apresentaESelecionaIndex(options, "\n\nMenu Cliente");

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
