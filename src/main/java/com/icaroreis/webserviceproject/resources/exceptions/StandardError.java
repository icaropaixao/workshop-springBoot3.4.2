package com.icaroreis.webserviceproject.resources.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.Instant;

public class StandardError  implements Serializable {
    private static final long serialVersionUID = 1L;

    // dados que serão mostrados no Erro
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",timezone = "GMT")
    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

    // constructor
    public StandardError() {

    }
    public StandardError(Instant timestamp, Integer status, String error, String message, String requestURI) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;

    }

    // gets and sets
    public Instant getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

}
