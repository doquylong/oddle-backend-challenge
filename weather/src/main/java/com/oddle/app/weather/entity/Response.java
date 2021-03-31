package com.oddle.app.weather.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.http.ResponseEntity;

@Data
public class Response {
    @JsonProperty("status")
    private int status;
    @JsonProperty("message")
    private String message;
    @JsonProperty("data")
    private Object data;

    public Response(ResponseEntity<Info> res) {
        this.status = res.getStatusCodeValue();
        this.message = res.getStatusCode().name();
        this.data = res.getBody();
    }

    public Response(int status, String message, Object info) {
        this.status = status;
        this.message = message;
        this.data = info;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
