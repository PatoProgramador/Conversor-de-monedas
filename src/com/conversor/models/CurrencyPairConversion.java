package com.conversor.models;

public class CurrencyPairConversion {
    private String baseCode;
    private String targetCode;
    private Double amount;
    private Double amountConverted;
    private String createdAt;

    public String getBaseCode() {
        return baseCode;
    }

    public void setBaseCode(String baseCode) {
        this.baseCode = baseCode;
    }

    public String getTargetCode() {
        return targetCode;
    }

    public void setTargetCode(String targetCode) {
        this.targetCode = targetCode;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getAmountConverted() {
        return amountConverted;
    }

    public void setAmountConverted(Double amountConverted) {
        this.amountConverted = amountConverted;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Base: " + this.baseCode + "Target: " + this.targetCode + "Amount: " + this.amount;
    }
}
