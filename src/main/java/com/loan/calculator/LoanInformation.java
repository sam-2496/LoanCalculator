package com.loan.calculator;

import java.time.LocalDate;

public class LoanInformation {

    private String loanId;
    private String customerId;
    private String lenderId;
    private double amount;
    private double remAmount;
    private LocalDate paymentDate;
    private double interestRate;
    private LocalDate dueDate;
    private double penaltyRate;
    private boolean cancel;

    public LoanInformation(String loanId, String customerId, String lenderId, double amount, double remAmount, LocalDate paymentDate, double interestRate, LocalDate dueDate, double penaltyRate) {
        this.loanId = loanId;
        this.customerId = customerId;
        this.lenderId = lenderId;
        this.amount = amount;
        this.remAmount = remAmount;
        this.paymentDate = paymentDate;
        this.interestRate = interestRate;
        this.dueDate = dueDate;
        this.penaltyRate = penaltyRate;
        this.cancel = false;
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getLenderId() {
        return lenderId;
    }

    public void setLenderId(String lenderId) {
        this.lenderId = lenderId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getRemAmount() {
        return remAmount;
    }

    public void setRemAmount(double remAmount) {
        this.remAmount = remAmount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public double getPenaltyRate() {
        return penaltyRate;
    }

    public void setPenaltyRate(double penaltyRate) {
        this.penaltyRate = penaltyRate;
    }

    public boolean isCancel() {
        return cancel;
    }

    public void setCancel(boolean cancel) {
        this.cancel = cancel;
    }
}
