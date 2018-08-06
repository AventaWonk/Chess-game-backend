package chessGameBackend.exception;

/**
 * VK API authorization exception
 *
 * @author Roman
 */
public class VkAuthorizationException extends Exception {

    private int code;
    private String message;

    public VkAuthorizationException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
