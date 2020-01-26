package trade;

public enum TradeStatus {
	未確定約定("1"),
	本約定("2"),
	取消中("3"),
	バック承認済み("4"),
	取消済("5"),
	エラー("6");
	
	private String status;
	TradeStatus(String status){
		this.status = status;
	}
	
	//get status String name
	public String getTradeStatus() {
		return this.status;
	}
		
	//return status type by name 
	public static TradeStatus fromTradeStatusName(String status) {
		for(TradeStatus aTradeStatus : TradeStatus.values()) {
			if(aTradeStatus.getTradeStatus().equals(status)) 
				return aTradeStatus;
		}
		return TradeStatus.エラー;
	}
}
