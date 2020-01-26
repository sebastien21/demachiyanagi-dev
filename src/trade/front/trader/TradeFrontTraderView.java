package trade.front.trader;

import java.io.IOException;
import java.util.HashSet;
import trade.Trade;
import trade.TradeRepository;

public class TradeFrontTraderView {
	
	private TradeRepository tradeRepository;
	
	//constructor
	public TradeFrontTraderView() {
	}
	
	//show all
	public void showAllTrades() throws IOException {
		this.tradeRepository = new TradeRepository();
		HashSet<Trade> allTrades =  this.tradeRepository.getTrades();
		if(allTrades == null || allTrades.isEmpty()) showEmpty();
		else {
			allTrades.forEach(trade -> System.out.println(trade.toString()));
		}
	}
	
	//show submenu
	public void showSubMenu() {
		System.out.println("1.Add new Trade / 2.Cancel / 3.Return");
	}
	
	//show error
	public void showError() {
		System.out.println("Error.");
	}
	
	//show empty
	public void showEmpty() {
		System.out.println("No trades in the record.");
	}
	
	//show input message
	public void askInputCode() {
		System.out.print("Please enter code : ");
	}
	public void askInputAmount() {
		System.out.print("Please enter amount : ");
	}
	public void askInputBuyOrSell() {
		System.out.print("Buy(B) or Sell(S): ");
	}
	
	//cancel
	public void askToChooseOneToCancel() {
		System.out.println("Chose a trade to cancel.");
	}
	public void askIfCancel() {
		System.out.println("Cancel this trade? y/n");
	}
	public void showCancelSucceeded() {
		System.out.println("Cancel succeeded.");
	}
	public void showCancelFailed() {
		System.out.println("Cancel failed.");
	}
	public void showNothingToCancel() {
		System.out.println("Nothing to do here.");
	}
	
}
