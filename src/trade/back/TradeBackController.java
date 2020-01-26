package trade.back;

import java.io.IOException;
import java.util.HashSet;
import trade.Trade;
import trade.TradeRepository;
import trade.TradeStatus;
import trade.WorkStatus;

public class TradeBackController {
	
	//fields
	private TradeBackView tradeBackView;
	private HashSet<Trade> trades;
	
	//constructor
	public TradeBackController() {
		this.tradeBackView = new TradeBackView();
		this.trades = new HashSet<Trade>();
	}
	
	//process
	public void process() throws IOException{
		this.tradeBackView.showTradesToConfirm();
		this.tradeBackView.showSubMenu();
		this.commandProcess();
	}
	
	//command switch
	private void commandProcess() throws IOException{
		this.trades = this.tradeBackView.getTrades();
		
		//choice
		String choice = this.tradeBackView.readUserChoice();
		
		switch(choice) {
			case "1":
				this.tradeBackView.askOneToConfirm();
				String tradeId = this.tradeBackView.readUserChoice();
				this.executeConfirm(tradeId, trades);
				return;
			case "2":
				return;
			default:
				return;
		}
	}
	
	//execute
	private void executeConfirm(String tradeId, HashSet<Trade> trades) throws IOException{
		//inputed choice
		Trade getOne = this.getOneToConfirm(tradeId);
		this.tradeBackView.askIfToConfirm();
		String choice = this.tradeBackView.readUserChoice();
		//switch
		switch(choice.toLowerCase()) {
			case "y":
				if(this.changeStatus(trades, getOne)) {
					this.tradeBackView.showSuccess();
				} else {
					this.tradeBackView.showFail();
				}
				break;
			case "n":
				break;
			default:
				break;
		}
		
	}
	
	//confirm process
	private Trade getOneToConfirm(String tradeId) throws IOException{
		this.trades = this.tradeBackView.getTrades();
		for(Trade one : this.trades) {
			if(one.getTradeId().equals(tradeId) && one.getWork() == WorkStatus.¥Ð¥Ã¥¯³ÐÕJ´ý¤Á) {
				return one;
			}
		}
		return null;
	}
	
	//confirmation
	private boolean changeStatus(HashSet<Trade> trades, Trade trade) throws IOException{
		
		if(trade == null) {
			return false;
		}
		
		//size check
		Integer beforeSize = trades.size();
		
		//process
		trades.remove(trade);
		trade.changeStatus(TradeStatus.¥Ð¥Ã¥¯³ÐÕJœg¤ß, trade, WorkStatus.³ÐÕJœg);
		trades.add(trade);
		TradeRepository repository = new TradeRepository();
		repository.saveTrades(trades);

		//size check
		Integer afterSize = trades.size();
		return beforeSize == afterSize;
	}
}
