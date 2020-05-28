
package lapr2.pot.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lapr2.pot.model.AreaAtividade;
import lapr2.pot.model.Constantes;
import lapr2.pot.model.Plataforma;
import lapr2.pot.model.CompetenciaTecnica;
import lapr2.pot.ui.console.utils.Utils;


public class EspecificarCompetenciaTecnicaController
{
    private Plataforma m_oPlataforma;
    private CompetenciaTecnica m_oCompetencia;
    public EspecificarCompetenciaTecnicaController()
    {
        if(!AplicacaoPOT.getInstance().getSessaoAtual().isLoggedInComPapel(Constantes.PAPEL_ADMINISTRATIVO))
            throw new IllegalStateException("Utilizador não Autorizado");
        this.m_oPlataforma = AplicacaoPOT.getInstance().getPlataforma();
    }
    
    public List<AreaAtividade> getAreasAtividade()
    {
        return this.m_oPlataforma.getAreasAtividade();
    }
    
    public boolean novaCompetenciaTecnica(String strId, String strDescricaoBreve, String strDescricaoDetalhada, String areaAtividadeId)
    {
        try
        {
            AreaAtividade area = this.m_oPlataforma.getAreaAtividadeById(areaAtividadeId);
            this.m_oCompetencia = this.m_oPlataforma.novaCompetenciaTecnica(strId, strDescricaoBreve,strDescricaoDetalhada,area);
            return this.m_oPlataforma.validaCompetenciaTecnica(this.m_oCompetencia);
        }
        catch(RuntimeException ex)
        {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            this.m_oCompetencia = null;
            return false;
        }
    }
   
    
    public boolean registaCompetenciaTecnica()
    {
        return this.m_oPlataforma.registaCompetenciaTecnica(this.m_oCompetencia);
    }

    public String getCompetenciaTecnicaString()
    {
        return this.m_oCompetencia.toString();
    }
}
