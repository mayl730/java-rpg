package javarpg;

public class DemonKing extends Monster implements TalkInterface{
    public void talk() {
        System.out.println(this.name + ": よくここまで来たな！だが、ここで終わりだ");
    }
    public void attack (int damage, Player player) { 
        int DemonKingDamage = (int)Math.round(damage*5);
        player.receiveDamage(damage);
        System.out.println(this.name + "貴様ら！全員ぶっ殺してやる！" + DemonKingDamage + "を与えた" );
 }
}
