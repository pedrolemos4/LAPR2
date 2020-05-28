

package lapr2.pot.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lapr2.autorizacao.AutorizacaoFacade;


public class Plataforma
{
    private String m_strDesignacao;
    private final AutorizacaoFacade m_oAutorizacao;
    private final Set<Organizacao> m_lstOrganizacoes;
    private final Set<AreaAtividade> m_lstAreasAtividade;
    private final Set<CompetenciaTecnica> m_lstCompetencias;
    

    public Plataforma(String strDesignacao)
    {
        if ( (strDesignacao == null) ||
                (strDesignacao.isEmpty()))
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");
        
        this.m_strDesignacao = strDesignacao;
      
        
        this.m_oAutorizacao = new AutorizacaoFacade();
        
        this.m_lstOrganizacoes = new HashSet<>();
        this.m_lstAreasAtividade = new HashSet<>();
        this.m_lstCompetencias = new HashSet<>();
    }
    
    public AutorizacaoFacade getAutorizacaoFacade()
    {
        return this.m_oAutorizacao;
    }
    
    // Organizações
    
    // <editor-fold defaultstate="collapsed">

    public Organizacao novaOrganizacao(String strNome, String strNIF, String strWebsite,String strTelefone, String strEmail, EnderecoPostal oMorada, Colaborador oGestor)
    {
        return new Organizacao(strNome,strNIF, strWebsite, strTelefone, strEmail, oMorada, oGestor);
    }

    public boolean registaOrganizacao(Organizacao oOrganizacao, String strPwd)
    {
        if (this.validaOrganizacao(oOrganizacao,strPwd))
        {
            Colaborador oGestor = oOrganizacao.getGestor();
            String strNomeGestor = oGestor.getNome();
            String strEmailGestor = oGestor.getEmail();
            if (this.m_oAutorizacao.registaUtilizadorComPapeis(strNomeGestor,strEmailGestor, strPwd, 
                    new String[] {Constantes.PAPEL_GESTOR_ORGANIZACAO,Constantes.PAPEL_COLABORADOR_ORGANIZACAO}))
                return addOrganizacao(oOrganizacao);
        }
        return false;
    }

    private boolean addOrganizacao(Organizacao oOrganizacao)
    {
        return m_lstOrganizacoes.add(oOrganizacao);
    }
    
    public boolean validaOrganizacao(Organizacao oOrganizacao,String strPwd)
    {
        boolean bRet = true;
        
        // Escrever aqui o código de validação
        if (this.m_oAutorizacao.existeUtilizador(oOrganizacao.getGestor().getEmail()))
            bRet = false;
        if (strPwd == null)
            bRet = false;
        if (strPwd.isEmpty())
            bRet = false;
        //
      
        return bRet;
    }

    // </editor-fold>
    
    
    // Competências Tecnicas
    
    // <editor-fold defaultstate="collapsed">
    
    public CompetenciaTecnica getCompetenciaTecnicaById(String strId)
    {
        for(CompetenciaTecnica oCompTecnica : this.m_lstCompetencias)
        {
            if (oCompTecnica.hasId(strId))
            {
                return oCompTecnica;
            }
        }
        
        return null;
    }

    public CompetenciaTecnica novaCompetenciaTecnica(String strId, String strDescricaoBreve, String strDescricaoCompleta, AreaAtividade oArea)
    {
        return new CompetenciaTecnica(strId, strDescricaoBreve,strDescricaoCompleta,oArea);
    }

    public boolean registaCompetenciaTecnica(CompetenciaTecnica oCompTecnica)
    {
        if (this.validaCompetenciaTecnica(oCompTecnica))
        {
            return addCompetenciaTecnica(oCompTecnica);
        }
        return false;
    }

    private boolean addCompetenciaTecnica(CompetenciaTecnica oCompTecnica)
    {
        return m_lstCompetencias.add(oCompTecnica);
    }
    
    public boolean validaCompetenciaTecnica(CompetenciaTecnica oCompTecnica)
    {
        boolean bRet = true;
        
        // Escrever aqui o código de validação
        
        //
      
        return bRet;
    }
    // </editor-fold>
    
    // Areas de Atividade 
    // <editor-fold defaultstate="collapsed">
            
    public AreaAtividade getAreaAtividadeById(String strId)
    {
        for(AreaAtividade area : this.m_lstAreasAtividade)
        {
            if (area.hasId(strId))
            {
                return area;
            }
        }
        
        return null;
    }

    public AreaAtividade novaAreaAtividade(String strCodigo, String strDescricaoBreve, String strDescricaoDetalhada)
    {
        return new AreaAtividade(strCodigo, strDescricaoBreve,strDescricaoDetalhada);
    }

    public boolean registaAreaAtividade(AreaAtividade oArea)
    {
        if (this.validaAreaAtividade(oArea))
        {
            return addAreaAtividade(oArea);
        }
        return false;
    }

    private boolean addAreaAtividade(AreaAtividade oArea)
    {
        return m_lstAreasAtividade.add(oArea);
    }
    
    public boolean validaAreaAtividade(AreaAtividade oArea)
    {
        boolean bRet = true;
        
        // Escrever aqui o código de validação
        
        //
      
        return bRet;
    }
    
    public List<AreaAtividade> getAreasAtividade()
    {
        List<AreaAtividade> lc = new ArrayList<>();
        lc.addAll(this.m_lstAreasAtividade);
        return lc;
    }
    
    // </editor-fold>


}
    
    
