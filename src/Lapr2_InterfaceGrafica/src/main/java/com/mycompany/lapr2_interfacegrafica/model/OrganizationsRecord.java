package com.mycompany.lapr2_interfacegrafica.model;

import com.mycompany.lapr2_interfacegrafica.authorization.FacadeAuthorization;
import java.util.ArrayList;
import java.util.List;

public class OrganizationsRecord {

    private PasswordGeneratorAlgorithm alg;
    private final FacadeAuthorization m_oAutorizacao = new FacadeAuthorization();
    private final List<Organization> m_lstOrganizations = new ArrayList<>();

    public Organization newOrganization(String name, String NIF, String nameM, String emailM, String nameC, String emailC) {
        Collaborator manager = new Collaborator(nameM, emailM);
        Collaborator collab = new Collaborator(nameC, emailC);
        return new Organization(name, NIF, manager, collab);
    }

    public Collaborator newCollaborator(String name, String email) {
        return new Collaborator(name, email);
    }

    public boolean validateOrganization(Organization org) {
        for (int i = 0; i < m_lstOrganizations.size(); i++) {
            if (m_lstOrganizations.get(i).equals(org)) {
                return false;
            }
        }
        return true;
    }

    public boolean addOrganization(Organization org) {
        return m_lstOrganizations.add(org);
    }

    public String getOrganizationToString(Organization org) {
        return org.toString();
    }

    public boolean organizationRegister(Organization org) {
        if (this.validateOrganization(org)) {
            Collaborator manager = org.getManager();
            String nameM = manager.getName();
            String emailM = manager.getEmail();
            String pwdM = alg.generatePassword(nameM, emailM);
            Collaborator collab = org.getCollaborator();
            String nameC = collab.getName();
            String emailC = collab.getEmail();
            String pwdC = alg.generatePassword(nameC, emailC);
            if (this.m_oAutorizacao.registaUtilizadorComPapeis(nameM, emailM, pwdM,
                    new String[]{Constants.PAPEL_GESTOR_ORGANIZACAO, Constants.PAPEL_COLABORADOR_ORGANIZACAO})
                    && this.m_oAutorizacao.registaUtilizadorComPapel(nameC, emailC, pwdC, Constants.PAPEL_COLABORADOR_ORGANIZACAO)) {
                return addOrganization(org);
            }
        }
        return false;
    }

    public Organization getOrganizationByUserEmail(String email) {
        for (int i = 0; i < m_lstOrganizations.size(); i++) {
            if (m_lstOrganizations.get(i).getManager().getEmail().equals(email) || m_lstOrganizations.get(i).getCollaborator().getEmail().equals(email)) {
                return m_lstOrganizations.get(i);
            }
        }
        return null;
    }
}
