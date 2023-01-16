package com.tshine.server.common.dto.base;

import java.util.Map;

public class BaseData {
    private String status;
    private Map<String, String> error;
    private Object result;
    private boolean isError = false;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Map<String, String> getError() {
        return error;
    }

    public void setError(Map<String, String> error) {
        this.error = error;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public boolean isError() {
        return isError;
    }

    public boolean isNotError() {
        return !isError;
    }

    public void setError(boolean error) {
        isError = error;
    }
}
