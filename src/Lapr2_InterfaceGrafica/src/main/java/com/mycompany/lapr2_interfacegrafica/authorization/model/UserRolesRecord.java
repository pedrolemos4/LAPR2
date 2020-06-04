package com.mycompany.lapr2_interfacegrafica.authorization.model;

import java.util.HashSet;
import java.util.Set;

public class UserRolesRecord {

    private Set<UserRole> m_lstRoles = new HashSet<>();

    public UserRole newUserRole(String strRole) {
        return new UserRole(strRole);
    }

    public UserRole newUserRole(String strRole, String strDescription) {
        return new UserRole(strRole, strDescription);
    }

    public boolean addRole(UserRole papel) {
        if (papel != null) {
            return this.m_lstRoles.add(papel);
        }
        return false;
    }

    public boolean removeRole(UserRole role) {
        if (role != null) {
            return this.m_lstRoles.remove(role);
        }
        return false;
    }

    public UserRole searchRole(String strPapel) {
        for (UserRole p : this.m_lstRoles) {
            if (p.hasId(strPapel)) {
                return p;
            }
        }
        return null;
    }

    public boolean hasRole(String strRole) {
        UserRole role = searchRole(strRole);
        if (role != null) {
            return this.m_lstRoles.contains(role);
        }
        return false;
    }

    public boolean hasRole(UserRole role) {
        return this.m_lstRoles.contains(role);
    }
}
