/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.ui.console;

import lapr.project.gpsd.controller.RegistarClienteController;
import lapr.project.gpsd.ui.console.utils.Utils;

/**
 *
 * @author paulomaio
 */
public class RegistarClienteUI
{
    private RegistarClienteController m_controller;
    public RegistarClienteUI()
    {
        m_controller = new RegistarClienteController();
    }

    public void run()
    {
        System.out.println("\nEfetuar Registo como Cliente:");

        if(introduzDados())
        {
            apresentaDados();

            if (Utils.confirma("Confirma os dados introduzidos? (S/N)")) {
                if (m_controller.registaCliente()) {
                    System.out.println("Registo efetuado com sucesso.");
                } else {
                    System.out.println("Não foi possivel concluir o registo com sucesso.");
                }
            }
        }
        else
        {
            System.out.println("Ocorreu um erro. Operação cancelada.");
        }
    }
    
    private boolean introduzDados() {
        String strNome = Utils.readLineFromConsole("Nome Completo: ");
        String strNIF = Utils.readLineFromConsole("NIF: ");
        String strTelefone = Utils.readLineFromConsole("Telefone: ");
        String strEmail = Utils.readLineFromConsole("EMail: ");
        String strPwd = Utils.readLineFromConsole("Palavra-Passe: ");
        
        System.out.println("\nIntroduza pelo menos um endereço postal:");
        int count = 0; 
        do
        {
   
            String strLocal = Utils.readLineFromConsole("Rua/Av.: ");
            String strCodPostal = Utils.readLineFromConsole("Cod. Postal: ");
            String strLocalidade = Utils.readLineFromConsole("Localidade: ");
            
            if (count == 0)
            {
                if(m_controller.novoCliente(strNome, strNIF, strTelefone, strEmail, strPwd, strLocal, strCodPostal, strLocalidade))
                {
                    count++;
                }
                else
                {
                    return false;
                }
            }
            else
            {
                if(!m_controller.addEnderecoPostal(strLocal, strCodPostal, strLocalidade))
                {
                    System.out.println("Ocorreu um erro ao adicionar o endereço.");
                }
            }    
        }while((count == 0) || Utils.confirma("Pretende introduzir outro Endereço Postal (S/N)?"));
        return true;
    }
    
    private void apresentaDados() 
    {
        System.out.println("\n Cliente:\n" + m_controller.getClienteString());
    }
}
