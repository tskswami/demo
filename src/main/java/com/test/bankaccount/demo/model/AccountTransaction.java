package com.test.bankaccount.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class AccountTransaction {

    private static final long serialVersionUID = 0x45A6DA99BBBDA8A8L;

    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    @Column
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date valueDate;
    @Column
    private TransactionType transactionType;
    @Column
    private String transactionDetail;
    @Column
    private BigDecimal amount;

    @ManyToOne
    private Account account;

    public Date getValueDate() {
        return valueDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setValueDate(Date valueDate) {
        this.valueDate = valueDate;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionDetail() {
        return transactionDetail;
    }

    public void setTransactionDetail(String transactionDetail) {
        this.transactionDetail = transactionDetail;
    }

    public BigDecimal getOpeningAvailableBalance() {
        return amount;
    }

    public void setOpeningAvailableBalance(BigDecimal openingAvailableBalance) {
        this.amount = openingAvailableBalance;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}
