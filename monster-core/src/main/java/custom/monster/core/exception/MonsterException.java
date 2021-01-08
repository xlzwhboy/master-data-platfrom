package custom.monster.core.exception;


import lombok.Getter;

@Getter
public class MonsterException extends RuntimeException {
    private String errorMessage;
    private int errorCode;

    /**
     *
     * @param cause :原因
     * @param errorMessage :错误信息
     * @param errorCode :错误码
     */
    public MonsterException(Throwable cause, String errorMessage, int errorCode) {
        super(cause);
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }
    //重载
    public MonsterException(String errorMessage,int errorCode){
        super(errorMessage);
        this.errorMessage=errorMessage;
        this.errorCode=errorCode;
    }
}
