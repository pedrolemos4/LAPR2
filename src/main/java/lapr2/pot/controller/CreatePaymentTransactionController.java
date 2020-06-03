package lapr2.pot.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import lapr2.autorizacao.model.SessaoUtilizador;
import lapr2.pot.model.Freelancer;
import lapr2.pot.model.FreelancersRecord;
import lapr2.pot.model.Organization;
import lapr2.pot.model.OrganizationsRecord;
import lapr2.pot.model.PaymentTransaction;
import lapr2.pot.model.PaymentTransactionList;
import lapr2.pot.model.Plataforma;
import lapr2.pot.model.Task;
import lapr2.pot.ui.console.utils.Utils;

public class CreatePaymentTransactionController {

    private AplicacaoPOT m_oApp;
    private Plataforma m_oPlataforma;
    private SessaoUtilizador m_oSessao;
    private OrganizationsRecord or;
    //private TasksList tLst;
    private FreelancersRecord frlR;
    private PaymentTransactionList ptL;
    private PaymentTransaction payT;

    public CreatePaymentTransactionController() {
        this.m_oApp = AplicacaoPOT.getInstance();
        this.m_oSessao = m_oApp.getSessaoAtual();
    }

    public boolean newPaymentTransaction(String taskId, String briefDescription, int timeDuration, double costPerHour, String taskCategory, String endDate, int delay, String workQualityDescription, String frlId, String name, String expertiseLevel, String email, String NIF, String IBAN, String address, String country) {
        try {
            String emailC = m_oSessao.getEmailUtilizador();
            Organization org = or.getOrganizationByUserEmail(emailC);
            //Task task = tLst.taskExists(taskId);
            //TaskExecution taskExec = task.taskExec();
            //Freelancer free = frlR.freelancerExists(frlId);
            //double payAmount = org.generatePayAmount(task, free);
            //this.payT = this.ptL.newPaymentTransaction(task, taskExec, free, payAmount);
            return this.ptL.validatePaymentTransaction(this.payT);
        } catch (RuntimeException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            this.payT = null;
            return false;
        }
    }

    public boolean paymentTransactionRegister() {
        return this.ptL.paymentTransactionRegister(this.payT);
    }
}
