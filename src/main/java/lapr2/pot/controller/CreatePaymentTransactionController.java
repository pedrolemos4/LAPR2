package lapr2.pot.controller;

import lapr2.pot.model.Plataforma;

public class CreatePaymentTransactionController {

    private AplicacaoPOT m_oApp;
    private Plataforma m_oPlataforma;

    public CreatePaymentTransactionController() {
        this.m_oApp = AplicacaoPOT.getInstance();
        this.m_oPlataforma = m_oApp.getPlataforma();
    }
}
