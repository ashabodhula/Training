package io.getarrays.server.enumeration;

public enum Type {
	
	
	PREPAID("PREPAID"),
	POSTPAID("POSTPAID");
	
	private final String type ;
	
	Type(String type){
		this.type=type;
		
	}
	
	public String getType() {
		return this.type;
	}


}
