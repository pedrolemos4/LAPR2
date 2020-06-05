package lapr2.pot.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import lapr2.autorizacao.model.SessaoUtilizador;
import lapr2.autorizacao.model.TaskRegister;
import lapr2.pot.model.Constantes;
import lapr2.pot.model.Freelancer;
import lapr2.pot.model.FreelancersRecord;
import lapr2.pot.model.Organization;
import lapr2.pot.model.OrganizationsRecord;
import lapr2.pot.model.PaymentTransaction;
import lapr2.pot.model.PaymentTransactionList;
import lapr2.pot.model.Plataforma;
import lapr2.pot.model.Task;
import lapr2.pot.ui.console.utils.Utils;

public class CreateTaskController {

    private AplicacaoPOT m_oApp;
    private Plataforma m_oPlataforma;
    private SessaoUtilizador m_oSessao;
    private OrganizationsRecord or;
    //private TasksList tLst;
    private FreelancersRecord frlR;
    private PaymentTransactionList ptL;
    private PaymentTransaction payT;

    Task task = null;
    private TaskRegister taskRegister;
    
    public CreateTaskController() {
        this.m_oApp = AplicacaoPOT.getInstance();
        this.m_oSessao = m_oApp.getSessaoAtual();

        if(!m_oApp.getSessaoAtual().isLoggedInComPapel(Constantes.PAPEL_ADMINISTRATIVO))
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
