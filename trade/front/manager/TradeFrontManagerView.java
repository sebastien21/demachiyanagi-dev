package trade.front.manager;

import java.util.HashSet;
import java.io.*;
import trade.Trade;
import trade.TradeRepository;
import trade.TradeStatus;
import trade.WorkStatus;

public class TradeFrontManagerView {

	private TradeRepository tradeRepository;
	private HashSet<Trade> allTrades;
	
	//constructor
	public TradeFrontManagerView() throws IOException{
		this.tradeRepository = new TradeRepository();
		this.allTrades = this.tradeRepository.getTrades();
	}

	//show unconfirmed trades
	public void showUnconfirmedTrades() {
		HashSet<Trade> waitForConfirmation = this.getUnconfirmedTrades();
		
		if(waitForConfirmation.isEmpty()) {
			showEmpty();
		} else {
			waitForConfirmation.forEach(trade -> System.out.println(trade.toString()));
		}
	}
	
	//show empty
	private void showEmpty() {
		System.out.println("No unconfirmed trades left.");
	}
	
	//show sub menu
	public void showSubMenu() {
		System.out.println("1.Confirm trades / 2.Reject trades / 3.Return");
	}
	
	//ask to choose one to confirm
	public void askToChooseOneTradeToConfirm() {
		System.out.println("Enter the trade's id to confirm from the list above.");
	}
	
	//get unconfirmed trades
	public HashSet<Trade> getUnconfirmedTrades(){
		HashSet<Trade> waitForConfirmation = new HashSet<Trade>();
		for(Trade unconfirmedTrade : allTrades) {
			if(unconfirmedTrade.getWork() == WorkStatus.上席者承認待ち) {
				if(unconfirmedTrade.getStatus() == TradeStatus.未確定約定) {
				waitForConfirmation.add(unconfirmedTrade);
				}
			}
		}
		
		return waitForConfirmation;
	}
	
	//show confirm operation message
	public void askIfConfirm() {
		System.out.println("Confirm this trade? y/n");
	}
	
	//show confirm result
	public void showConfirmResult(boolean result) {
		if(result == true) {
			System.out.println("Update succeeded.");
		} else {
			System.out.println("Update failed.");
		}
	}
	
}
