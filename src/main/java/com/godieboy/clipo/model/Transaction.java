package com.godieboy.clipo.model;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Transactions")
public class Transaction {
	
	@Column(name="user_id")
	private String userId;
	
	@Id
	@Column(name="transaction_id", columnDefinition="BINARY(16)")
	private String id;
	
	
	@Column(name="amount")
	private double amount;
	
	@Column(name="description")
	private String description;
	
	@Column(name="date")
	private Timestamp date;
	
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "{userId=" + userId + ", transaction_id=" + id + ", amount=" + amount + ", description=" + description
				+ ", date=" + date + "}";
	}
	
	
	
}
