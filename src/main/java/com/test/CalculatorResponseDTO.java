package com.test;

public class CalculatorResponseDTO {
    private double result;
    private String operation;
    private String error;

    public double getResult() { return result; }
    public void setResult(double result) { this.result = result; }
    public String getOperation() { return operation; }
    public void setOperation(String operation) { this.operation = operation; }
    public String getError() { return error; }
    public void setError(String error) { this.error = error; }
} 