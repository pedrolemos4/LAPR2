
package lapr2.autorizacao;

import lapr2.autorizacao.model.PapelUtilizador;
import lapr2.autorizacao.model.RegistoPapeisUtilizador;
import lapr2.autorizacao.model.RegistoUtilizadores;
import lapr2.autorizacao.model.SessaoUtilizador;
import lapr2.autorizacao.model.Utilizador;


public class AutorizacaoFacade
{
    private SessaoUtilizador m_oSessao = null;
    
    private final RegistoPapeisUtilizador m_oPapeis = new RegistoPapeisUtilizador();
    private final RegistoUtilizadores m_oUtilizadores = new RegistoUtilizadores();
    
    public boolean registaPapelUtilizador(String strPapel)
    {
        PapelUtilizador papel = this.m_oPapeis.novoPapelUtilizador(strPapel);
        return this.m_oPapeis.addPapel(papel);
    }
    
    public boolean registaPapelUtilizador(String strPapel, String strDescricao)
    {
        PapelUtilizador papel = this.m_oPapeis.novoPapelUtilizador(strPapel,strDescricao);
        return this.m_oPapeis.addPapel(papel);
    }
    
    public boolean registaUtilizador(String strNome, String strEmail, String strPassword)
    {
        Utilizador utlz = this.m_oUtilizadores.novoUtilizador(strNome,strEmail,strPassword);
        return this.m_oUtilizadores.addUtilizador(utlz);
    }
    
    public boolean registaUtilizadorComPapel(String strNome, String strEmail, String strPassword, String strPapel)
    {
        PapelUtilizador papel = this.m_oPapeis.procuraPapel(strPapel);
        Utilizador utlz = this.m_oUtilizadores.novoUtilizador(strNome,strEmail,strPassword);
        utlz.addPapel(papel);
        return this.m_oUtilizadores.addUtilizador(utlz);
    }
    
    public boolean registaUtilizadorComPapeis(String strNome, String strEmail, String strPassword, String[] papeis)
    {
        Utilizador utlz = this.m_oUtilizadores.novoUtilizador(strNome,strEmail,strPassword);
        for (String strPapel: papeis)
        {
            PapelUtilizador papel = this.m_oPapeis.procuraPapel(strPapel);
            utlz.addPapel(papel);
        }
        
        return this.m_oUtilizadores.addUtilizador(utlz);
    }
    
    public boolean existeUtilizador(String strId)
    {
        return this.m_oUtilizadores.hasUtilizador(strId);
    }
    
    
    public SessaoUtilizador doLogin(String strId, String strPwd)
    {
        Utilizador utlz = this.m_oUtilizadores.procuraUtilizador(strId);
        if (utlz != null)
        {
            if (utlz.hasPassword(strPwd)){
                this.m_oSessao = new SessaoUtilizador(utlz);
            }
        }
        return getSessaoAtual();
    }
    
    public SessaoUtilizador getSessaoAtual()
    {
        return this.m_oSessao;
    }
    
    public void doLogout()
    {
        if (this.m_oSessao != null)
            this.m_oSessao.doLogout();
        this.m_oSessao = null;
    }
}
