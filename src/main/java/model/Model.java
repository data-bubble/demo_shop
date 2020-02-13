package model;
import java.io.Serializable;

public class Model implements Serializable{


	private static final long serialVersionUID = 19283918023L;
	
	private String number="Valera";
	
	

	public Model() {
		super();
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
	
		return number;
	}
	
	
	
	
  
}
