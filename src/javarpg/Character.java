package javarpg;

public abstract class Character {
		protected String name;
		protected int hp;
		protected int attackPower;
		protected int initialHp;
	    
	    public String getName() {
	        return name;
	    }
	    public int getHp() {
	        return hp;
	    }
	    public int getAttackPower() {
	        return attackPower;
	    }
	    
	    public void setName(String name) {
	        this.name = name;
	    }
	    public void setHp(int hp) {
	        this.hp = hp;
	        this.initialHp = hp;
	    }   
	    public void setAttackPower(int attackPower) {
	        this.attackPower = attackPower;
	    }
	    
	    // キャラがダメージを受けるメソッド
	    public void receiveDamage(int damage) {
	        this.hp -= damage;
	        if (this.hp < 0) {
	            this.hp = 0;
	        }
	    }
	    
}