/**
 * 
 */
package com.tradeStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tradeStore.exception.InvalidTradeException;
import com.tradeStore.model.TradeStore;
import com.tradeStore.service.TradeStoreService;

/**
 * @author KRUNAL
 *
 */

@RestController
public class TradeStoreController {

	@Autowired
	TradeStoreService tradeStoreService;

	@PostMapping("/newTrade")
	public ResponseEntity<String> newTrades(@RequestBody TradeStore tradeStore) {
		if(tradeStoreService.isValidTrade(tradeStore)) {
			tradeStoreService.saveTrade(tradeStore);
		} else {
			throw new InvalidTradeException(tradeStore.getTradeId()+"  is not a valid trade.");
		}

		return ResponseEntity.status(HttpStatus.OK).build();
	}

	//To test existing data
	@GetMapping("/existingTrade")
    public List<TradeStore> findAllTrades(){
        return tradeStoreService.getAllTrades();
    }
}