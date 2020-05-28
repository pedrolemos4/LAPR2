

package lapr2.pot.ui.console;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lapr2.autorizacao.model.PapelUtilizador;
import lapr2.pot.ui.console.utils.Utils;


public class MenuUI
{

    public MenuUI()
    {
    }

    public void run() throws IOException
    {
        List<String> options = new ArrayList<String>();
        options.add("Login / Autenticação");
        options.add("Registar Organização");
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
                    RegistarOrganizacaoUI ui = new RegistarOrganizacaoUI();
                    ui.run();
                    break;           
            }
        }
        while (opcao != -1 );
    }

    private void redirecionaParaUI(List<PapelUtilizador> papeis)
    {
       if (papeis == null)
       {
           System.out.println("O utilizador não tem atribuído nenhum papel/função.");
           return;
       }
       if (papeis.isEmpty())
       {
           System.out.println("O utilizador não tem atribuído nenhum papel/função.");
           return;
       }          
       PapelUtilizador papel = selecionaPapel(papeis);
       
       if (papel.hasId("ADMINISTRATIVO"))
       {
           MenuAdministrativoUI ui = new MenuAdministrativoUI();
           ui.run();
       }
       if (papel.hasId("GESTOR_ORGANIZACAO"))
       {
           MenuGestorOrganizacaoUI ui = new MenuGestorOrganizacaoUI();
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
