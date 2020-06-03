package lapr2.pot.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Organization {

    private String m_strNome;
    private String m_strNIF;
    private Collaborator m_oManager;
    private Collaborator m_oCollaborator;
    private List<PaymentTransaction> m_lstPaymentTransactions = new ArrayList<PaymentTransaction>();

    public Organization(String name, String NIF, Collaborator manager, Collaborator collaborator) {
        if ((name == null) || (NIF == null) || (manager == null) || (collaborator == null)
                || (name.isEmpty()) || (NIF.isEmpty())) {
            throw new IllegalArgumentException("None of the arguments can be null or empty.");
        }

        this.m_strNome = name;
        this.m_strNIF = NIF;
        this.m_oManager = manager;
        this.m_oCollaborator = collaborator;

    }

    public Collaborator getManager() {
        return this.m_oManager;
    }

    public Collaborator getCollaborator() {
        return this.m_oCollaborator;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.m_strNIF);
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        // Inspirado em https://www.sitepoint.com/implement-javas-equals-method-correctly/

        // self check
        if (this == o) {
            return true;
        }
        // null check
        if (o == null) {
            return false;
        }
        // type check and cast
        if (getClass() != o.getClass()) {
            return false;
        }
        // field comparison
        Organization obj = (Organization) o;
        return (Objects.equals(m_strNIF, obj.m_strNIF));
    }

    @Override
    public String toString() {
        String str = String.format("%s - %s - %s - %s", this.m_strNome, this.m_strNIF, this.m_oManager.toString(), this.m_oCollaborator.toString());
        return str;
    }

    public static Collaborator newCollaborator(String name, String email) {
        return new Collaborator(name, email);
    }

    public double generatePayAmount(Task task, Freelancer free) {
        return 0;
    }
}
