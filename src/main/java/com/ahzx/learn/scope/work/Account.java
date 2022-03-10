package com.ahzx.learn.scope.work;

/**
 * @author think
 * @version 1.0
 * @date 2022/3/3 6:42
 */
public class Account {
    private String accountNo;
    private String balanceDate;
    private String balance;

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getBalanceDate() {
        return balanceDate;
    }

    public void setBalanceDate(String balanceDate) {
        this.balanceDate = balanceDate;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNo='" + accountNo + '\'' +
                ", balanceDate='" + balanceDate + '\'' +
                ", balance='" + balance + '\'' +
                '}';
    }
}
