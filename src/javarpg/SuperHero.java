package javarpg;

public class SuperHero extends Hero{
	boolean isFlying = false;
	int attackRatio = 2;
	
	@Override
	public void talk() {
		System.out.println(this.name + ": みんな、心配無用！スーパー勇者がいる限り、私たちは負けない！");
	}
	@Override
	public void attack (int damage, Monster monster) {
		int superDamage = (int) Math.round(damage * attackRatio);
        monster.receiveDamage(superDamage);
		System.out.println(this.name + "はスーパー攻撃" + superDamage + "を与えた");
	}
	
	public void fly() {
		if(this.isFlying) {
			System.out.println(this.name + "はすでに飛んでいる");
		} else {
			this.isFlying = true;
			this.attackRatio = 1;
			System.out.println(this.name + "は空を飛ぶ");
		}
	}
	
	public void land() {
		if(this.isFlying) {
			this.isFlying = false;
			this.attackRatio = 2;
			System.out.println(this.name + "は着陸した。");
		} else {
			System.out.println("空を⾶んだ状態ではないから、着陸できない");	
		}
	}
	
	
}
