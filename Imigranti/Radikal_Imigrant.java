package Imigranti;

import java.util.ArrayList;
import java.util.Random;

import Country.City;
import Country.Country;
import Weapons.Weapon;
import Weapons.Weapon.WeaponType;

public class Radikal_Imigrant extends Imigrant implements ICanShoot{
	
	private static final int MAX_COUNT_OF_WEAPONS =5;
	ArrayList<Weapon> weapons;
	
	public Radikal_Imigrant( int money) {
		super(money);
		this.weapons = new ArrayList<>();
	}

	public Radikal_Imigrant(String name, int age, String rodnaDyrjava, String rodenGrad, int money) {
		super(name, age, rodnaDyrjava, rodenGrad, money);
		this.weapons = new ArrayList<>();
	}
	
	
	public boolean byeWeapon(Weapon a){
		if(a.getType()!= WeaponType.BOMB ){
			if(this.money>a.getPrice()&& this.weapons.size()<MAX_COUNT_OF_WEAPONS){
				this.money-=a.getPrice();
				this.weapons.add(a);
				//System.out.println("Kupih si oryjie "+a);
				return true;
			}
			if(this.money<a.getPrice()){
				System.out.println("Lele nqmam pari da si kupq tova oryjie, idva mi da umra ot qd!!!");
				if(this.city!=null){
					this.city.removeImigrant(this);
				}
				return false;
			}
		}
		return true;
		
	}
	public  void startShootingCitizens(){
		for (Weapon weap : this.weapons) {
			if(this.city!=null){
				this.city.getPeopleShot(weap.useWeapon()*(new Random().nextInt(60)+10)/100);
			}
		}
	}

	@Override
	public String toString() {
		return "Radikal_Imigrant [weapons=" + weapons + super.toString() + "]";
	}

	
	

}
