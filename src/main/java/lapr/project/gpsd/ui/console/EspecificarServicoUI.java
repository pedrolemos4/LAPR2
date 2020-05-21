/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.ui.console;

import java.util.List;
import lapr.project.gpsd.controller.EspecificarServicoController;
import lapr.project.gpsd.model.Categoria;
import lapr.project.gpsd.ui.console.utils.Utils;

/**
 *
 * @author paulomaio
 */
public class EspecificarServicoUI
{
    private EspecificarServicoController m_controller;
    public EspecificarServicoUI()
    {
        m_controller = new EspecificarServicoController();
    }

    public void run()
    {
        System.out.println("\nEspecificar Serviço:");

        if(introduzDados())
        {
            apresentaDados();

            if (Utils.confirma("Confirma os dados introduzidos? (S/N)")) {
                if (m_controller.registaServico()) {
                    System.out.println("Registo efetuado com sucesso.");
                } else {
                    System.out.println("Não foi possivel concluir o registo com sucesso.");
                }
            }
        }
        else
        {
            System.out.println("Ocorreu um erro. Operação cancelada.");
        }
    }
    
    private boolean introduzDados() {
        String strId = Utils.readLineFromConsole("Id: ");
        String strDescricaoBreve = Utils.readLineFromConsole("Descrição Breve: ");
        String strDescricaoCompleta = Utils.readLineFromConsole("Descrição Completa: ");
        double dCusto = Utils.readDoubleFromConsole("Custo Hora: ");
        
        List<Categoria> lc = m_controller.getCategorias();
        
        String catId = "";
        Categoria c = (Categoria)Utils.apresentaESeleciona(lc, "Selecione a categoria a que o serviço pertence:");
        if (c != null)
            catId = c.getCodigo();
        
        return m_controller.novoServico(strId, strDescricaoBreve,strDescricaoCompleta,dCusto,catId);
    }
    
    private void apresentaDados() 
    {
        System.out.println("\nServiço:\n" + m_controller.getServicoString());
    }
      
}
