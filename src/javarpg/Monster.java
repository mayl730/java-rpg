package javarpg;

public abstract class Monster extends Character{
	protected int maxDamage = 100;
	
    public abstract void attack(int damage);

    public boolean run() {
        System.out.println(this.name + "は逃げた.");
        return true;
    }
}
