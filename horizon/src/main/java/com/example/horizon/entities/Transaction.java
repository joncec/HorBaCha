package com.example.horizon.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "app_transaction")
public class Transaction implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @ManyToOne
    @JoinColumn(name = "origin_account_id")
    private Account originAccount;

    @ManyToOne
    @JoinColumn(name = "destination_account_id")
    private Account destinationAccount;

    //private BigDecimal value;

   // private Date date;
    
    

    public Transaction(Long transactionId, Account originAccount, Account destinationAccount, BigDecimal value,
			Date date) {
		super();
		this.transactionId = transactionId;
		this.originAccount = originAccount;
		this.destinationAccount = destinationAccount;
		//this.value = value;
		//this.date = date;
	}

	public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Account getOriginAccount() {
        return originAccount;
    }

    public void setOriginAccount(Account originAccount) {
        this.originAccount = originAccount;
    }

    public Account getDestinationAccount() {
        return destinationAccount;
    }

    public void setDestinationAccount(Account destinationAccount) {
        this.destinationAccount = destinationAccount;
    }

   /* public BigDecimal getValue() {
        return value;
    }*/

    /*public void setValue(BigDecimal value) {
        this.value = value;
    }*/

    /*public Date getDate() {
        return date;
    }*/

	@Override
	public int hashCode() {
		return Objects.hash(transactionId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		return Objects.equals(transactionId, other.transactionId);
	}
    
    

    
}