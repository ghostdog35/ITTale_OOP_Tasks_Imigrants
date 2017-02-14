package Country;

import java.util.ArrayList;

import Imigranti.Imigrant;

public class Country {
	
	private String name;
	public ArrayList<City> gradove;
	private ArrayList<Imigrant> exploded;
	
	public Country(String name) {
		this.name = name;
		this.gradove = new ArrayList<>();
		this.exploded = new ArrayList<>();
	}
	
	public void addCity(City c){
		if(c!=null){
			this.gradove.add(c);
		}
	}
	
	public boolean removeCity(City c){
		if(this.gradove.contains(c)){
			this.gradove.remove(c);
			return true;
		}
		return false;
	}
	
	public void addExploded(Imigrant i){
		this.exploded.add(i);
	}
	
	public void showInfo(){
		System.out.println("Info for "+this.name);
		for (City grad : this.gradove) {
			grad.showInfo();
		}
		System.out.println("Exploded imigrants "+this.exploded);
	}

}
