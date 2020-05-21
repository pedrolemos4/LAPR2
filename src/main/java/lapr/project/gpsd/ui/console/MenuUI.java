/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lapr.project.gpsd.ui.console;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lapr.project.autorizacao.model.PapelUtilizador;
import lapr.project.gpsd.ui.console.utils.Utils;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class MenuUI
{

    public MenuUI()
    {
    }

    public void run() throws IOException
    {
        List<String> options = new ArrayList<String>();
        options.add("Login / Autenticação");
        options.add("Efetuar Registo como Cliente");
        options.add("Submeter Candidatura a Prestador Serviço");
        int opcao = 0;
        do
        {            
            opcao = Utils.apresentaESelecionaIndex(options, "\n\nMenu Principal");

            switch(opcao)
            {
                case 0:
                    AutenticacaoUI uiLogin = new AutenticacaoUI();
                    boolean sucesso = uiLogin.run();
                    if (sucesso)
                    {
                        redirecionaParaUI(uiLogin.getPapeisUtilizador());
                    }
                    uiLogin.logout();
                    break;
                case 1:
                    RegistarClienteUI ui = new RegistarClienteUI();
                    ui.run();
                    break;
                case 2:
                    //
                    break;
                    
            }

            // Incluir as restantes opções aqui
            
        }
        while (opcao != -1 );
    }

    private void redirecionaParaUI(List<PapelUtilizador> papeis)
    {
       if (papeis == null)
           return;
       
       if (papeis.isEmpty())
           return;
                  
       PapelUtilizador papel = selecionaPapel(papeis);
       
       if (papel.hasId("ADMINISTRATIVO"))
       {
           MenuAdministrativoUI ui = new MenuAdministrativoUI();
           ui.run();
       }
       if (papel.hasId("CLIENTE"))
       {
           MenuClienteUI ui = new MenuClienteUI();
           ui.run();
       }
    }

    private PapelUtilizador selecionaPapel(List<PapelUtilizador> papeis)
    {
        if (papeis.size() == 1)
            return papeis.get(0);
        else
           return (PapelUtilizador)Utils.apresentaESeleciona(papeis, "Escolha o papel que pretende assumir:");
    }
}
