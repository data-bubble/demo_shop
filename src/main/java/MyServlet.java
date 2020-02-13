

import java.io.IOException;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import constants.Constants;
import dataUser.ShoppingCart;
import utils.SerializeCookie;
import utils.SessionUtils;
import utils.WebUtils;
import model.Model;


@WebServlet("/shop")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		

			ShoppingCart shoppingCart=SessionUtils.getCurrentShoppingCart(request);
			if(request.getParameter("add")!=null) {
				addProductFromRequest(shoppingCart,request.getParameter("add"));
			}

			String value=SerializeCookie.shoppingCartToString(shoppingCart);
			
			SessionUtils.updateCurrentShoppingCartCookie(value, response);
			

		
	
	request.getRequestDispatcher("/index.jsp").forward(request, response);}
			
		
	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}
	private String addProductFromRequest(ShoppingCart cart,String value) {
		String[] arr=value.split(":");
		
		int id=0;
		try {
			 id=Integer.parseInt(arr[0]);
			int count=Integer.parseInt(arr[1]);
			cart.addProduct(id, count);
		}
		catch(NumberFormatException e) {
			
		}
		return arr[0];
		
	}

}
