<%@page import="dataUser.ShoppingCart"
	 import="constants.Constants"
%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%-- <%ShoppingCart shoppingCart=(ShoppingCart)request.getSession().getAttribute("SHOPPING_CART");%> --%>
<% if(session.getAttribute(Constants.CURRENT_SHOPPING_CART)!=null){ %>
<h1>Count of Products: ${CURRENT_SHOPPING_CART.count}</h1>
<h2>Products:</h2>
${CURRENT_SHOPPING_CART}
<%}else{%>
shopping cart is null
<%}%>