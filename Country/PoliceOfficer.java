package Country;

import Imigranti.Extremal_Imigrant;
import Imigranti.Imigrant;

public abstract class PoliceOfficer {
	
	protected String name;
	protected City city;
	private Country country;
	
	
	public PoliceOfficer(String name) {
		this.name = name;
	}
	
	public abstract int getChanceOfCatchingImigrant();
	
	public void assignToCity(City c){
		this.city=c;
		this.country=c.getCountry();
	}
	
	public abstract boolean checkImigrant(Imigrant i);

	
	
	

}
