package trade;

import java.io.*;
import java.util.HashSet;

public class TradeRepository {

	private HashSet<Trade> trades;
	
	//constructor
	public TradeRepository(){
		this.trades = new HashSet<Trade>();
	}
	
	
	//get trade from file
	public HashSet<Trade> getTrades() throws IOException{
		File tradeFile = new File("TRADE.csv");
		
		if(!tradeFile.exists()) {
			tradeFile.createNewFile();
		}
		
		InputStreamReader readTradeFile = new InputStreamReader(new FileInputStream(tradeFile));
		BufferedReader readFile = new BufferedReader(readTradeFile);
		String tradeDetails;
		while((tradeDetails  = readFile.readLine()) != null) {
			String[] details = tradeDetails.split(",");
			Trade trade = new Trade(details[0], WorkStatus.fromWorkStatusName(details[1]), TradeStatus.fromTradeStatusName(details[2]), 
					details[3], details[4], details[5], details[6]);
			trades.add(trade);
		}
		readFile.close();
		
		return this.trades;
	}
	
	//save trades
	public void saveTrades(HashSet<Trade> trades) throws IOException{
		File tradeFile = new File("TRADE.csv");
		
		if(!tradeFile.exists()) {
			tradeFile.createNewFile();
		}
		
		FileWriter tradeWriter = new FileWriter(tradeFile, false);
		PrintWriter printWriterForTrade = new PrintWriter(tradeWriter);
		
		tradeWriter.flush();
		//TODO   list comparator method override
		
		trades.forEach(trade -> {
			printWriterForTrade.println(trade.saveString());
		});
		printWriterForTrade.close();
	}
}
