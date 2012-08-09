package org.lemsml.behavior;

import java.util.HashMap;

import org.lemsml.expression.Dimensional;
import org.lemsml.expression.DoubleEvaluable;
import org.lemsml.expression.ParseError;
import org.lemsml.expression.Parser;
import org.lemsml.expression.Valued;
import org.lemsml.type.Dimension;
import org.lemsml.type.LemsCollection;
import org.lemsml.util.ContentError;
import org.lemsml.util.E;

public abstract class StateChange extends ExpressionValued {

	public String variable;
	
	private StateVariable r_variable;
	 

	DoubleEvaluable evaluable;
	

	public StateChange() {
		
	}
	
   public StateChange(String vnm) {
	   variable = vnm;
   }
	
	public void resolve(LemsCollection<StateVariable> stateVariables, HashMap<String, Valued> valHM, Parser parser) throws ContentError, ParseError {
		super.extract();
		
		if (stateVariables.hasName(variable)) {
			r_variable = stateVariables.getByName(variable);
		} else {
			StringBuilder error = new StringBuilder("Can't find variable " + variable+" for state variable "+ r_variable+"\nState variables:");
			for (StateVariable sv:stateVariables) {
				error.append("\n    "+sv.getName()+": "+sv);
			}
			throw new ContentError(error.toString());
		}
		
		try {
			evaluable = parser.parseExpression(value);
			evaluable.setValues(valHM);

		} catch (ContentError ce) {
			throw new ContentError(ce.getMessage() + " variable is " + variable + " xSource expression: " + value);
		}
		
	}
	
	public StateVariable getStateVariable() {
		return r_variable;
	}
	
	public DoubleEvaluable getEvaluable() {
		 return evaluable;
	}
	
    public void checkDimensions(HashMap<String, Dimensional> dimHM) throws ContentError {
        try {

            Dimensional drhs = evaluable.getDimensionality(dimHM);
            if (drhs.isAny()) {
                // fine - zero can be assigned to anything
            } else {
                Dimensional dsv = r_variable.getDimension();
                Dimensional dlf = getStateVariableDimensionMultiplier();

                Dimensional dl = dsv.getTimes(dlf);
                Dimensional dres = drhs.getDivideBy(dl);

                if (dres.isDimensionless()) {
                    // OK
                } else {
                    E.oneLineError("Dimension mismatch in equation: " + variable + " = " + value + ". Residual dimension: " + dres);
                    E.info("Dimension of " + variable + ": " + dsv + ", multiplier=" + dlf + ", left=" + dl + ", rhs=" + drhs);
                    E.info("All:" + dimHM);
                }
            }
        } catch (ContentError ex) {
            E.oneLineError("Error checking dimensions in equation for " + variable + ", " + value + ":\n" + ex);
            //ex.printStackTrace();
        } catch (Exception ex) {
            E.info("Error parsing " + variable + "    " + value + " ");
            ex.printStackTrace();
        }

    }

	
	public abstract Dimension getStateVariableDimensionMultiplier();
	
	
}
