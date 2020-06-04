package com.mycompany.lapr2_interfacegrafica.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import com.mycompany.lapr2_interfacegrafica.authorization.FacadeAuthorization;
import com.mycompany.lapr2_interfacegrafica.authorization.model.UserSession;
import com.mycompany.lapr2_interfacegrafica.model.Constants;
import com.mycompany.lapr2_interfacegrafica.model.Platform;

public class POTApplication {

    private final Platform m_oPlataforma;
    private final FacadeAuthorization m_oAutorizacao;

    private POTApplication() {
        Properties props = getProperties();
        this.m_oPlataforma = new Platform(props.getProperty(Constants.PARAMS_PLATAFORMA_DESIGNACAO));
        this.m_oAutorizacao = this.m_oPlataforma.getFacadeAuthorization();
        bootstrap();
    }

    public Platform getPlataforma() {
        return this.m_oPlataforma;
    }

    public UserSession getSessaoAtual() {
        return this.m_oAutorizacao.getCurrentSession();
    }

    public boolean doLogin(String strId, String strPwd) {
        return this.m_oAutorizacao.doLogin(strId, strPwd) != null;
    }

    public void doLogout() {
        this.m_oAutorizacao.doLogout();
    }

    private Properties getProperties() {
        Properties props = new Properties();

        // Adiciona propriedades e valores por omissão
        props.setProperty(Constants.PARAMS_PLATAFORMA_DESIGNACAO, "Task for Joe");

        // Lê as propriedades e valores definidas 
        try {
            InputStream in = new FileInputStream(Constants.PARAMS_FICHEIRO);
            props.load(in);
            in.close();
        } catch (IOException ex) {

        }
        return props;
    }

    private void bootstrap() {
        this.m_oAutorizacao.registaPapelUtilizador(Constants.PAPEL_ADMINISTRATIVO);
        this.m_oAutorizacao.registaPapelUtilizador(Constants.PAPEL_FREELANCER);
        this.m_oAutorizacao.registaPapelUtilizador(Constants.PAPEL_GESTOR_ORGANIZACAO);
        this.m_oAutorizacao.registaPapelUtilizador(Constants.PAPEL_COLABORADOR_ORGANIZACAO);

        this.m_oAutorizacao.registaUtilizadorComPapel("Administrativo 1", "adm1@esoft.pt", "123456", Constants.PAPEL_ADMINISTRATIVO);
        this.m_oAutorizacao.registaUtilizadorComPapel("Administrativo 2", "adm2@esoft.pt", "123456", Constants.PAPEL_ADMINISTRATIVO);

        this.m_oAutorizacao.registaUtilizadorComPapel("Freelancer 1", "free1@esoft.pt", "123456", Constants.PAPEL_FREELANCER);
        this.m_oAutorizacao.registaUtilizadorComPapel("Freelancer 2", "free2@esoft.pt", "123456", Constants.PAPEL_FREELANCER);

        this.m_oAutorizacao.registaUtilizadorComPapeis("Martim", "martim@esoft.pt", "123456", new String[]{Constants.PAPEL_FREELANCER, Constants.PAPEL_ADMINISTRATIVO});
    }

    // Inspirado em https://www.javaworld.com/article/2073352/core-java/core-java-simply-singleton.html?page=2
    private static POTApplication singleton = null;

    public static POTApplication getInstance() {
        if (singleton == null) {
            synchronized (POTApplication.class) {
                singleton = new POTApplication();
            }
        }
        return singleton;
    }

}
