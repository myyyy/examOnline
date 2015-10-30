package com.augmentum.examonline.exception;
import java.util.HashMap;
import java.util.Map;
public class ParameterException extends Exception {
    private static final long serialVersionUID = -3612840531265892718L;
    Map<String, String> errorFields = new HashMap<String, String>();

    public Map<String, String> getErrorField() {
        return errorFields;
    }

    public void setErrorField(Map<String, String> errorField) {
        this.errorFields = errorField;
    }
    public void addErrorField(String fieldName , String message ) {
        errorFields.put(fieldName, message);
    }

    public boolean isErrorField() {
        return !errorFields.isEmpty();
    }
}
