package org.lemsml.expression;

import java.util.HashMap;

import org.lemsml.util.ContentError;

public interface Evaluable {
	
	public void evaluablize() throws ParseError;

	public void setValues(HashMap<String, Valued> valHM) throws ContentError;

	
	public Dimensional getDimensionality(HashMap<String, Dimensional> dimHM) throws ContentError;

    public String getMathML(String indent, String innerIndent);

	public Dimensional evaluateDimensional(HashMap<String, Dimensional> adml) throws ContentError;
}
