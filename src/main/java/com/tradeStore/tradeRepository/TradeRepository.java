/**
 * 
 */
package com.tradeStore.tradeRepository;

import org.springframework.data.repository.CrudRepository;

import com.tradeStore.model.TradeStore;

/**
 * @author Krunal
 *
 */
public interface TradeRepository extends CrudRepository<TradeStore, String> {

}
