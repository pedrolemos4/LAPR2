package lapr2.pot.model;

import java.util.Objects;

public class Collaborator {

    private String m_strName;
    private String m_strEmail;

    public Collaborator(String name, String email) {
        if ((name == null) || (email == null)
                || (name.isEmpty()) || (email.isEmpty())) {
            throw new IllegalArgumentException("None of the arguments can be null or empty.");
        }

        this.m_strName = name;
        this.m_strEmail = email;
    }

    public boolean hasId(String strId) {
        return this.m_strEmail.equalsIgnoreCase(strId);
    }

    public String getName() {
        return this.m_strName;
    }

    public String getEmail() {
        return this.m_strEmail;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.m_strEmail);
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
        Collaborator obj = (Collaborator) o;
        return (Objects.equals(m_strEmail, obj.m_strEmail));
    }

    @Override
    public String toString() {
        return String.format("%s - %s", this.m_strName, this.m_strEmail);
    }
}
