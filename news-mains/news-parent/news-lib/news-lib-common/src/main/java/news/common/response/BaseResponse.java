package news.common.response;

import java.io.Serializable;

public class BaseResponse<T> implements Serializable {
    private static final long serialVersionUID = -8245281394202383963L;

    /**
     * 接口调用返回是否成功
     */
    private boolean success;

    /**
     * 接口调用返回消息
     */
    private String message;

    /**
     * 接口调用返回代码
     */
    private String code;

    /**
     * 接口调用返回内容
     */
    private T body;

    public BaseResponse(String code, String message, T body) {
        super();
        this.code = code;
        this.message = message;
        this.body = body;
    }

    public BaseResponse(String code, String message, T body, boolean success) {
        super();
        this.code = code;
        this.message = message;
        this.body = body;
        this.success = success;
    }

    public BaseResponse(String code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public BaseResponse(String code) {
        super();
        this.code = code;
    }

    public BaseResponse() {

    }

    public boolean isSuccess() {
        return success;
    }

    public BaseResponse<T> setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public BaseResponse<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getCode() {
        return code;
    }

    public BaseResponse<T> setCode(String code) {
        this.code = code;
        return this;
    }

    public T getBody() {
        return body;
    }

    public BaseResponse<T> setBody(T body) {
        this.body = body;
        return this;
    }

    @Override
    public String toString() {
        return "BaseResponse [success=" + success + ", message=" + message + ", code=" + code + ", body=" + body + "]";
    }
}
