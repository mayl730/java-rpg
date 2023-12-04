package javarpg;

public class Wolfman extends Monster{
    public void attack (int damage, Player player) { 
      int WolfmanDamage = (int)Math.round(damage * 2);
      player.receiveDamage(WolfmanDamage);
      System.out.println(this.name + "は攻撃" + damage + "を与えた");
    }
}