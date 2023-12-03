package javarpg;

public class Goblin extends Monster{
	public void attack (int damage, Player player) {
		player.receiveDamage(damage);
		System.out.println(this.name + "は攻撃" + damage + "を与えた");
	}
}
