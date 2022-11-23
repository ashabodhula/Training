package io.getarrays.server.enumeration;

public enum Status {
	
	PLAN_ACTIVE("PLAN_ACTIVE"),
	PLAN_NOTACTIVE("PLAN_NOTACTIVE");
	
	private final String status ;
	
	Status(String status){
		this.status=status;
		
	}
	
	public String getStatus() {
		return this.status;
	}

}
