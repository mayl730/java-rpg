package javarpg;

public abstract class Monster extends Character{
	protected int attackPower = 100;
	
	// スーパーヒーロー＆飛んでいる場合は攻撃できない
	protected boolean canAttackPlayer(Player player) {
		// スーパーヒーローを判断する
        if (player instanceof SuperHero) {
            SuperHero superHero = (SuperHero) player;
        // スーパーヒーローが空中にいるを判断する
            if (superHero.getIsFlying()) {
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
