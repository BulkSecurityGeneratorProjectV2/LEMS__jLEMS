package org.lemsml.expression;

import java.util.HashMap;

import org.lemsml.eval.BVal;
import org.lemsml.eval.Or;
import org.lemsml.util.ContentError;

public class OrNode extends BooleanResultNode {

        public static final String SYMBOL = ".or.";

	public OrNode() {
		super(SYMBOL);
	}

        @Override
        protected String getMathMLElementName() {
                return "or"; // TODO: check..
        }


	
	public OrNode copy() {
		return new OrNode();
	}
	
	public int getPrecedence() {
		return 20;// TODO: check..
	}
	 
	public boolean bool(boolean x, boolean y) {
		return x || y;
	}

	
	public BVal makeFixed(HashMap<String, Double> fixedHM) {
		return new Or(leftEvaluable.makeFixed(fixedHM), rightEvaluable.makeFixed(fixedHM));
	}

	 
	public Dimensional dimop(Dimensional dl, Dimensional dr) throws ContentError {
		Dimensional ret = null;
		if (dl.matches(dr)) {
			ret = dl;
		} else {
			throw(new ContentError("Dimensions do not match in plus: " + dl + " " + dr));
		}
		return ret;
	}

	public void checkDimensions(HashMap<String, Dimensional> dimHM) throws ContentError {
		getDimensionality(dimHM);
	}
}
