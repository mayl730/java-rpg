package javarpg;

public class Goblin extends Monster{	
	public void attack (int damage, Player player) { 
		 // スーパーヒーロー＆飛んでいる場合は攻撃できない
		 if (this.canAttackPlayer(player)) {
	            player.receiveDamage(damage);
	            System.out.println(this.name + "は攻撃" + damage + "を与えた");
	        }
	}
}
