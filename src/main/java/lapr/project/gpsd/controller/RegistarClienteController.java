/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import lapr.project.gpsd.model.Cliente;
import lapr.project.gpsd.model.Empresa;
import lapr.project.gpsd.model.EnderecoPostal;
import lapr.project.gpsd.ui.console.utils.Utils;

/**
 *
 * @author paulomaio
 */
public class RegistarClienteController
{
    private AplicacaoGPSD m_oApp;
    private Empresa m_oEmpresa;
    private Cliente m_oCliente;
    private String m_strPwd;
    public RegistarClienteController()
    {
        this.m_oApp = AplicacaoGPSD.getInstance();
        this.m_oEmpresa = m_oApp.getEmpresa();
    }
    
    
    public boolean novoCliente(String strNome, String strNIF, String strTelefone, String strEmail, String strPwd, String strLocal, String strCodPostal, String strLocalidade)
    {
        try
        {
            this.m_strPwd = strPwd;
            EnderecoPostal morada = Cliente.novoEnderecoPostal(strLocal, strCodPostal, strLocalidade);
            this.m_oCliente = this.m_oEmpresa.novoCliente(strNome, strNIF, strTelefone, strEmail, morada);
            return this.m_oEmpresa.validaCliente(this.m_oCliente, this.m_strPwd);
        }
        catch(RuntimeException ex)
        {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            this.m_oCliente = null;
            return false;
        }
    }
    
    public boolean addEnderecoPostal(String strLocal, String strCodPostal, String strLocalidade)
    {
        if (this.m_oCliente != null)
        {
            try
            {
                EnderecoPostal morada = Cliente.novoEnderecoPostal(strLocal, strCodPostal, strLocalidade);
                return this.m_oCliente.addEnderecoPostal(morada);
            }
            catch(RuntimeException ex)
            {
                Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        } 
        return false;
    }
    
    public boolean registaCliente()
    {
        return this.m_oEmpresa.registaCliente(this.m_oCliente, this.m_strPwd);
    }

    public String getClienteString()
    {
        return this.m_oCliente.toString();
    }
}
