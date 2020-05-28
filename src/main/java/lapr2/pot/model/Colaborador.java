
package lapr2.pot.model;

import java.util.Objects;


public class Colaborador
{
    private String m_strNome;
    private String m_strFuncao;
    private String m_strTelefone;
    private String m_strEmail;
            
    
    public Colaborador(String strNome, String strFuncao, String strTelefone, String strEmail)
    {
        if ( (strNome == null) || (strFuncao == null) || (strTelefone == null) || (strEmail == null) ||
                (strNome.isEmpty())|| (strFuncao.isEmpty())|| (strTelefone.isEmpty())|| (strEmail.isEmpty()))
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");
        
        this.m_strNome = strNome;
        this.m_strFuncao = strFuncao;
        this.m_strTelefone = strTelefone;
        this.m_strEmail = strEmail;
    }
    
    public boolean hasId(String strId)
    {
        return this.m_strEmail.equalsIgnoreCase(strId);
    }
    
    public String getNome()
    {
        return this.m_strNome;
    }
    
    public String getEmail()
    {
        return this.m_strEmail;
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
        Colaborador obj = (Colaborador) o;
        return (Objects.equals(m_strEmail, obj.m_strEmail));
    }
    
    @Override
    public String toString()
    {
        return String.format("%s - %s - %s - %s", this.m_strNome, this.m_strFuncao, this.m_strTelefone, this.m_strEmail);
    }
}
