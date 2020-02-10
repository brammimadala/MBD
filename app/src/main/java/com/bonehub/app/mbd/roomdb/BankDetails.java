package com.bonehub.app.mbd.roomdb;

import java.io.Serializable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "BANK_DETAILS_TABLE")
public class BankDetails implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String bankName;
    private String bankBranch;
    private String accountHolderName;
    private String accountNumber;
    private String ifscCode;

    public BankDetails() {
    }

    public BankDetails(String bankName, String bankBranch, String accountHolderName, String accountNumber, String ifscCode) {
        this.bankName = bankName;
        this.bankBranch = bankBranch;
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.ifscCode = ifscCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

}
