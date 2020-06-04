package com.mycompany.lapr2_interfacegrafica.model;

import com.mycompany.lapr2_interfacegrafica.authorization.FacadeAuthorization;

public class Platform {

    private String m_strDesignacao;
    private final FacadeAuthorization m_oAutorizacao;

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
}
