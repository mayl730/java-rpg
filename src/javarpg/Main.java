package lastwork;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static final int HeroMaxHp = 100;
    static final int SuperHeroMaxHp = 200;
    static final String[] Enemies = {"スライム","ゴブリン","狼男"};
    static int[] encounterTimes = {0,0,0}; //count the times that each enemy appeared
    static int enemyNum = 0;
    public static void main(String[] args){
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        
        Hero hero = new Hero();
        SuperHero superHero = new SuperHero();
        Wizard wizard = new Wizard();
        Monster monster;
        Slime slime = new Slime();
        Goblin goblin = new Goblin();
        Wolfman wolfMan = new Wolfman();
        DemonKing demonKing = new DemonKing();
        King king = new King();
        Princess princess = new Princess();
        
        System.out.println("勇者の名前を付けて下さい: ");
        String hname = scanner.nextLine();
        hero.setName(hname);
        System.out.println("勇者（" + hero.getName() + ")が誕生した。");
        System.out.println("勇者（" + hero.getName() + ")が王様に会いに行って、王様と出会った。");
        king.talk();
        System.out.println("「魔王を倒して、お姫様を助け出す」使命を受けった。");
        System.out.println("勇者（" + hero.name + "）は冒険に出かけた。");
        boolean ventureloop = true;
        boolean battleloop = false;
        boolean withWizard = false;
        int enemyAction = 0;
        int actionNum = 0;
        int enemyActionNum = 0;
        while(ventureloop){
            enemyNum = random.nextInt(3);
            System.out.println(Enemies[enemyNum] + "に出会った、バトルが始まる");
            if(enemyNum == 0){
                monster = new Slime();
                encounterTimes[0]++;
            }else if(enemyNum == 1){
                monster = new Goblin();
                encounterTimes[1]++;
            }else{
                monster = new Wolfman();
                encounterTimes[2]++;
            }

            battleloop = true;
            while(battleloop){
                System.out.println("勇者(" + hero.getName() + ")に指示を出してください「1.戦う 2.眠る 3.逃げる」:");
                actionNum = scanner.nextInt();
                battleloop = playerAction(actionNum, Enemies[enemyNum], hero, monster);
                if(!battleloop){break;}
                if(withWizard==true){

                }
            } 

            if(random.nextInt(3)==0){
                System.out.println("スペシャル・イベント！");
                if(withWizard==false){
                    System.out.println("魔法使いと出会った、冒険の仲間になるように誘う。");
                    if(random.nextInt(2)==0){
                        withWizard = true;
                        System.out.println("魔法使いは仲間になった。");
                    }else{
                        System.out.println("魔法使いは仲間になってくれなかった。");
                    }
                }
            }

            if(encounterTimes[0]!=0 && encounterTimes[1]!=0 && encounterTimes[2]!=0 && withWizard==true){
                ventureloop = false;
            }
        }
        scanner.close();
    }

    public static boolean playerAction(int actionNum, String enemy, Hero hero, Monster monster){
        Random random = new Random();
        switch(actionNum){
            case 1:
                int damage = random.nextInt(hero.getAttackPower());
                hero.attack(damage);
                monster.receiveDamage(damage);
                System.out.println(enemy + "は" + damage + "点ダメージを受けった、残るHPは" + monster.getHp());
                if(monster.getHp() == 0){
                    System.out.println(enemy + "を倒した、戦闘終了。");
                    return false;
                }else{
                    return true;
                }
            case 2:
                hero.sleep();
                hero.setHp(HeroMaxHp);
                return true;
            case 3:
                hero.run();
                encounterTimes[enemyNum]--;
                return false;
            default:
                System.out.println("勇者(" + hero.getName() + "何もしなかった。");
                return true;
        }
    }
}
