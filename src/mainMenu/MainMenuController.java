package mainMenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import account.Account;
import trade.back.TradeBackController;
import trade.front.manager.TradeFrontManagerController;
import trade.front.trader.TradeFrontTraderController;

public class MainMenuController {
	
	private MainMenuView mainMenuView;
	
	//constructor
	public MainMenuController() {
		this.mainMenuView = new MainMenuView();
	}
	
	//process
	public void process(Account account) throws IOException{
		switch(account.getAuthority()) {
			case FRONT_MANAGER:
				this.mainMenuView.showManagerMenu();
				managerMenuSelection();
				return;
			case FRONT_GENERAL:
				this.mainMenuView.showTraderMenu();
				traderMenuSelection(account);
				return;
			case BACK_USER:
				this.mainMenuView.showBackMenu();
				backMenuSelection();
				return;
			default:
				return;
		}
	}
	
	//trader's command
	private void traderMenuSelection(Account account) throws IOException {
		BufferedReader subSelection = new BufferedReader(new InputStreamReader(System.in));
		String userSelection = subSelection.readLine();
		
		switch(userSelection) {
			case "1":
				TradeFrontTraderController tradeFrontTraderController = new TradeFrontTraderController();
				tradeFrontTraderController.process(account);
				break;
			case "2":
				System.exit(0);
				return;
			default:
				return;
		}
	}
	
	//manager's command
	private void managerMenuSelection() throws IOException {
		BufferedReader subSelection = new BufferedReader(new InputStreamReader(System.in));
		String managerSelection = subSelection.readLine();
		
		switch(managerSelection) {
			case "1":
				TradeFrontManagerController tradeFrontManagerController = new TradeFrontManagerController();
				tradeFrontManagerController.process();
				break;
			case "2":
				System.exit(0);
				return;
			default:
				return;
		}
	}
	
	//back's command
	private void backMenuSelection() throws IOException{
		BufferedReader subSelection = new BufferedReader(new InputStreamReader(System.in));
		String managerSelection = subSelection.readLine();
		
		switch(managerSelection) {
			case "1":
				TradeBackController tradeBackController = new TradeBackController();
				tradeBackController.process();
				break;
			case "2":
				System.exit(0);
			default:
				return;
		}
	}
}
