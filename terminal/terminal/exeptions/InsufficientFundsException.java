package terminal.exeptions;

import java.io.Serializable;

public class InsufficientFundsException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public InsufficientFundsException(String message) {
        super(message);
    }
}
