/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lapr.project.gpsd.model.Categoria;
import lapr.project.gpsd.model.Constantes;
import lapr.project.gpsd.model.Empresa;
import lapr.project.gpsd.model.Servico;
import lapr.project.gpsd.ui.console.utils.Utils;

/**
 *
 * @author paulomaio
 */
public class EspecificarServicoController
{
    private Empresa m_oEmpresa;
    private Servico m_oServico;
    public EspecificarServicoController()
    {
        if(!AplicacaoGPSD.getInstance().getSessaoAtual().isLoggedInComPapel(Constantes.PAPEL_ADMINISTRATIVO))
            throw new IllegalStateException("Utilizador não Autorizado");
        this.m_oEmpresa = AplicacaoGPSD.getInstance().getEmpresa();
    }
    
    public List<Categoria> getCategorias()
    {
        return this.m_oEmpresa.getCategorias();
    }
    
    public boolean novoServico(String strId, String strDescricaoBreve, String strDescricaoCompleta, double dCustoHora, String categoriaId)
    {
        try
        {
            Categoria cat = this.m_oEmpresa.getCategoriaById(categoriaId);
            this.m_oServico = this.m_oEmpresa.novoServico(strId, strDescricaoBreve,strDescricaoCompleta,dCustoHora,cat);
            return this.m_oEmpresa.validaServico(this.m_oServico);
        }
        catch(RuntimeException ex)
        {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            this.m_oServico = null;
            return false;
        }
    }
   
    
    public boolean registaServico()
    {
        return this.m_oEmpresa.registaServico(this.m_oServico);
    }

    public String getServicoString()
    {
        return this.m_oServico.toString();
    }
}
