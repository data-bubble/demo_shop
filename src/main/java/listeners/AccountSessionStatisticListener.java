package listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import constants.Constants;

/**
 * Application Lifecycle Listener implementation class HSLImpl
 *
 */
@WebListener
public class AccountSessionStatisticListener implements HttpSessionListener {

    
    public AccountSessionStatisticListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
    	StringBuffer buf=new StringBuffer();
         se.getSession().setAttribute(Constants.SESSION_STRING_BUFFER, buf);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public synchronized void sessionDestroyed(HttpSessionEvent se)  { 
     System.out.println(se.getSession().getAttribute(Constants.SESSION_STRING_BUFFER));
    	System.out.println("session close");
    }
	
}
