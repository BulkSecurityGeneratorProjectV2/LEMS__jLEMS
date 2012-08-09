package org.lemsml.selection;

import java.util.Comparator;

public class SelectionPrecedenceComparator implements Comparator<SelectionOperatorNode> {

	 
	public int compare(SelectionOperatorNode a, SelectionOperatorNode b) {
		double pa = a.getPrecedence();
		double pb = b.getPrecedence();
		
		int ret = 0;
		if (pa < pb) {
			ret = -1;
		} else if (pa > pb) {
			ret = 1;
		}
		return ret;
	}

}
