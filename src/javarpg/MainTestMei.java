package javarpg;

public class MainTestMei {
	 public static void main(String[] args) {
	        Goblin goblin = new Goblin();
	        goblin.setName("GoblinA");
	        goblin.setHp(1000);
	        goblin.setAttackPower(100);

	        goblin.attack(100);
	        
	        int attackPower = goblin.getAttackPower();
	        goblin.receiveDamage(10);
	        int newHp = goblin.getHp();
	        System.out.println("HP" + newHp);
	        

	        System.out.println("Did the goblin run away? " + attackPower);
	    }
}
