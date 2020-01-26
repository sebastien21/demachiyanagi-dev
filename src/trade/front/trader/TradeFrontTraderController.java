package trade.front.trader;

import java.io.*;
import java.util.HashSet;

import account.Account;
import trade.Trade;
import trade.TradeRepository;
import trade.TradeStatus;
import trade.WorkStatus;

public class TradeFrontTraderController {
	private TradeFrontTraderView frontTraderView;
	private TradeRepository tradeRepository;
	private HashSet<Trade> trades;
	
	//constructor
	public TradeFrontTraderController() throws IOException{
		this.frontTraderView = new TradeFrontTraderView();
		this.tradeRepository = new TradeRepository();
		this.trades = this.tradeRepository.getTrades(); 
	}
	
	//process
	public void process(Account account) throws IOException {
		frontTraderView.showAllTrades();
		frontTraderView.showSubMenu();
		this.subMenuProcess(account);
	}
	
	//sub menu selection
	private void subMenuProcess(Account account) throws IOException{
		BufferedReader subSelection = new BufferedReader(new InputStreamReader(System.in));
		String userSelection = subSelection.readLine();
		
		switch(userSelection) {
		case "1":
			addNewTrade(account);
			break;
		case "2":
			cancelTrade();
			return;
		case "3":
			System.out.println("Return to main menu.");
			return;
		default:
			frontTraderView.showError();
			return;
		}
	}
	
	//add new trade
	private void addNewTrade(Account account) throws IOException{
		//get max trade id
		String tradeId = null;
		if(this.trades == null || this.trades.isEmpty()) {
			this.trades = new HashSet<Trade>();
			tradeId = "1";
		} else {
			for(Trade trade : trades) {
				tradeId = String.valueOf(Integer.parseInt(trade.getTradeId()) + 1);
			}
		}
		
		//ask input
		BufferedReader askInput = new BufferedReader(new InputStreamReader(System.in));
		frontTraderView.askInputCode();
		String code = askInput.readLine();
		
		frontTraderView.askInputAmount();
		String amount = askInput.readLine();
		
		frontTraderView.askInputBuyOrSell();
		String buyOrSell = askInput.readLine();
		
		Trade addTrade = new Trade(tradeId, WorkStatus.上席者承認待ち, TradeStatus.未確定約定, 
				code, amount, buyOrSell, account.getId());
		trades.add(addTrade);
		this.tradeRepository.saveTrades(trades);
	}
	
	//cancel trade
	private void cancelTrade() throws IOException{
		this.frontTraderView.showAllTrades();
		String id = readTraderChoice();
		for(Trade tradeToCancel : this.trades) {
			if(tradeToCancel.getTradeId().equals(id)) {
				this.trades.remove(tradeToCancel);
				String check = checkTradeStatus(tradeToCancel);
				this.statusProcess(trades, check, tradeToCancel);
			}
		}
	}
	
	//trade status judge
	private String checkTradeStatus(Trade trade) {
		TradeStatus statusToCheck = trade.getStatus();
		switch(statusToCheck) {
			case 未確定約定:
				return "unconfirm";
			case 本約定:
				return "confirmed";
			default:
				return "else";
		}
	}
	
	//status process
	private void statusProcess(HashSet<Trade> trades, String status, Trade tradeToCancel) throws IOException{
		switch(status){
			case "unconfirm":
				tradeToCancel.changeStatus(TradeStatus.取消済, tradeToCancel, WorkStatus.取消済);
				trades.add(tradeToCancel);
				this.tradeRepository.saveTrades(trades);
				return;
			case "confirmed":
				tradeToCancel.changeStatus(TradeStatus.取消中, tradeToCancel, WorkStatus.バック承認待ち);
				trades.add(tradeToCancel);
				this.tradeRepository.saveTrades(trades);
				return;
			case "else":
				this.frontTraderView.showNothingToCancel();
				return;
			default:
				return;
		}
	}
	
	//trader choice reader
	private String readTraderChoice() throws IOException{
		BufferedReader readChoice = new BufferedReader(new InputStreamReader(System.in));
		this.frontTraderView.askToChooseOneToCancel();
		String traderChoice = readChoice.readLine();
		return traderChoice;
	}
}
