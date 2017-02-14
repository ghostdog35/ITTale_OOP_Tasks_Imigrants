package Weapons;

public class Weapon {
	
	public enum WeaponType{
		PISTOL, AUTOMAT, BOMB
		
	}
	
	
	private WeaponType type;
	private int price;
	
	public Weapon(WeaponType type, int price) {
		this.type = type;
		this.price = price;
	}

	public WeaponType getType() {
		return type;
	}

	public int getPrice() {
		return price;
	}
	
	public int useWeapon(){
		if(this.type== WeaponType.PISTOL ){
			System.out.println("Bam Bam Bam");
			return 12;
		}
		if(this.type== WeaponType.AUTOMAT ){
			System.out.println("RaTaTaTaTa");
			return 40;
		}
		else{
			System.out.println("BOOOOMMMMMMM!!!!!");
			return 0;
		}
		
	}

	@Override
	public String toString() {
		return "Weapon [type=" + type + ", price=" + price + "]";
	}
	
	
	
	

}
