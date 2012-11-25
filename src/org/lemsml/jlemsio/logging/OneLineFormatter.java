package org.lemsml.jlemsio.logging;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;

public class OneLineFormatter extends SimpleFormatter {

	SimpleDateFormat date_format = new SimpleDateFormat("MMM dd,yyyy HH:mm");
 
 
	  public String format(LogRecord rec) {
	    StringBuffer buf = new StringBuffer(1000);
	    buf.append(rec.getLevel());
	    buf.append(" ");
	    buf.append(calcDate(rec.getMillis()));
	    buf.append(' ');
	    buf.append(rec.getMessage());
	    buf.append('\n');
	    return buf.toString();
	  }

	  
	  
	  private String calcDate(long millisecs) {
	    Date resultdate = new Date(millisecs);
	    return date_format.format(resultdate);
	  }


}
