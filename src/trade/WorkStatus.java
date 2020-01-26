package trade;

public enum WorkStatus {

	��ϯ�߳��J����("1"),
	���J�g("2"),
	�Хå����J����("3"),
	ȡ���g("4"),
	����`("5");
	
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
		return WorkStatus.����`;
	}
	
}
