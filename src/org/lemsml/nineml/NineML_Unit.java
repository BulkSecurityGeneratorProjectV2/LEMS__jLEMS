package org.lemsml.nineml;

import org.lemsml.io.IOFace;
import org.lemsml.type.Unit;

public class NineML_Unit implements IOFace {
  
	public String symbol;
	public String dimension;
	
	public int powTen = 0;
	public double scale = 1;
	public double offset = 0;
	
	
	@Override
	public Object getInternal() {
		Unit u = new Unit();
		u.symbol = symbol;
		u.dimension = dimension;
		u.power = powTen;
		u.scale = scale;
		u.offset = offset;
		return u;
	}

	    
	
	    
	    
}
