package trade.front.manager;

import java.io.*;
import java.util.HashSet;

import trade.Trade;
import trade.TradeRepository;
import trade.TradeStatus;
import trade.WorkStatus;

/**
 * manager controller
 * @author acmil
 *
 */
public class TradeFrontManagerController {
	
	private TradeFrontManagerView tradeFrontManagerView;
	
	//constructor
	public TradeFrontManagerController() throws IOException {
		this.tradeFrontManagerView = new TradeFrontManagerView();
	}
	
	//process
	public void process() throws IOException {
		this.tradeFrontManagerView.showSubMenu();
		this.askCommandForSubMenu();
	}
	
	//ask manager commands
	private void askCommandForSubMenu() throws IOException {
		BufferedReader managerCommand = new BufferedReader(new InputStreamReader(System.in));
		
		String managerInput = managerCommand.readLine();
		switch(managerInput) {
			case "1": //confirm
				this.tradeFrontManagerView.showUnconfirmedTrades();
				Trade selectedTrade = this.getOneToConfirm(this.tradeFrontManagerView.getUnconfirmedTrades());
				boolean result = askManagerCommand(selectedTrade);
				this.tradeFrontManagerView.showConfirmResult(result);
				return;
			case "2": //reject
				break;
			case "3":
				System.out.println("Return to main menu.");
				return;
			default:
				return;
		}
	}
	
	//choose one from unconfirmed trade
	private Trade getOneToConfirm(HashSet<Trade> unconfirmedTrades) throws IOException{
		String tradeID = this.readManagerChoice();
		for(Trade tradeToConfirm : unconfirmedTrades) {
			if(tradeToConfirm.getTradeId().equals(tradeID)) {
				System.out.println(tradeToConfirm.toString());
				return tradeToConfirm;
			}
		}
		return null;
	}
	
	//manager choice reader
	private String readManagerChoice() throws IOException{
		BufferedReader readChoice = new BufferedReader(new InputStreamReader(System.in));
		this.tradeFrontManagerView.askToChooseOneTradeToConfirm();
		String managerChoice = readChoice.readLine();
		return managerChoice;
	}
	
	//confirm trades, return status update result
	private boolean changeTradeStatus(Trade trade) throws IOException {
		TradeRepository repository = new TradeRepository();
		HashSet<Trade> allTrade = repository.getTrades();
		for(Trade getChosenTrade : allTrade) {
			if(getChosenTrade.getTradeId().equals(trade.getTradeId())) {
				allTrade.remove(getChosenTrade);
				trade.changeStatus(TradeStatus.±¾¼s¶¨, getChosenTrade, WorkStatus.³ÐÕJœg);
				allTrade.add(getChosenTrade);
				repository.saveTrades(allTrade);
				return true;
			}
		}
		return false;
	}
	
	//ask for update command
	private boolean askManagerCommand(Trade trade) throws IOException{
		//confirmation message
		this.tradeFrontManagerView.askIfConfirm();
		
		//command reader
		BufferedReader getCommandReader = new BufferedReader(new InputStreamReader(System.in));
		String answer = getCommandReader.readLine();
		
		switch(answer.toLowerCase()) {
			case "y":
				return this.changeTradeStatus(trade);
			case "n":
				return false;
			default:
				return false;
		}
	}
}
