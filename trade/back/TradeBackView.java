package trade.back;

import java.io.*;
import java.util.HashSet;
import trade.Trade;
import trade.TradeRepository;
import trade.WorkStatus;

/**
 * back view
 * @author acmil
 *
 */
public class TradeBackView {
	
	//fields
	private TradeRepository backTradeRepository;
	private HashSet<Trade> trades;
	
	public TradeBackView() {
		this.backTradeRepository = new TradeRepository();
		this.trades = new HashSet<Trade>();
	}
	
	//show trade awaits confirmation
	public void showTradesToConfirm() throws IOException{
		this.trades = this.backTradeRepository.getTrades();
		HashSet<Trade> unconfirmed = new HashSet<Trade>();
		for(Trade unconfirm : this.trades) {
			if(unconfirm.getWork() == WorkStatus.¥Ð¥Ã¥¯³ÐÕJ´ý¤Á) {
				unconfirmed.add(unconfirm);
			}
		}
		unconfirmed.forEach(trade -> {System.out.println(trade.toString());});
	}
	
	//sub menu
	public void showSubMenu() {
		System.out.println("1. Confirm trades / 2. Exit");
	}
	
	//read back user choice
	public String readUserChoice() throws IOException{
		BufferedReader choiceReader = new BufferedReader(new InputStreamReader(System.in));
		String choice = choiceReader.readLine();
		return choice;
	}
	
	//show confirm message
	public void askOneToConfirm() {
		System.out.println("Enter the trade'id to confirm.");
	}
	public void askIfToConfirm() {
		System.out.println("Confirm this trade? y/n");
	}
	public void showSuccess() {
		System.out.println("Confirmation succeeded.");
	}
	public void showFail() {
		System.out.println("Confirmation failed.");
	}
	
	
	//field getter
	public HashSet<Trade> getTrades() throws IOException{
		return this.trades = this.backTradeRepository.getTrades();
	}
	
	//show one trade
	public void showTradeDetail(Trade trade) {
		System.out.println(trade.toString());
	}
}
