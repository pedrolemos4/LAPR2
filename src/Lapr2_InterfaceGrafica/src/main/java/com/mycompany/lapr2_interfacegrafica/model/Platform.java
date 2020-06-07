package com.mycompany.lapr2_interfacegrafica.model;

import com.mycompany.lapr2_interfacegrafica.authorization.FacadeAuthorization;
import com.mycompany.lapr2_interfacegrafica.authorization.model.TaskRegister;
import java.util.List;

public class Platform {

    private String m_strDesignacao;
    private final FacadeAuthorization m_oAutorizacao;
    private FreelancersRecord freelRec;
    
    private final TaskRegister taskRegister = new TaskRegister();

    public Platform(String strDesignacao) {
        if ((strDesignacao == null)
                || (strDesignacao.isEmpty())) {
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");
        }
        this.m_strDesignacao = strDesignacao;
        this.m_oAutorizacao = new FacadeAuthorization();
    }

    public FacadeAuthorization getFacadeAuthorization() {
        return this.m_oAutorizacao;
    }

    public FreelancersRecord getRegistoFreelancer() {
        return freelRec;
    }
    
    public TaskRegister getTaskRegister(){
        return taskRegister;
    }
}
