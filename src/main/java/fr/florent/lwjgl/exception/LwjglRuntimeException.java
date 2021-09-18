package fr.florent.lwjgl.exception;

/**
 * Exception class for technical error of LiGDX
 */
public class LwjglRuntimeException extends RuntimeException {

    /**
     * For wrapped exception
     *
     * @param ex
     */
    public LwjglRuntimeException(Exception ex) {
        super(ex);
    }

    /**
     * For wrapped exception with custom message
     *
     * @param ex      the wrapped exception
     * @param message the custom message
     */
    public LwjglRuntimeException(String message, Exception ex) {
        super(message, ex);
    }

    /**
     * For wrapped exception
     *
     * @param message the custom message
     */
    public LwjglRuntimeException(String message) {
        super(message);
    }
}
