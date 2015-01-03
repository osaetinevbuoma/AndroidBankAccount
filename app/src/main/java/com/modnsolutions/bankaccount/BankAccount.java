package com.modnsolutions.bankaccount;

/**
 * Created by oevbuoma on 1/3/15.
 * Bank Account Class
 */
public class BankAccount {
    private Double deposit = 0.00;
    private Double withdraw = 0.00;

    public void setDeposit(Double deposit) {
        this.deposit += deposit;
    }

    public void setWithdraw(Double withdraw) {
        this.withdraw += withdraw;
    }

    public Double getDeposit() {
        return this.deposit;
    }

    public Double getWithdraw() {
        return this.withdraw;
    }
}
