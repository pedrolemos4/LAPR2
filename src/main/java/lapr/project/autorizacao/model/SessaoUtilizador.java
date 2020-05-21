/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.autorizacao.model;

import java.util.List;

/**
 *
 * @author paulomaio
 */
public class SessaoUtilizador
{
    private Utilizador m_oUtilizador = null;
    
    private SessaoUtilizador()
    {
    }
    
    public SessaoUtilizador(Utilizador oUtilizador)
    {
        if (oUtilizador == null)
            throw new IllegalArgumentException("Argumento não pode ser nulo.");
        this.m_oUtilizador = oUtilizador;
    }
    
    public void doLogout()
    {
        this.m_oUtilizador = null;
    }
    
    public boolean isLoggedIn()
    {
        return this.m_oUtilizador != null;
    }
    
    public boolean isLoggedInComPapel(String strPapel)
    {
        if (isLoggedIn())
        {
            return this.m_oUtilizador.hasPapel(strPapel);
        }
        return false;
    }
    
    public String getNomeUtilizador()
    {
        if (isLoggedIn())
            this.m_oUtilizador.getNome();
        return null;
    }
    
    public String getIdUtilizador()
    {
        if (isLoggedIn())
            this.m_oUtilizador.getId();
        return null;
    }
    
    public String getEmailUtilizador()
    {
        if (isLoggedIn())
            this.m_oUtilizador.getEmail();
        return null;
    }
    
    public List<PapelUtilizador> getPapeisUtilizador()
    {
        return this.m_oUtilizador.getPapeis();
    }
}
