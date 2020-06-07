package com.mycompany.lapr2_interfacegrafica.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import com.mycompany.lapr2_interfacegrafica.authorization.model.UserSession;
import com.mycompany.lapr2_interfacegrafica.authorization.model.TaskRegister;
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
    //private TasksList tLst;
    private FreelancersRecord frlR;
    private PaymentTransactionList ptL;
    private PaymentTransaction payT;

    Task task = null;
    private TaskRegister taskRegister;
    
    public CreateTaskController() {
        this.m_oApp = POTApplication.getInstance();
        this.m_oSessao = m_oApp.getSessaoAtual();

        if(!m_oApp.getSessaoAtual().isLoggedInWithRole(Constants.ADMINISTRATOR_ROLE))
            throw new IllegalStateException("Utilizador não Autorizado");
        
        this.m_oPlataforma = m_oApp.getPlataforma();    
        
        this.taskRegister = m_oPlataforma.getTaskRegister();
    }

    public boolean newTask(String id, String briefDescription, int timeDuration, double costPerHour, String category) {
        try {
            task = taskRegister.newTask(id, briefDescription, timeDuration, costPerHour, category);
                    
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean registerTask() {
        return taskRegister.registerTask(task);
    }

    public String getTaskAsString() {
        return task.toString();
    }

}