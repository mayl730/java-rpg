package javarpg;

public abstract class Monster extends Character{
	protected int attackPower = 100;
	
    public abstract void attack(int damage, Player player);

	public void run() {
		System.out.println(this.name + "は逃げた");
	}
}
