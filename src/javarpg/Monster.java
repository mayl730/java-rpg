package javarpg;

public abstract class Monster extends Character{
	protected int attackPower = 100;
	protected boolean canAttackPlayer(Player player) {
        if (player instanceof SuperHero) {
            SuperHero superHero = (SuperHero) player;
            if (superHero.isFlying) {
            	System.out.println(superHero.getName() + "は空中にいるため、" + this.name + "の攻撃は効かない！");
                return false;
            }
        }
        return true;
	}
	
    public abstract void attack(int damage, Player player);

	public void run() {
		System.out.println(this.name + "は逃げた");
	}
	
	
}
