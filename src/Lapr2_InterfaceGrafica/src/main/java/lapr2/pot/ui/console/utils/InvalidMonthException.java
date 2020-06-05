package lapr2.pot.ui.console.utils;

public class InvalidMonthException extends IllegalArgumentException {

    public InvalidMonthException() {
        super("Mês é inválido!!");
    }

    public InvalidMonthException(String mensagem) {
        super(mensagem);
    }

}
