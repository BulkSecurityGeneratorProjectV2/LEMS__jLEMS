package org.lemsml.expression;

import java.util.HashMap;

import org.lemsml.eval.And;
import org.lemsml.eval.BVal;
import org.lemsml.util.ContentError;

public class AndNode extends BooleanResultNode {

        public static final String SYMBOL = ".and.";

	public AndNode() {
		super(SYMBOL);
	}

        @Override
        protected String getMathMLElementName() {
                return "and"; // TODO: check..
        }


	
	public AndNode copy() {
		return new AndNode();
	}
	
	public int getPrecedence() {
		return 20;// TODO: check..
	}
	 
	public boolean bool(boolean x, boolean y) {
		return x && y;
	}

	
	public BVal makeFixed(HashMap<String, Double> fixedHM) {
		return new And(leftEvaluable.makeFixed(fixedHM), rightEvaluable.makeFixed(fixedHM));
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
