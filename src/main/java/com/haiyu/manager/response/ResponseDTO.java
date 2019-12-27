//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.haiyu.manager.response;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import java.util.List;

public class ResponseDTO<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private int status;
    private String message;
    private T data;

    public static ResponseDTO success() {
        return new ResponseDTO();
    }

    public static <T> ResponseDTO<T> success(T data) {
        return new ResponseDTO(data);
    }

    public static <T> ResponseDTO<T> success(T data, String message) {
        return new ResponseDTO(200, data, message);
    }

    public static ResponseDTO fail(int status, String message) {
        return new ResponseDTO(status, (Object)null, message);
    }

    public static ResponseDTO fail(String message) {
        return new ResponseDTO(100, (Object)null, message);
    }

    public static ResponseDTO fail() {
        return new ResponseDTO(100, (Object)null, (String)null);
    }

    public ResponseDTO() {
        this.status = 200;
    }

    public ResponseDTO(T data) {
        this.status = 200;
        this.data = data;
    }

    public ResponseDTO(int status, T data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @JSONField(
        serialize = false,
        deserialize = false
    )
    public boolean isSuccess() {
        return this.status == 200;
    }

    /** @deprecated */
    @Deprecated
    @JSONField(
        serialize = false,
        deserialize = false
    )
    public Boolean getStatusBool() {
        return this.isSuccess();
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return this.data;
    }

    /** @deprecated */
    @Deprecated
    @JSONField(
        serialize = false,
        deserialize = false
    )
    public List getItems() {
        return this.data != null && this.data instanceof List ? (List)this.data : null;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("ResponseDTO{");
        sb.append("status=").append(this.status);
        sb.append(", message='").append(this.message).append('\'');
        sb.append(", data=").append(this.data);
        sb.append('}');
        return sb.toString();
    }
}
