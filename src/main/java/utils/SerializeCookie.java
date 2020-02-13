package utils;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Map.Entry;

import dataUser.ShoppingCart;

public final class SerializeCookie {
	public static String shoppingCartToString(ShoppingCart shoppingCart) {
		
		StringBuilder builder=new StringBuilder();
		for(Entry<Integer,Integer> entry:shoppingCart.getMap().entrySet()) {
			builder.append(String.valueOf(entry.getKey()))
			.append(":")
			.append(entry.getValue())
			.append("|");
		}
	
		return builder.toString();
		
	}
	public static ShoppingCart shoppingCartFromString(String cookieValue) throws IOException {
		ShoppingCart shoppingCart=new ShoppingCart();
		
	
		String[] arro=cookieValue.split("|");
		for(String temp:arro) {
			String[] arr=temp.split(":");
			if(arr.length>2)
				throw new IOException("не правильные параметры продукта");
			shoppingCart.addProduct(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
		}

		return shoppingCart;
	}
}
