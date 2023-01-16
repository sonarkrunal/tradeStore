/**
 * 
 */
package com.tradeStore.exception;

/**
 * @author Krunal
 *
 */
public class InvalidTradeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -739224802546899386L;
	private String tradeId;
	
	public InvalidTradeException(final String tradeId) {
        super("Invalid trade: " + tradeId);
        this.tradeId = tradeId;
    }

	/**
	 * @return the tradeId
	 */
	public String getTradeId() {
		return tradeId;
	}
	
}
