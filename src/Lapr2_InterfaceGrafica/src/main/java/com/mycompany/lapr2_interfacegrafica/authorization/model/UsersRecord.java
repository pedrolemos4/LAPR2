package com.mycompany.lapr2_interfacegrafica.authorization.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class UsersRecord implements Serializable {

    private Set<User> m_lstUsers = new HashSet<>();

    public User newUser(String strNome, String strEmail, String strPassword) {
        return new User(strNome, strEmail, strPassword);
    }

    public boolean addUser(User user) {
        if (hasUser(user)) {
            return this.m_lstUsers.add(user);
        } else {
            return false;
        }
    }

    public boolean removeUser(User user) {
        if (user != null) {
            return this.m_lstUsers.remove(user);
        }
        return false;
    }

    public User searchUser(String strId) {
        for (User utlz : this.m_lstUsers) {
            if (utlz.hasId(strId)) {
                return utlz;
            }
        }
        return null;
    }

    public boolean hasUser(String strId) {
        User user = searchUser(strId);
        if (user != null) {
            return this.m_lstUsers.contains(user);
        }
        return false;
    }

    public boolean hasUser(User user) {
        boolean flag = true;
        for (User utlz : this.m_lstUsers) {
            if (utlz.getEmail().equals(user.getEmail())) {
                return false;
            }
        }
        return flag;
    }
}
