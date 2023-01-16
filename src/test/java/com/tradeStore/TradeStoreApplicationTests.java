package com.tradeStore;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.tradeStore.controller.TradeStoreController;
import com.tradeStore.exception.InvalidTradeException;
import com.tradeStore.model.TradeStore;

@SpringBootTest
class TradeStoreApplicationTest {

	@SpyBean
	private TradeStoreController controller;

	private static final List<TradeStore> trades = new ArrayList<>(4);

	@BeforeAll
	public static void setup() {
		trades.add(new TradeStore("T1", 1, "CP-1", "B1", LocalDate.of(2021, 4, 21), LocalDate.now(), "N"));
		trades.add(new TradeStore("T2", 2, "CP-2", "B1", LocalDate.of(2021, 4, 21), LocalDate.now(), "N"));
		trades.add(new TradeStore("T2", 1, "CP-1", "B1", LocalDate.of(2021, 4, 21), LocalDate.of(2016, 4, 21), "N"));
		trades.add(new TradeStore("T3", 3, "CP-3", "B2", LocalDate.of(2021, 4, 21), LocalDate.now(), "Y"));
	}

	@Test
	void testTradeStoreTradeVersion() {
		//new trade T1 , equal version and valid maturity date
		ResponseEntity<String> status = this.controller
				.newTrades(new TradeStore("T1", 1, "CP-1", "B1", LocalDate.of(2023, 5, 20), LocalDate.now(), "N"));

		assertSame(HttpStatus.OK, status.getStatusCode());

		//new trade T1 , higher version and valid maturity date
		status = this.controller
				.newTrades(new TradeStore("T1", 2, "CP-1", "B1", LocalDate.of(2023, 5, 20), LocalDate.now(), "N"));

		assertSame(HttpStatus.OK, status.getStatusCode());
		
		//new trade T1 , invalid version and invalid maturity date
		assertThrows(InvalidTradeException.class, () -> this.controller
						.newTrades(new TradeStore("T1", 0, "CP-1", "B1", LocalDate.of(2022, 5, 20), LocalDate.now(), "N")));
		
		//new trade T1 , equal version and invalid maturity date
		assertThrows(InvalidTradeException.class, () -> this.controller
				.newTrades(new TradeStore("T1", 2, "CP-1", "B1", LocalDate.of(2022, 5, 20), LocalDate.now(), "N")));
	}

}
