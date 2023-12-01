package javarpg;

public abstract class Character {
		protected String name;
		protected int hp;
	    
	    public String getName() {
	        return name;
	    }
	    public int getHp() {
	        return hp;
	    }
	    
	    public void setName(String name) {
	        this.name = name;
	    }
	    public void setHp(int hp) {
	        this.hp = hp;
	    }    
}