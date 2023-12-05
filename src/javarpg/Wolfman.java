package javarpg;

public class Wolfman extends Monster{
    public void attack (int damage, Player player) { 
      int wolfmanDamage = (int)Math.round(damage * 2);
      player.receiveDamage(wolfmanDamage);
      System.out.println(this.name + "は攻撃" + wolfmanDamage + "を与えた");
    }
}