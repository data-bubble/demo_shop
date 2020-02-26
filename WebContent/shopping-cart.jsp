<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

 <%@page import="dataUser.ShoppingCart"%>



   <c:set var="cart" scope="session" value="${sessionScope.CURRENT_SHOPPING_CART}"/> 

<c:if test="${!empty cart}"> 
<c:forEach var="item" items="${cart.map}">
ID:
<c:out value="${item.key}"/>
&nbsp;&nbsp;Count:
<c:out value="${item.value}"/>
<br>
</c:forEach>

</c:if>
<c:if test="${empty cart}">
<c:out value="ShoppingCart is empty"></c:out>
</c:if>  