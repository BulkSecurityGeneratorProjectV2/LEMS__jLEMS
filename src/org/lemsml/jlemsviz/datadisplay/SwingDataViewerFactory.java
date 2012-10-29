package org.lemsml.jlemsviz.datadisplay;

import org.lemsml.jlems.display.DataViewer;
import org.lemsml.jlems.display.DataViewerFactory;

public class SwingDataViewerFactory extends DataViewerFactory {

	static SwingDataViewerFactory instance;
	
	// inject this into the jLEMS DataViewerFactory:
	public static void initialize() {
		if (instance == null) {
			instance = new SwingDataViewerFactory();
		}
	 
	} 
	
	private SwingDataViewerFactory() {
		DataViewerFactory.getFactory().setDelegate(this);
	}
	
	
	@Override
	public DataViewer newDataViewer(String title) {
		DataViewer ret = new StandaloneViewer(title);	
		return ret;
	}

 
}
