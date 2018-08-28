package ir.hajk1.exception;

/**
 * Author: <a href="mailto:k1.tehrani@gmail.com">Kayvan Tehrani</a>
 * <p>
 * Description: <This class is used for declaring wrong usage of methods before initialization>
 */
public class InvalidFormatException extends Exception {

    public InvalidFormatException(String message) {
        super(message);
    }
}
