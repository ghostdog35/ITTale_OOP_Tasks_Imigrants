package Country;

import java.util.Random;

import Imigranti.Extremal_Imigrant;
import Imigranti.Imigrant;
import Imigranti.Normal_Imigrant;

public class SpecForces extends PoliceOfficer{
	
	private static final int CHANCE_OF_CATCHING_ILLEGAL_IMMIGRANT = 90;
	
	public SpecForces(String name) {
		super(name);
	}

	@Override
	public int getChanceOfCatchingImigrant() {
		return this.CHANCE_OF_CATCHING_ILLEGAL_IMMIGRANT;
	}

	@Override
	public boolean checkImigrant(Imigrant i) {
		if(i instanceof Normal_Imigrant){
			System.out.println("Sorry I can't check your document's, try again with normal police officer.");
			this.city.addImigrant(i);
			return false;
		}	
		if((i.isHasPassport()) || (SpecForces.CHANCE_OF_CATCHING_ILLEGAL_IMMIGRANT < new Random().nextInt(100)+1)){
			System.out.println("Welcome to our beautiful city. Hope you'll like it!");
			return true;
		}
		else{
			System.out.println("You are illegal imigrant, you don't have passport and you're not allowed to enter this city!!!");
			return false;
		}
	}

	@Override
	public String toString() {
		return "SpecForces [name=" + name + "]";
	}
	
	
	

}
