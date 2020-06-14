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
    
}
