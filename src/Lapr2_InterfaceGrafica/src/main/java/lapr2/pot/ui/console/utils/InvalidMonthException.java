/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr2.pot.ui.console.utils;

/**
 *
 * @author josep
 */
public class InvalidMonthException extends IllegalArgumentException {

    /**
     * Constrói uma MesInvalidoException com a mensagem "Mês é inválido!".
     */
    public InvalidMonthException() {
        super("Mês é inválido!!");
    }

    /**
     * Constrói uma MesInvalidoException contendo a mensagem recebida.
     *
     * @param mensagem a mensagem transmitida pela exceção
     */
    public InvalidMonthException(String mensagem) {
        super(mensagem);
    }

}
