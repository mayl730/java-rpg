package javarpg;

public class MainTestMei {
	 public static void main(String[] args) {
		 	
		 // Set Goblin
	        Goblin goblin = new Goblin();
	        goblin.setName("GoblinA");
	        goblin.setHp(100);
	        goblin.setAttackPower(100);
	        
	     // Set Hero
	        Hero hero = new Hero();
	        hero.setName("Hero");
	        hero.setHp(1000);
	        hero.setAttackPower(100);
	     // Set SuperHero
	        SuperHero superHero = new SuperHero();
	        superHero.setName("SuperHero");
	        superHero.setHp(1000);
	        superHero.setAttackPower(100);
	        
	     // Try attack
	        hero.attack(20, goblin);
	        goblin.attack(20, hero);      
	        
	        System.out.println(hero.getHp() +"  "+ goblin.getHp());
	        
	        superHero.attack(9, goblin);
	        goblin.attack(20, superHero);      
	        
	        System.out.println(hero.getHp() +"  "+ goblin.getHp());

	    }
}
