package lapr2.pot.ui.console.utils;

public class InvalidDayException extends IllegalArgumentException {

    public InvalidDayException() {
        super("Dia é inválido!!");
    }

    public InvalidDayException(String mensagem) {
        super(mensagem);
    }

}
