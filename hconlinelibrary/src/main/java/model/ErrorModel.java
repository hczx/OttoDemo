package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Jam on 2016/3/14.
 * 网络请求错误参数Info
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorModel {

    @JsonProperty("status_code")
    public int mStatusCode;
    @JsonProperty("message")
    public String mMessage;


    public ErrorModel() {
    }

    public ErrorModel(int mStatusCode, String mMessage) {
        this.mStatusCode = mStatusCode;
        this.mMessage = mMessage;
    }

    public int getStatusCode() {
        return mStatusCode;
    }


    public String getMessage() {
        return mMessage;
    }

}
