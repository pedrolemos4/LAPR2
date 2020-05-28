
package lapr2.pot.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import lapr2.pot.model.Colaborador;
import lapr2.pot.model.Organizacao;
import lapr2.pot.model.Plataforma;
import lapr2.pot.model.EnderecoPostal;
import lapr2.pot.ui.console.utils.Utils;


public class RegistarOrganizacaoController
{
    private AplicacaoPOT m_oApp;
    private Plataforma m_oPlataforma;
    private Organizacao m_oOrganizacao;
    private String m_strPwd;
    public RegistarOrganizacaoController()
    {
        this.m_oApp = AplicacaoPOT.getInstance();
        this.m_oPlataforma = m_oApp.getPlataforma();
    }
    
    
    public boolean novaOrganizacao(String strNome, String strNIF, String strWebsite, String strTelefone, 
            String strEmail, String strLocal, String strCodPostal, String strLocalidade,
            String strNomeGestor, String strFuncaoGestor, String strEmailGestor,  String strTelefoneGestor,String strPwd)
    {
        try
        {
            this.m_strPwd = strPwd;
            EnderecoPostal oMorada = Organizacao.novoEnderecoPostal(strLocal, strCodPostal, strLocalidade);
            Colaborador oColab = Organizacao.novoColaborador(strNomeGestor, strFuncaoGestor, strTelefoneGestor, strEmailGestor);      
            this.m_oOrganizacao = this.m_oPlataforma.novaOrganizacao(strNome, strNIF, strWebsite,strTelefone, strEmail, oMorada, oColab);
            return this.m_oPlataforma.validaOrganizacao(this.m_oOrganizacao, this.m_strPwd);
        }
        catch(RuntimeException ex)
        {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            this.m_oOrganizacao = null;
            return false;
        }
    }
    
    
    public boolean registaOrganizacao()
    {
        return this.m_oPlataforma.registaOrganizacao(this.m_oOrganizacao, this.m_strPwd);
    }

    public String getOrganizacaoString()
    {
        return this.m_oOrganizacao.toString();
    }
}
