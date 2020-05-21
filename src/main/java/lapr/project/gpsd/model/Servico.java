/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.util.Objects;

/**
 *
 * @author paulomaio
 */
public class Servico
{
    private String m_strId;
    private String m_strDescricaoBreve;
    private String m_strDescricaoCompleta;
    private double m_dCustoHora;
    private Categoria m_oCategoria;
    
    public Servico(String strId, String strDescricaoBreve, String strDescricaoCompleta, double dCustoHora, Categoria oCategoria)
    {
        if ( (strId == null) || (strDescricaoBreve == null) || (strDescricaoCompleta == null) ||
                (dCustoHora < 0) || (oCategoria == null) ||
                (strId.isEmpty())|| (strDescricaoBreve.isEmpty()) || (strDescricaoCompleta.isEmpty()))
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");
        
        this.m_strId = strId;
        this.m_strDescricaoBreve = strDescricaoBreve;
        this.m_strDescricaoCompleta = strDescricaoCompleta;
        this.m_dCustoHora = dCustoHora;
        m_oCategoria = oCategoria;
    }
    
    
    public boolean hasId(String strId)
    {
        return this.m_strId.equalsIgnoreCase(strId);
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.m_strId);
        return hash;
    }
    
    @Override
    public boolean equals(Object o) {
        // Inspirado em https://www.sitepoint.com/implement-javas-equals-method-correctly/
        
        // self check
        if (this == o)
            return true;
        // null check
        if (o == null)
            return false;
        // type check and cast
        if (getClass() != o.getClass())
            return false;
        // field comparison
        Servico obj = (Servico) o;
        return (Objects.equals(m_strId, obj.m_strId));
    }
    
    @Override
    public String toString()
    {
        return String.format("%s - %s - %s - %.2f - Categoria: %s", this.m_strId, this.m_strDescricaoBreve, this.m_strDescricaoCompleta, this.m_dCustoHora, this.m_oCategoria.toString());
    }
    
}
