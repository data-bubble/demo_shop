package listeners;

import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import constants.Constants;
/**
 * Application Lifecycle Listener implementation class AccountRequestStatisticsListener
 *
 */
@WebListener
public class AccountRequestStatisticsListener implements ServletRequestListener {

  
    public AccountRequestStatisticsListener() {

    }


    public void requestDestroyed(ServletRequestEvent sre)  { 
      
    }

	
    public void requestInitialized(ServletRequestEvent sre)  { 
    	
    	
    HttpServletRequest req=(HttpServletRequest)sre.getServletRequest();
    
    	
    	StringBuffer buf=(StringBuffer)req.getSession().getAttribute(Constants.SESSION_STRING_BUFFER);
    	if(buf==null) {
    		buf=new StringBuffer();
    		req.getSession().setAttribute(Constants.SESSION_STRING_BUFFER, buf);
    	}
    	buf.append(getRequestData(req));
    	
    
    
    	}
    private String getRequestData(HttpServletRequest req) { 
		    	StringBuilder builder=new StringBuilder();  
		    	Map<String,String[]> map=req.getParameterMap();
		    	 builder.append(req.getMethod())
		    .append(req.getRequestURI());
		    if(!map.isEmpty()) {
		    	builder.append("?");
		    for(Entry<String,String[]> entry:map.entrySet()) {
		    	builder.append(entry.getKey()+"=");
		    	for(String s:entry.getValue()) 
		    		builder.append(s+":");
		    	builder.replace(builder.length()-1,builder.length(), "&");

		    }
		    builder.deleteCharAt(builder.length()-1);
		    }
		    builder.append("\n");
			return builder.toString();
		}
    
    }
   
