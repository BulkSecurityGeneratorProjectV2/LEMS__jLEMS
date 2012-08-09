package org.lemsml.run;

import java.util.HashMap;

import org.lemsml.util.ContentError;

public class OtherwiseBuilder extends PostBuilder {

 
	public void postBuild(StateInstance base, HashMap<String, StateInstance> sihm, BuildContext bc) throws ConnectionError, ContentError {
		super.postChildren(base, sihm, bc);	
	}

	@Override
	public void consolidateComponentBehaviors() {
		// TODO Auto-generated method stub
		
	}
 
}
