package com.mycompany.lapr2_interfacegrafica.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import com.mycompany.lapr2_interfacegrafica.authorization.model.UserSession;
import com.mycompany.lapr2_interfacegrafica.model.TaskList;
import com.mycompany.lapr2_interfacegrafica.model.Constants;
import com.mycompany.lapr2_interfacegrafica.model.Freelancer;
import com.mycompany.lapr2_interfacegrafica.model.FreelancersRecord;
import com.mycompany.lapr2_interfacegrafica.model.Organization;
import com.mycompany.lapr2_interfacegrafica.model.OrganizationsRecord;
import com.mycompany.lapr2_interfacegrafica.model.PaymentTransaction;
import com.mycompany.lapr2_interfacegrafica.model.PaymentTransactionList;
import com.mycompany.lapr2_interfacegrafica.model.Platform;
import com.mycompany.lapr2_interfacegrafica.model.Task;
import lapr2.pot.ui.console.utils.Utils;

public class CreateTaskController {

    private POTApplication m_oApp;
    private Platform m_oPlataforma;
    private UserSession m_oSessao;
    private OrganizationsRecord or;
    private Organization org;
    private FreelancersRecord frlR;
    private PaymentTransactionList ptL;
    private PaymentTransaction payT;
    private TaskList taskRecord;

    Task task = null;

    public CreateTaskController() {
        this.m_oApp = POTApplication.getInstance();
        this.m_oSessao = m_oApp.getCurrentSession();

        if (!m_oApp.getCurrentSession().isLoggedInWithRole(Constants.ADMINISTRATOR_ROLE)) {
            throw new IllegalStateException("Utilizador não Autorizado");
        }

        this.m_oPlataforma = m_oApp.getPlataforma();

        this.taskRecord = org.getTaskList();
    }

    public boolean newTask(String id, String briefDescription, int timeDuration, double costPerHour, String category) {
        try {
            task = taskRecord.newTask(id, briefDescription, timeDuration, costPerHour, category);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean registerTask() {
        return taskRecord.registerTask(task);
    }

    public String getTaskAsString() {
        return task.toString();
    }

    public Task getTask() {
        return task;
    }
}
