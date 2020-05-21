/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import lapr.project.autorizacao.AutorizacaoFacade;
import lapr.project.autorizacao.model.SessaoUtilizador;
import lapr.project.gpsd.model.Constantes;
import lapr.project.gpsd.model.Empresa;

/**
 *
 * @author paulomaio
 */
public class AplicacaoGPSD
{
       
    private final Empresa m_oEmpresa;
    private final AutorizacaoFacade m_oAutorizacao;
    
    private AplicacaoGPSD()
    {
        Properties props = getProperties();
        this.m_oEmpresa = new Empresa(props.getProperty(Constantes.PARAMS_EMPRESA_DESIGNACAO),
                        props.getProperty(Constantes.PARAMS_EMPRESA_NIF));
        this.m_oAutorizacao = this.m_oEmpresa.getAutorizacaoFacade();
        bootstrap();
    }
    
    public Empresa getEmpresa()
    {
        return this.m_oEmpresa;
    }
    

    public SessaoUtilizador getSessaoAtual()
    {
        return this.m_oAutorizacao.getSessaoAtual();
    }
    
    public boolean doLogin(String strId, String strPwd)
    {
       return this.m_oAutorizacao.doLogin(strId,strPwd) != null;
    }
    
    public void doLogout()
    {
        this.m_oAutorizacao.doLogout();
    }
    
    private Properties getProperties()
    {
        Properties props = new Properties();
        
        // Adiciona propriedades e valores por omissão
        props.setProperty(Constantes.PARAMS_EMPRESA_DESIGNACAO, "Default Lda.");
        props.setProperty(Constantes.PARAMS_EMPRESA_NIF, "Default NIF");
        
        // Lê as propriedades e valores definidas 
        try
        {
            InputStream in = new FileInputStream(Constantes.PARAMS_FICHEIRO);
            props.load(in);
            in.close();
        }
        catch(Exception ex)
        {
            
        }
        return props;
    }

    
    private void bootstrap()
    {
        this.m_oAutorizacao.registaPapelUtilizador(Constantes.PAPEL_ADMINISTRATIVO);
        this.m_oAutorizacao.registaPapelUtilizador(Constantes.PAPEL_CLIENTE);
        this.m_oAutorizacao.registaPapelUtilizador(Constantes.PAPEL_FRH);
        this.m_oAutorizacao.registaPapelUtilizador(Constantes.PAPEL_PRESTADOR_SERVICO);
        
        this.m_oAutorizacao.registaUtilizadorComPapel("Administrativo 1", "adm1@esoft.pt", "123456",Constantes.PAPEL_ADMINISTRATIVO);
        this.m_oAutorizacao.registaUtilizadorComPapel("Administrativo 2", "adm2@esoft.pt", "123456",Constantes.PAPEL_ADMINISTRATIVO);
        
        this.m_oAutorizacao.registaUtilizadorComPapel("FRH 1", "frh1@esoft.pt", "123456",Constantes.PAPEL_FRH);
        this.m_oAutorizacao.registaUtilizadorComPapel("FRH 2", "frh2@esoft.pt", "123456",Constantes.PAPEL_FRH);
        
        this.m_oAutorizacao.registaUtilizadorComPapeis("Martim", "martim@esoft.pt", "123456",new String[] {Constantes.PAPEL_FRH, Constantes.PAPEL_ADMINISTRATIVO});
    }
    
    // Inspirado em https://www.javaworld.com/article/2073352/core-java/core-java-simply-singleton.html?page=2
    private static AplicacaoGPSD singleton = null;
    public static AplicacaoGPSD getInstance() 
    {
        if(singleton == null) 
        {
            synchronized(AplicacaoGPSD.class) 
            { 
                singleton = new AplicacaoGPSD();
            }
        }
        return singleton;
    }

    
}
