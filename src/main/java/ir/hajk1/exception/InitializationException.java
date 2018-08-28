package ir.hajk1.exception;

/**
 * Author: <a href="mailto:k1.tehrani@gmail.com">Kayvan Tehrani</a>
 *
 * Description: <This class is used for declaring wrong usage of methods before initialization>
 */
public class InitializationException extends Exception {

  public InitializationException(String message) {
    super(message);
  }
}
