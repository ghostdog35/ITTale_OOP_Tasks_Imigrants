package Demo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import Country.City;
import Country.Country;
import Country.NormalPoliceOfficer;
import Country.PoliceOfficer;
import Country.SpecForces;
import Imigranti.Extremal_Imigrant;
import Imigranti.ICanShoot;
import Imigranti.Imigrant;
import Imigranti.Normal_Imigrant;
import Imigranti.Radikal_Imigrant;
import Weapons.Weapon;
import Weapons.Weapon.WeaponType;

public class Demo {

	public static void main(String[] args) {
		Random r = new Random();
		Country bulgaria = new Country("Bulgaria");
		String[] cities = {"Sofia", "Plovdiv", "Varna", "Ruse", "Bourgas"};
		for (int i = 0; i < 5; i++) {
			bulgaria.addCity(new City(bulgaria, cities[i], r.nextInt(2000)+1000));
		}
		
		LinkedList<PoliceOfficer> policeOficers = new LinkedList<>();
		
		String[] names = {"Ivan Ivanov", "Ivan Petrov","Petar Ivanov","Georgi Ivanov","Ivan Georgiev","Petar Petrov","Stoqn Georgiev","Georgi Stoqnov","Georgi Petrov"};
		
		for (int i = 0; i < 20; i++) {
			switch (r.nextInt(2)) {
			case 0:
				policeOficers.add(new SpecForces(names[r.nextInt(names.length)]));
				break;
			case 1:
				policeOficers.add(new NormalPoliceOfficer(names[r.nextInt(names.length)]));
				break;
			default:
				break;
			}
		}
		System.out.println(policeOficers);
		
		for (int i = 0; i < bulgaria.gradove.size(); i++) {
			for (int j = 0; j < 4; j++) {
				bulgaria.gradove.get(i).addPoliceOfficer(policeOficers.get(0));
				policeOficers.remove(0);
			}
		}
		bulgaria.showInfo();
		String[] imigrantNames = {"Hasan", "Abdulah","Mohamed","Halid","Omar","Katar","Izmir","Haled","Suleiman"};
		String[] dyrjavi = {"Siriq", "Afganistan","Iran", "Pakistan"};
		ArrayList<Imigrant> imigranti = new ArrayList<>();
		
		for (int i = 0; i < 100; i++) {
			int temp = r.nextInt(100);
			if(temp < 40){
				imigranti.add(new Normal_Imigrant(imigrantNames[r.nextInt(imigrantNames.length)], (r.nextInt(20)+20),dyrjavi[r.nextInt(4)] , " ", r.nextInt(2000)+2000));
				continue;
			}
			if(temp < 65){
				if(r.nextInt(100)<35){
					imigranti.add(new Radikal_Imigrant(imigrantNames[r.nextInt(imigrantNames.length)], (r.nextInt(20)+20),dyrjavi[r.nextInt(4)] , " ", r.nextInt(2000)+2000));
					continue;
				}
				else{
					imigranti.add(new Radikal_Imigrant(r.nextInt(2000)+2000));
					continue;
				}
			}
			else{
				imigranti.add(new Extremal_Imigrant(r.nextInt(2000)+2000));
			}
		}
		for (int i = 0; i < imigranti.size(); i++) {
			imigranti.get(i).addRodnina(imigranti.get(r.nextInt(imigranti.size())));
			imigranti.get(i).addRodnina(imigranti.get(r.nextInt(imigranti.size())));
		}
		System.out.println(imigranti);
		ArrayList<Weapon> oryjiq = new ArrayList<>();
		for (int i = 0; i < 200; i++) {
			oryjiq.add(new Weapon(WeaponType.values()[r.nextInt(WeaponType.values().length)], r.nextInt(400)+300));
		}
		System.out.println(oryjiq);
		System.out.println(imigranti.size());
		while(oryjiq.size()>0){
			for (int i=0; i< imigranti.size(); i++) {
				if(imigranti.get(i) instanceof Radikal_Imigrant){
					for(int j=0; j<5; j++){
						if(oryjiq.size()>0){
							int temp = r.nextInt(oryjiq.size());
							if(((Radikal_Imigrant) imigranti.get(i)).byeWeapon(oryjiq.get(temp))){
								oryjiq.remove(temp);
							}
							else{
								imigranti.remove(i) ;
								break;
							}
						}	
					}
				}
				if(imigranti.get(i) instanceof Extremal_Imigrant){
					for(int j=0; j<5; j++){
						if(oryjiq.size()>0){
							int temp = r.nextInt(oryjiq.size());
							if(((Extremal_Imigrant) imigranti.get(i)).byeWeapon(oryjiq.get(temp))){
								oryjiq.remove(temp);
							}
							else{
								imigranti.remove(i);
								break;
							}
						}
					}
				}
			}
		}
		//System.out.println(imigranti);
		//System.out.println(imigranti.size());
		for (Imigrant im : imigranti) {
			im.imigrate(bulgaria.gradove.get(r.nextInt(bulgaria.gradove.size())));
		}
		//bulgaria.showInfo();
		
		for(int i=0; i<20; i++){
			if(bulgaria.gradove.size()>0){
				int temp = r.nextInt(bulgaria.gradove.size());
				Imigrant im = bulgaria.gradove.get(temp).imigranti.get(r.nextInt(bulgaria.gradove.get(temp).imigranti.size()));
				if (im instanceof ICanShoot){
					 ((ICanShoot) im).startShootingCitizens();
				}
			}
		}
		bulgaria.showInfo();

	}

}
