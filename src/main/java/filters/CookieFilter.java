package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import dataUser.ShoppingCart;
import utils.SerializeCookie;
import utils.SessionUtils;

/**
 * Servlet Filter implementation class CookieFilter
 */
@WebFilter("/shop")
public class CookieFilter implements Filter {

  
    public CookieFilter() {

    }


	public void destroy() {
	
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		HttpServletRequest req=(HttpServletRequest)request;
		if(!SessionUtils.isCurrentShoppingCartCreated(req)) {
			Cookie cookie=SessionUtils.findShoppingCartCookie(req);
	
			ShoppingCart shoppingCart=SessionUtils.getCurrentShoppingCart(req);
				if(cookie!=null) {
				
					 shoppingCart=SerializeCookie.shoppingCartFromString(cookie.getValue());
		
					
					
						}SessionUtils.setCurrentShoppingCart(req, shoppingCart);
		}
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
