package org.lemsml.type;

import org.lemsml.annotation.Mat;
import org.lemsml.annotation.Mel;


@Mel(info="Specifies that instances of components based on this class can containe a named collection of other instances. " +
		"This provides for containers for oprating on groups of instances with path and filter expressions defined in " +
		"components to operate over the instance tree.")
public class Collection implements Named {

	@Mat(info="")
	public String name;
	
	public String getName() {
		return name;
	}

	public Collection makeCopy() {
		Collection ret = new Collection();
		ret.name = name;
		return ret;
	}
	
}
