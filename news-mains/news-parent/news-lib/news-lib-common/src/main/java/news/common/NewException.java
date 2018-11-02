package news.common;

public class NewException extends Exception {

    private static final long serialVersionUID = 1L;

    private int errorCode = ErrorCode.UNKNOWN;

    public NewException(int errorCode) {
        super();

        this.errorCode = errorCode;
    }

    public NewException(String message) {
        super(message);
    }

    public NewException(int errorCode, String message) {
        super(message);

        this.errorCode = errorCode;	}

    public NewException(String message, Throwable cause) {
        super(message, cause);
    }

    public NewException(int errorCode, String message, Throwable cause) {
        super(message, cause);

        this.errorCode = errorCode;	}

    public NewException(Throwable cause) {
        super(cause);
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

}

