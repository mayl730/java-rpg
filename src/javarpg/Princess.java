package javarpg;

public class Princess extends Player{
	@Override
	public void talk() {
		System.out.println(this.name + ": 勇者さん、助けてください！");
	}
	public void cheer(SuperHero superHero) {
		int heroAttackPower = superHero.getAttackPower();
		superHero.setAttackPower(heroAttackPower * 2);
		System.out.println(this.name + ": 勇者さん、頑張ってください！");
	}
}
