package javarpg;

public class Wizard extends Player{
	
	@Override
	public void talk() {
		System.out.println(this.name + ": まだ見ぬ魔法の力を求めて、私の旅は続く.");
	}
	
	public void attack (int damage, Monster monster) {
		int magicalDamage = (int) Math.round(damage * 1.5);
        monster.receiveDamage(magicalDamage);
		System.out.println(this.name + "は魔法攻撃" + magicalDamage + "を与えた");
	}
}