package javarpg.Characters;

public class Hero extends Player{
	
	@Override
	public void talk() {
		System.out.println(this.name + ": 悪い奴らには絶対に負けない！");
	}
	public void attack (int damage, Monster monster) {
        monster.receiveDamage(damage);
		System.out.println(this.name + "は攻撃" + damage + "を与えた");
	}
	public void sleep() {
		this.hp = this.initialHp;
		System.out.println(this.name + "は眠ってHPが完全に回復した" + this.hp);
	}
	public void run() {
		System.out.println(this.name + "は逃げた");
	}
}
