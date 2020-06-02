package lapr2.pot.model;

import java.util.ArrayList;
import java.util.List;
import lapr2.autorizacao.AutorizacaoFacade;

public class OrganizationsRecord {

    private PasswordGeneratorAlgorithm alg;
    private Plataforma m_oPlataforma;
    private final AutorizacaoFacade m_oAutorizacao = new AutorizacaoFacade();
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
                    new String[]{Constantes.PAPEL_GESTOR_ORGANIZACAO, Constantes.PAPEL_COLABORADOR_ORGANIZACAO})
                    && this.m_oAutorizacao.registaUtilizadorComPapel(nameC, emailC, pwdC, Constantes.PAPEL_COLABORADOR_ORGANIZACAO)) {
                return addOrganization(org);
            }
        }
        return false;
    }
}
