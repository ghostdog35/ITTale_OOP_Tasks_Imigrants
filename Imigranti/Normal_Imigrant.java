package Imigranti;

import Country.City;
import Country.Country;

public class Normal_Imigrant extends Imigrant {
	
	private static final int MAX_COUNT_OF_RODNINI =10;

	public Normal_Imigrant(String name, int age, String rodnaDyrjava, String rodenGrad, int money) {
		super(name, age, rodnaDyrjava, rodenGrad, money);
	}
	
	@Override
	public void addRodnina(Imigrant r) {
		if(this.rodnini.size()<MAX_COUNT_OF_RODNINI){
			super.addRodnina(r);
		}
	}

	@Override
	public String toString() {
		return "Normal_Imigrant [ " + super.toString() + "]";
	}
	
	
	

	

	
	

}
