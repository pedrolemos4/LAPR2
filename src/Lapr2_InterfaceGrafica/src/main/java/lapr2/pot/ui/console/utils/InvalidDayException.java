package lapr2.pot.ui.console.utils;

public class InvalidDayException extends IllegalArgumentException {

    public InvalidDayException() {
        super("Day is invalid!!");
    }

    public InvalidDayException(String message) {
        super(message);
    }

}
