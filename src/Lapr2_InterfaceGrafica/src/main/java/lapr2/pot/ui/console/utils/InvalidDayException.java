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
public class InvalidDayException extends IllegalArgumentException {

    /**
     * Constrói uma DiaInvalidoException com a mensagem "Dia é inválido!".
     */
    public InvalidDayException() {
        super("Dia é inválido!!");
    }

    /**
     * Constrói uma DiaInvalidoException contendo a mensagem recebida.
     *
     * @param mensagem a mensagem transmitida pela exceção
     */
    public InvalidDayException(String mensagem) {
        super(mensagem);
    }

}
