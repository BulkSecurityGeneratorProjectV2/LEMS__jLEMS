package org.lemsml.expression;

import java.util.HashMap;

import org.lemsml.eval.DCon;
import org.lemsml.eval.DVal;
import org.lemsml.util.ContentError;

public class ConstantNode extends Node implements DoubleEvaluable {
	
	String sval = null;

	double dval;
	
	public ConstantNode(String s) {
		super();
		sval = s;
		dval = Double.parseDouble(s);
	}
	
        @Override
	public String toString() {
		return sval;
	}

        public String getMathML(String indent, String innerIndent) {
                return indent+"<cn> "+(float)dval+" </cn>";
        }



	 
	public double evalD(HashMap<String, Double> valHS) {
		 return dval;
	}
 
	public void evaluablize() {
	 
		
	}

	 
	public void setValues(HashMap<String, Valued> valHM) {
		// doesn't need them
	}


	public DVal makeFixed(HashMap<String, Double> fixedHM) {
		return new DCon(dval);
	}

	public double getDoubleValue() {
		return dval;
	}

	 
	public Dimensional getDimensionality(HashMap<String, Dimensional> dimHM) throws ContentError {
		ExprDimensional ed = new ExprDimensional();
		if (dval == 0) {
			ed.setZero();
		}
		ed.setDoubleValue(dval);
		return ed;
	}
	

	public Dimensional evaluateDimensional(HashMap<String, Dimensional> dhm) throws ContentError {
		throw new ContentError("Can't use constants with  dimensions");
	}
	
	
	
}
