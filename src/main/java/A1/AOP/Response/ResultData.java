package A1.AOP.Response;
import lombok.Data;
import lombok.SneakyThrows;

/**
 * @author 闫瑞松
 * @date 2021/11/26 14:32
 * @phone 18531958592
 * @function T1
 */
@Data
public class ResultData<T> {
    /**
     * 结果状态 ,具体状态码参见ResultData.java
     */
    private boolean success;
    private String message;
    private T data;
    private long timestamp;

    public ResultData() {
        this.timestamp = System.currentTimeMillis();
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @SneakyThrows
    public static <T> ResultData<T> success(T data) {
        ResultData<T> resultData = new ResultData<>();
        resultData.setSuccess(ReturnCode.RC100.isSuccess());
        resultData.setMessage(ReturnCode.RC100.getMessage());
        resultData.setData(data);
        return resultData;
    }

    public static <T> ResultData<T> fail(String message) {
        ResultData<T> resultData = new ResultData<>();
        resultData.setSuccess(false);
        resultData.setMessage(message);
        return resultData;
    }

}
