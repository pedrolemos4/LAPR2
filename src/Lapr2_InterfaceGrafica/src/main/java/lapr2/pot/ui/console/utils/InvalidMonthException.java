package lapr2.pot.ui.console.utils;

public class InvalidMonthException extends IllegalArgumentException {

    public InvalidMonthException() {
        super("Month is invalid!!");
    }

    public InvalidMonthException(String message) {
        super(message);
    }

}
