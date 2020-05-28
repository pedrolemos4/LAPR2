
package lapr2.pot.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import lapr2.autorizacao.AutorizacaoFacade;
import lapr2.autorizacao.model.SessaoUtilizador;
import lapr2.pot.model.Constantes;
import lapr2.pot.model.Plataforma;


public class AplicacaoPOT
{
       
    private final Plataforma m_oPlataforma;
    private final AutorizacaoFacade m_oAutorizacao;
    
    private AplicacaoPOT()
    {
        Properties props = getProperties();
        this.m_oPlataforma = new Plataforma(props.getProperty(Constantes.PARAMS_PLATAFORMA_DESIGNACAO));
        this.m_oAutorizacao = this.m_oPlataforma.getAutorizacaoFacade();
        bootstrap();
    }
    
    public Plataforma getPlataforma()
    {
        return this.m_oPlataforma;
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
        props.setProperty(Constantes.PARAMS_PLATAFORMA_DESIGNACAO, "Task for Joe");

        
        // Lê as propriedades e valores definidas 
        try
        {
            InputStream in = new FileInputStream(Constantes.PARAMS_FICHEIRO);
            props.load(in);
            in.close();
        }
        catch(IOException ex)
        {
            
        }
        return props;
    }

    
    private void bootstrap()
    {
        this.m_oAutorizacao.registaPapelUtilizador(Constantes.PAPEL_ADMINISTRATIVO);
        this.m_oAutorizacao.registaPapelUtilizador(Constantes.PAPEL_FREELANCER);
        this.m_oAutorizacao.registaPapelUtilizador(Constantes.PAPEL_GESTOR_ORGANIZACAO);
        this.m_oAutorizacao.registaPapelUtilizador(Constantes.PAPEL_COLABORADOR_ORGANIZACAO);
        
        this.m_oAutorizacao.registaUtilizadorComPapel("Administrativo 1", "adm1@esoft.pt", "123456",Constantes.PAPEL_ADMINISTRATIVO);
        this.m_oAutorizacao.registaUtilizadorComPapel("Administrativo 2", "adm2@esoft.pt", "123456",Constantes.PAPEL_ADMINISTRATIVO);
        
        this.m_oAutorizacao.registaUtilizadorComPapel("Freelancer 1", "free1@esoft.pt", "123456",Constantes.PAPEL_FREELANCER);
        this.m_oAutorizacao.registaUtilizadorComPapel("Freelancer 2", "free2@esoft.pt", "123456",Constantes.PAPEL_FREELANCER);
        
        this.m_oAutorizacao.registaUtilizadorComPapeis("Martim", "martim@esoft.pt", "123456",new String[] {Constantes.PAPEL_FREELANCER, Constantes.PAPEL_ADMINISTRATIVO});
    }
    
    // Inspirado em https://www.javaworld.com/article/2073352/core-java/core-java-simply-singleton.html?page=2
    private static AplicacaoPOT singleton = null;
    public static AplicacaoPOT getInstance() 
    {
        if(singleton == null) 
        {
            synchronized(AplicacaoPOT.class) 
            { 
                singleton = new AplicacaoPOT();
            }
        }
        return singleton;
    }

    
}
