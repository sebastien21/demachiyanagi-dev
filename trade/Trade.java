package trade;

/**
 * trade entity
 * @author acmil
 *
 */
public class Trade {
	private String tradeId;
	private WorkStatus work;
	private TradeStatus status;
	private String code;
	private String amount;
	private String buyOrSell;
	private String updater;
	
	//constructor
	public Trade(String id, WorkStatus work, TradeStatus status, String code, String amount, String buyOrSell, String updater) {
		this.tradeId = id;
		this.work = work;
		this.status = status;
		this.code = code;
		this.amount = amount;
		this.buyOrSell = buyOrSell;
		this.updater = updater;
	}
	
	public WorkStatus getWork() {
		return work;
	}

	public void setWork(WorkStatus work) {
		this.work = work;
	}

	public TradeStatus getStatus() {
		return status;
	}
	public void setStatus(TradeStatus status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getBuyOrSell() {
		return buyOrSell;
	}
	public void setBuyOrSell(String buyOrSell) {
		this.buyOrSell = buyOrSell;
	}

	public String getUpdater() {
		return updater;
	}
	public void setUpdater(String updater) {
		this.updater = updater;
	}

	public String getTradeId() {
		return tradeId;
	}
	public void setTradeId(String id) {
		this.tradeId = id;
	}
	
	//change status
	public Trade changeStatus(TradeStatus status, Trade trade, WorkStatus work) {
		trade.setStatus(status);
		trade.setWork(work);
		return trade;
	}
	
	@Override
	public String toString() {
		return this.tradeId + "," + this.work + "," + this.status + "," + this.code + "," 
				+ this.amount + "," + this.buyOrSell + "," + this.updater; 
	}
	
	public String saveString() {
		return this.tradeId + "," + this.work.getWorkStatus() + "," + this.status.getTradeStatus() + "," + this.code + "," 
				+ this.amount + "," + this.buyOrSell + "," + this.updater; 
	}
	
}
