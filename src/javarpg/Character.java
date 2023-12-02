package javarpg;

public abstract class Character {
		protected String name;
		protected int hp;
		protected int attackPower;
	    
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
	    }   
	    public void setAttackPower(int attackPower) {
	        this.attackPower = attackPower;
	    }    
}