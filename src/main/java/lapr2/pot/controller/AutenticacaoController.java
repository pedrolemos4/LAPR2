
package lapr2.pot.controller;

import java.util.List;
import lapr2.autorizacao.model.PapelUtilizador;


public class AutenticacaoController
{
    private AplicacaoPOT m_oApp;
    
    public AutenticacaoController()
    {
        this.m_oApp = AplicacaoPOT.getInstance();
    }
    
    public boolean doLogin(String strId, String strPwd)
    {
        return this.m_oApp.doLogin(strId, strPwd);
    }
    
    public List<PapelUtilizador> getPapeisUtilizador()
    {
        if (this.m_oApp.getSessaoAtual().isLoggedIn())
        {
            return this.m_oApp.getSessaoAtual().getPapeisUtilizador();
        }
        return null;
    }

    public void doLogout()
    {
        this.m_oApp.doLogout();
    }
}
