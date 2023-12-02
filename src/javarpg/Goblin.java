package lastwork;

public class Goblin extends Monster{
	this.hp = 1000;
	}
public void run() {
	System.out.println("ゴブリン" + this.name + "は逃げた.");
}
public void attack (int damage) {
	System.out.println("ゴブリン" + this.name + "は攻撃" + damage + "を与えた");
}
}
