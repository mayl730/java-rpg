package javarpg;

public class Slime extends Monster{
	 public void attack (int damage, Player player) {
	        int slimeDamage = (int) Math.round(damage * 0.5);
	        player.receiveDamage(slimeDamage);
	        System.out.println(this.name + "は攻撃" + slimeDamage + "を与えた");
	    }
}
