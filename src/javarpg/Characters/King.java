package javarpg.Characters;

public class King extends Player{
	@Override
	public void talk() {
		System.out.println(this.name + ": 勇者よ、お前の力と勇気を信じている。魔王の野望を打ち砕き、お姫様を我がもとへと連れ戻してほしい。");
	}
}
