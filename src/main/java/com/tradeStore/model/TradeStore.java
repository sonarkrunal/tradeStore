/**
 * 
 */
package com.tradeStore.model;

import java.time.LocalDate;

//import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.Id; 

/**
 * @author Krunal
 *
 */
@Entity
public class TradeStore {

	@Id
	private String tradeId;

    private int version;

    private String counterPartId;

    private String bookId;

    private LocalDate maturityDate;

    private LocalDate createdDate;

    private String expired;

    public TradeStore() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the tradeId
	 */
	public String getTradeId() {
		return tradeId;
	}


	/**
	 * @param tradeId the tradeId to set
	 */
	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}

	/**
	 * @return the version
	 */
	public int getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(int version) {
		this.version = version;
	}

	/**
	 * @return the counterPartId
	 */
	public String getCounterPartId() {
		return counterPartId;
	}

	/**
	 * @param counterPartId the counterPartId to set
	 */
	public void setCounterPartId(String counterPartId) {
		this.counterPartId = counterPartId;
	}

	/**
	 * @return the bookId
	 */
	public String getBookId() {
		return bookId;
	}

	/**
	 * @param bookId the bookId to set
	 */
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	/**
	 * @return the maturityDate
	 */
	public LocalDate getMaturityDate() {
		return maturityDate;
	}

	/**
	 * @param maturityDate the maturityDate to set
	 */
	public void setMaturityDate(LocalDate maturityDate) {
		this.maturityDate = maturityDate;
	}

	/**
	 * @return the createdDate
	 */
	public LocalDate getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the expired
	 */
	public String getExpired() {
		return expired;
	}

	/**
	 * @param expired the expired to set
	 */
	public void setExpired(String expired) {
		this.expired = expired;
	}

	public TradeStore(String tradeId, int version, String counterPartId, String bookId, LocalDate maturityDate,
			LocalDate createdDate, String expired) {
		super();
		this.tradeId = tradeId;
		this.version = version;
		this.counterPartId = counterPartId;
		this.bookId = bookId;
		this.maturityDate = maturityDate;
		this.createdDate = createdDate;
		this.expired = expired;
	}


	@Override
	public String toString() {
		return "tradeStore [tradeId=" + tradeId + ", version=" + version + ", counterPartId=" + counterPartId
				+ ", bookId=" + bookId + ", maturityDate=" + maturityDate + ", createdDate=" + createdDate
				+ ", expired=" + expired + ", getTradeId()=" + getTradeId() + ", getVersion()=" + getVersion()
				+ ", getCounterPartId()=" + getCounterPartId() + ", getBookId()=" + getBookId() + ", getMaturityDate()="
				+ getMaturityDate() + ", getCreatedDate()=" + getCreatedDate() + ", getExpired()=" + getExpired()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
}