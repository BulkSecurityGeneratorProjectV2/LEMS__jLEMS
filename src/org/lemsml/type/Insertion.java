package org.lemsml.type;

public class Insertion {

	
	public String component;

	public Insertion() {
		
	}
	
	
	public Insertion(String cpt) {
		component = cpt;
	}
	
	
	public Insertion makeCopy() {
		Insertion ret = new Insertion(component);
		return ret;
	}
	
	
}

