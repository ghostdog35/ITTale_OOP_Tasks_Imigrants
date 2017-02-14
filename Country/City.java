package Country;

import java.util.ArrayList;
import java.util.Random;

import Imigranti.Imigrant;

public class City {
	
	private String name;
	private Country country;
	private ArrayList<PoliceOfficer> policai;
	private int countOfCitizens;
	public ArrayList<Imigrant> imigranti;
	
	public City(Country country, String name, int countOfCitizens) {
		this.name = name;
		this.country=country;
		this.countOfCitizens = countOfCitizens;
		this.policai=new ArrayList<>();
		this.imigranti= new ArrayList<>();
	}
	
	public void addPoliceOfficer(PoliceOfficer p){
		if(p!=null){
			this.policai.add(p);
			p.assignToCity(this);
		}
	}
	
	public boolean addImigrant(Imigrant i){
		if(this.policai.get(new Random().nextInt(this.policai.size())).checkImigrant(i)){
			this.imigranti.add(i);
			this.countOfCitizens++;
			return true;
		}
		return false;
	}
	
	public boolean removeImigrant(Imigrant i){
		if(this.imigranti.contains(i)){
			this.imigranti.remove(i);
			this.countOfCitizens--;
			return true;
		}
		return false;
	}
	
	public void getPeopleShot(int n){
		System.out.println("In todays shoutout "+n+" citizens from city "+this.name+" was killed.");
		this.countOfCitizens-=n;
	}
	
	public Country getCountry() {
		return country;
	}

	public void showInfo() {
		System.out.println("Info za grad "+this.name);
		System.out.println("Broi jiteli "+ this.countOfCitizens);
		System.out.println("Policai: "+this.policai);
		System.out.println("Imigranti: "+ this.imigranti);
	}
	
	

}
