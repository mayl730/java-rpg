package javarpg;

public class Goblin extends Monster{
	@Override
	public void attack (int damage) {
		System.out.println(this.name + "は攻撃" + damage + "を与えた");
	}
}