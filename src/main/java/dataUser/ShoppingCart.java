package dataUser;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ShoppingCart implements Serializable {

	private static final long serialVersionUID = 1298327438L;
	private Map<Integer, Integer> map;
	private int allCount = 0;

	public ShoppingCart() {
		map = new HashMap<>();
	}

	public ShoppingCart(Map<Integer, Integer> map) {
		this.map = new HashMap<>(map);
	}

	public void addProduct(int idProduct, int count) throws IllegalArgumentException {
		int totalCount = 0;
		if (map.containsKey(idProduct)) {
			totalCount = map.get(idProduct);
			totalCount += count;
		} else
			totalCount = count;

		if (totalCount > 10)
			throw new IllegalArgumentException(" не верное количеcтво товара");
		else if (map.size() == 20)
			throw new IllegalArgumentException("корзина переполнена");
		else
			map.put(idProduct, totalCount);

	}

	public void removeProduct(Integer idProduct, int count) {
		if (map.containsKey(idProduct)) {
			int c = map.get(idProduct);
			c = (c - count >= 0) ? c - count : 0;
			map.replace(idProduct, c);
		}
	}

	public Map<Integer, Integer> getMap() {
		return map;
	}

	public String getCount() {
		int totalCount = 0;
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			totalCount += entry.getValue();
		}
		return String.valueOf(totalCount);
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			builder.append(entry.getKey().toString()).append(":").append(entry.getValue().toString()).append("\n");
		}
		return builder.toString();
	}

	/*
	 * public int getCount() { return allCount;
	 * 
	 * }
	 */

}
