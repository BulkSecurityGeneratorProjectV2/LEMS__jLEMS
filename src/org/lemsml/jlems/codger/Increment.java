package org.lemsml.jlems.codger;

public class Increment extends AbstractOperation {

	String variable;
	AbstractExpression value;
	
	public Increment(String var, AbstractExpression val) {
		super();
		variable = var;
		value = val;
	}

	@Override
	public String generateJava() {
		String ret = "" + variable + " += " + value.generateJava() + ";";
		return ret;
	}
	
	
}
