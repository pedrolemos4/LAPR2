
package lapr2.autorizacao.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;


public class Utilizador
{
    private String m_strNome;
    private String m_strEmail;
    private String m_strPassword; // Não deveria guardar a password em "plain text"
    private Set<PapelUtilizador> m_lstPapeis = new HashSet<PapelUtilizador>();
    
    public Utilizador(String strNome, String strEmail, String strPassword)
    {
    
        if ( (strNome == null) || (strEmail == null) || (strPassword == null) || (strNome.isEmpty()) || (strEmail.isEmpty()) || (strPassword.isEmpty()))
            throw new IllegalArgumentException("Nenhum dos argumentos não pode ser nulo ou vazio.");
        
        this.m_strNome = strNome;
        this.m_strEmail = strEmail;
        this.m_strPassword = strPassword;
        
    }
    
    public String getId()
    {
        return this.m_strEmail;
    }
    
    public String getNome()
    {
        return this.m_strNome;
    }
    
    public String getEmail()
    {
        return this.m_strEmail;
    }
    
    public boolean hasId(String strId)
    {
        return this.m_strEmail.equals(strId);
    }
    
    public boolean hasPassword(String strPwd)
    {
        return this.m_strPassword.equals(strPwd);
    }
    
    public boolean addPapel(PapelUtilizador papel)
    {
        if (papel != null)
            return this.m_lstPapeis.add(papel);
        return false;
    }
    
    
    public boolean removePapel(PapelUtilizador papel)
    {
        if (papel != null)
            return this.m_lstPapeis.remove(papel);
        return false;
    }
    
    public boolean hasPapel(PapelUtilizador papel)
    {
        return this.m_lstPapeis.contains(papel);
    }
    
    public boolean hasPapel(String strPapel)
    {
        for(PapelUtilizador papel: this.m_lstPapeis)
        {
            if (papel.hasId(strPapel))
                return true;
        }
        return false;
    }
    
    public List<PapelUtilizador> getPapeis()
    {
        List<PapelUtilizador> list = new ArrayList<>();
        for(PapelUtilizador papel: this.m_lstPapeis)
            list.add(papel);
        return list;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.m_strEmail);
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
        Utilizador obj = (Utilizador) o;
        return Objects.equals(m_strEmail, obj.m_strEmail);
    }
    
    @Override
    public String toString()
    {
        return String.format("%s - %s", this.m_strNome, this.m_strEmail);
    }
}
