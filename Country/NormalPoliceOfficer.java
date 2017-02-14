package Country;

import java.util.Random;

import Imigranti.Extremal_Imigrant;
import Imigranti.Imigrant;

public class NormalPoliceOfficer extends PoliceOfficer {
	
	private static final int CHANCE_OF_CATCHING_ILLEGAL_IMMIGRANT = 50;
	
	
	public NormalPoliceOfficer(String name) {
		super(name);
		
	}


	@Override
	public int getChanceOfCatchingImigrant() {
		return this.CHANCE_OF_CATCHING_ILLEGAL_IMMIGRANT;
	}
	
	public boolean checkImigrant(Imigrant i){
		if((i.isHasPassport()) || (NormalPoliceOfficer.CHANCE_OF_CATCHING_ILLEGAL_IMMIGRANT < new Random().nextInt(100)+1) ||
				(i instanceof Extremal_Imigrant && ((Extremal_Imigrant) i).isHasBomb())){
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
		return "NormalPoliceOfficer [name=" + name + "]";
	}

	

}
