package org.lemsml.behavior;

import org.lemsml.annotation.Mat;
import org.lemsml.expression.Valued;
import org.lemsml.type.Children;
import org.lemsml.type.ComponentReference;
import org.lemsml.type.ComponentType;
import org.lemsml.util.ContentError;



public class Edges {

	@Mat(info="The element that provides the transitions for the scheme")
	public String children;

	@Mat(info="The name of the attribute in the rate element that defines the source of the transition")
	public String sourceNodeName;
	
	@Mat(info="")
	public String targetNodeName;
	
	@Mat(info="")
	public String forwardRate;

	@Mat(info="")
	public String reverseRate;
	
	
	ComponentReference r_srcRef;
	ComponentReference r_tgtRef;
	
	Valued frv;
	Valued rrv;
	
	
	public void resolve(Children r_edges) throws ContentError {
		ComponentType tedge = r_edges.getComponentType();
		
		r_srcRef = tedge.getComponentRef(sourceNodeName);
		r_tgtRef = tedge.getComponentRef(sourceNodeName);
		
		/*
	 	Behavior b = tedge.getBehavior();
		frv = b.getValued(forwardRate);
		rrv = b.getValued(reverseRate);
		*/
	}
	
}
