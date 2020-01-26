package trade;

public enum TradeStatus {
	δ�_���s��("1"),
	���s��("2"),
	ȡ����("3"),
	�Хå����J�g��("4"),
	ȡ���g("5"),
	����`("6");
	
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
		return TradeStatus.����`;
	}
}
