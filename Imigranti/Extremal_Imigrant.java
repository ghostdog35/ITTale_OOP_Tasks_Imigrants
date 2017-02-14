package Imigranti;

import java.util.ArrayList;
import java.util.Random;

import Weapons.Weapon;
import Weapons.Weapon.WeaponType;

public class Extremal_Imigrant extends Imigrant implements ICanShoot {
	
	ArrayList<Weapon> weapons;
	private boolean hasBomb;
	
	public Extremal_Imigrant( int money) {
		super(money);
		this.weapons = new ArrayList<>();
	}

	
	
	public boolean byeWeapon(Weapon a){
		if(this.money>a.getPrice()){
			if(a.getType()== WeaponType.BOMB ){
				this.hasBomb=true;
			}
			this.money-=a.getPrice();
			this.weapons.add(a);
			//System.out.println("Kupih si oryjie "+a);
			return true;
		}
		else{
			System.out.println("Lele nqmam pari da si kupq tova oryjie, idva mi da umra ot qd!!!");
			if(this.city!=null){
				this.city.removeImigrant(this);
			}
			return false;
		}
		
	}

	public boolean isHasBomb() {
		return hasBomb;
	}
	public  void startShootingCitizens(){
		for (Weapon weap : this.weapons) {
			if(weap.getType()== WeaponType.BOMB ){
				weap.useWeapon();
				if(this.city!=null && this.country!=null){
					this.country.removeCity(this.city);
					this.country.addExploded(this);
					return;
				}
			}
			if(this.city!=null){
				this.city.getPeopleShot(weap.useWeapon()*(new Random().nextInt(60)+10)/100);
			}
			else{
				return;
			}
		}
	}



	@Override
	public String toString() {
		return "Extremal_Imigrant [weapons=" + weapons + ", hasBomb=" + hasBomb + super.toString()+ "]";
	}
	

}
