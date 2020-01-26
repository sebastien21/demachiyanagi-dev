package trade;

public enum WorkStatus {

	上席者承認待ち("1"),
	承認済("2"),
	バック承認待ち("3"),
	取消済("4"),
	エラー("5");
	
	private String status;
	WorkStatus(String status){
		this.status = status;
	}
	
	//get status String name
	public String getWorkStatus() {
		return this.status;
	}
		
	//return status type by name 
	public static WorkStatus fromWorkStatusName(String status) {
		for(WorkStatus aWorkStatus : WorkStatus.values()) {
			if(aWorkStatus.getWorkStatus().equals(status)) 
				return aWorkStatus;
		}
		return WorkStatus.エラー;
	}
	
}
