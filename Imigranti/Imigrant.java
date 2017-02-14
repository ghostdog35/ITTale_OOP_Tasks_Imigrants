package Imigranti;

import java.util.ArrayList;

import Country.City;
import Country.Country;
import Weapons.Weapon;

public abstract class Imigrant {
	
	private class Pasport{
		
		private String name;
		private int age;
		private String rodnaDyrjava;
		private String rodenGrad;
		
		public Pasport(String name, int age, String rodnaDyrjava, String rodenGrad) {
			this.name = name;
			this.age = age;
			this.rodnaDyrjava = rodnaDyrjava;
			this.rodenGrad = rodenGrad;
		}

		@Override
		public String toString() {
			return "Pasport [name=" + name + ", age=" + age + ", rodnaDyrjava=" + rodnaDyrjava + "]";
		}	
		
		
		
	}
	
	private Pasport pasport;
	protected int money;
	protected City city;
	protected Country country;
	protected ArrayList<Imigrant> rodnini;
	private boolean hasPassport;
	
	public Imigrant(int money){
		this.money = money;
		this.rodnini = new ArrayList<>();
		this.hasPassport=false;
	}
	
	public boolean isHasPassport() {
		return hasPassport;
	}

	public Imigrant(String name, int age, String rodnaDyrjava, String rodenGrad, int money) {
		this.pasport = new Pasport(name, age, rodnaDyrjava, rodenGrad);
		this.hasPassport=true;
		this.money = money;
		this.rodnini = new ArrayList<>();
	}
	
	
	
	
	public void addRodnina(Imigrant r){
		if(r!=null){
			this.rodnini.add(r);
		}
	}
	
	public void imigrate(City grad){
		if (grad.addImigrant(this)){
			this.country=grad.getCountry();
			this.city=grad;
			for (Imigrant imigrant : rodnini) {
				if(imigrant.city==null){
					imigrant.imigrate(grad);
				}
			}
		}
	}

	@Override
	public String toString() {
		return " pasport=" + pasport + ", money=" + money + ", city=" + city + ", rodnini=" + rodnini.size() ;
	}
	
	
	
	
	
	

}
