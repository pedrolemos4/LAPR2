package com.mycompany.lapr2_interfacegrafica.controller;

import com.mycompany.lapr2_interfacegrafica.authorization.FacadeAuthorization;
import com.mycompany.lapr2_interfacegrafica.authorization.model.UserSession;
import com.mycompany.lapr2_interfacegrafica.model.TaskList;
import com.mycompany.lapr2_interfacegrafica.model.FreelancersRecord;
import com.mycompany.lapr2_interfacegrafica.model.Organization;
import com.mycompany.lapr2_interfacegrafica.model.OrganizationsRecord;
import com.mycompany.lapr2_interfacegrafica.model.PaymentTransaction;
import com.mycompany.lapr2_interfacegrafica.model.PaymentTransactionList;
import com.mycompany.lapr2_interfacegrafica.model.Platform;
import com.mycompany.lapr2_interfacegrafica.model.Task;
import java.io.IOException;

public class CreateTaskController {

    private Platform m_oPlatform;
    private UserSession m_oSessao;
    private OrganizationsRecord or;
    private Organization org;
    private FreelancersRecord frlR;
    private PaymentTransactionList ptL;
    private PaymentTransaction payT;
    private TaskList taskList;
    private FacadeAuthorization facade;

    private Task task;

    public CreateTaskController() {
        this.m_oPlatform = POTApplication.getPlatform();
        this.facade = POTApplication.getFacadeAuthorization();
        this.or = m_oPlatform.getOrganizationsRecord();
        this.org = or.getOrganization();
        this.taskList = org.getTaskList();
    }

    public Task newTask(String id, String briefDescription, int timeDuration, double costPerHour, String category) {
        Task task1 = this.taskList.newTask(id, briefDescription, timeDuration, costPerHour, category);
        this.task = task1;
        if (this.taskList.validateTask(task)) {
            return this.task;
        }
        return null;
    }

    public boolean registerTask(Task task) throws IOException {
        String email = facade.getCurrentSession().getUser().getEmail();
        Organization m_Organization = this.or.getOrganizationByUserEmail(email);
        TaskList taskList1 = m_Organization.getTaskList();
        Task task1 = taskList1.getOtherTask(task);
        return taskList1.registerTask(task1);
    }

    public String getTaskAsString() {
        return task.toString();
    }

    public Task getTask() {
        return task;
    }
}
