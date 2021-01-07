package custom.master.core.exception;


import lombok.Getter;

@Getter
public class MasterExcption extends RuntimeException {
    private String errorMessage;
    private int errorCode;

    /**
     *
     * @param cause :原因
     * @param errorMessage :错误信息
     * @param errorCode :错误码
     */
    public MasterExcption(Throwable cause, String errorMessage, int errorCode) {
        super(cause);
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }
}
