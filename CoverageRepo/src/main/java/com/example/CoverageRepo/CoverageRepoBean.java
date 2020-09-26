package com.example.CoverageRepo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class CoverageRepoBean {
	
	@Id
	private int id;
	private long premium;
	private int year;
	private BigDecimal interest;
	
	@Transient
	private int port;
	
	public CoverageRepoBean() {
		super();
		this.id = id;
		this.premium = premium;
		this.year = year;
		this.interest = interest;
		this.port = port;
	}
	
	public CoverageRepoBean(int id, long premium, int year, BigDecimal interest, int port) {
		super();
		this.id = id;
		this.premium = premium;
		this.year = year;
		this.interest = interest;
		this.port = port;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getPremium() {
		return premium;
	}
	public void setPremium(long premium) {
		this.premium = premium;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public BigDecimal getInterest() {
		return interest;
	}
	public void setInterest(BigDecimal interest) {
		this.interest = interest;
	}
	

}
