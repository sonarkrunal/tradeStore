package com.tradeStore.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tradeStore.model.TradeStore;
import com.tradeStore.tradeRepository.TradeRepository;

@Service
public class TradeStoreService {

	@Autowired
	TradeRepository tradeRepository;

	public boolean isValidTrade(TradeStore tradeStore) {
		// Fetch existing trade
		Optional<TradeStore> exsitingTrade = tradeRepository.findById(tradeStore.getTradeId());
		
		//trade validation method
		if(tradeValidation(tradeStore, exsitingTrade.get())) {
			return true;
		}
		return false;
	}
	
	public boolean tradeValidation(TradeStore newTrade, TradeStore exsitingTrade) {
		if(validateTradeVersion(newTrade, exsitingTrade) && validateMaturityDate(newTrade)) {
			return true;
		}
		return false;
	}
	
	//trade version validation
	public boolean validateTradeVersion(TradeStore newTrade, TradeStore exsitingTrade) {
		return (newTrade.getVersion()>=exsitingTrade.getVersion()) ? true : false;
	}

	//maturityDate validation
	public boolean validateMaturityDate(TradeStore trade) {
		return (trade.getMaturityDate().isBefore(LocalDate.now()))? false : true;
	}
	
	
	public void saveTrade(TradeStore tradeStore) {
		// TODO Auto-generated method stub
		tradeRepository.save(tradeStore);
	}

	public List<TradeStore> getAllTrades() {
		// TODO Auto-generated method stub
		return (List<TradeStore>) tradeRepository.findAll();
	}

}
