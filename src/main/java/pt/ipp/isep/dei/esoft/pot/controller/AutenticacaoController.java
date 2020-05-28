/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.controller;

import java.util.List;
import pt.ipp.isep.dei.esoft.autorizacao.model.PapelUtilizador;

/**
 *
 * @author paulomaio
 */
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
