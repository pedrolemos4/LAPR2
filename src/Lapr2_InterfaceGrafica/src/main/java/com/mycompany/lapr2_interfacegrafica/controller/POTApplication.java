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

    public static Platform m_oPlatform = new Platform();
    public static FacadeAuthorization m_oAuthorization = new FacadeAuthorization();

    public POTApplication() {
        //Properties props = getProperties();
     //   System.out.println("Plataforma");
//        this.m_oPlataforma = new Platform();
//        this.m_oAutorizacao = this.m_oPlataforma.getFacadeAuthorization();
//        //bootstrap();
    }

    public static Platform getPlatform() {
        return m_oPlatform;
    }

    public static FacadeAuthorization getFacadeAuthorization(){
        return m_oAuthorization;
    }
    
    public static void setPlatform(Platform platform){
        m_oPlatform = platform;
    }
    
    public static void setAuthorizationFacade(FacadeAuthorization authorizationFacade){
        m_oAuthorization = authorizationFacade;
    }
//    
//    public UserSession getCurrentSession() {
//        return m_oAutorizacao.getCurrentSession();
//    }
//
//    public boolean doLogin(String strId, String strPwd) {
//        return m_oAutorizacao.doLogin(strId, strPwd) != null;
//    }
//
//    public void doLogout() {
//        m_oAutorizacao.doLogout();
//    }
//
//    private Properties getProperties() {
//        Properties props = new Properties();
//
//        // Adiciona propriedades e valores por omissão
//        props.setProperty(Constants.PARAMS_PLATFORM_DESIGNATION, "Task for Joe");
//
//        // Lê as propriedades e valores definidas 
//        try {
//            InputStream in = new FileInputStream(Constants.PARAMS_FICHEIRO);
//            props.load(in);
//            in.close();
//        } catch (IOException ex) {
//
//        }
//        return props;
//    }

//    private void bootstrap() {
//        this.m_oAutorizacao.registesUserRole(Constants.ADMINISTRATOR_ROLE);
////        this.m_oAutorizacao.registaPapelUtilizador(Constants.FREELANCER_ROLE);
////        this.m_oAutorizacao.registaPapelUtilizador(Constants.ORGANIZATION_MANAGER_ROLE);
////        this.m_oAutorizacao.registaPapelUtilizador(Constants.ORGANIZATION_COLLABORATOR_ROLE);
//
//        this.m_oAutorizacao.registesUserWithRole("Administrativo 1", "adm1@esoft.pt", "123456", Constants.ADMINISTRATOR_ROLE);
//        this.m_oAutorizacao.registesUserWithRole("Administrativo 2", "adm2@esoft.pt", "123456", Constants.ADMINISTRATOR_ROLE);
////
////        this.m_oAutorizacao.registaUtilizadorComPapel("Freelancer 1", "free1@esoft.pt", "123456", Constants.FREELANCER_ROLE);
////        this.m_oAutorizacao.registaUtilizadorComPapel("Freelancer 2", "free2@esoft.pt", "123456", Constants.FREELANCER_ROLE);
////
////        this.m_oAutorizacao.registaUtilizadorComPapeis("Martim", "martim@esoft.pt", "123456", new String[]{Constants.FREELANCER_ROLE, Constants.ADMINISTRATOR_ROLE});
//    }
//    // Inspirado em https://www.javaworld.com/article/2073352/core-java/core-java-simply-singleton.html?page=2
//    private static POTApplication singleton = null;
//
//    public static POTApplication getInstance() {
//        if (singleton == null) {
//            synchronized (POTApplication.class) {
//                singleton = new POTApplication();
//            }
//        }
//        return singleton;
//    }
}
