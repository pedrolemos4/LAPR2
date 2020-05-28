/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.autorizacao.model;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author paulomaio
 */
public class RegistoUtilizadores
{
    private Set<Utilizador> m_lstUtilizadores = new HashSet<Utilizador>();
    
    
    public Utilizador novoUtilizador(String strNome, String strEmail, String strPassword)
    {
        return new Utilizador(strNome,strEmail,strPassword);
    }
    
    public boolean addUtilizador(Utilizador utlz)
    {
        if (utlz != null)
            return this.m_lstUtilizadores.add(utlz);
        return false;
    }
    
    public boolean removeUtilizador(Utilizador utlz)
    {
        if (utlz != null)
            return this.m_lstUtilizadores.remove(utlz);
        return false;
    }
    
    public Utilizador procuraUtilizador(String strId)
    {
        for(Utilizador utlz: this.m_lstUtilizadores)
        {
            if(utlz.hasId(strId))
                return utlz;
        }
        return null;
    }
    
    public boolean hasUtilizador(String strId)
    {
        Utilizador utlz = procuraUtilizador(strId);
        if (utlz != null)
            return this.m_lstUtilizadores.contains(utlz);
        return false;
    }
    
    public boolean hasUtilizador(Utilizador utlz)
    {
        return this.m_lstUtilizadores.contains(utlz);
    }
}
