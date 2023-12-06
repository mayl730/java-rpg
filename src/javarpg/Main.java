package javarpg;

import java.util.Random;
import java.util.Scanner;

import javarpg.Characters.DemonKing;
import javarpg.Characters.Goblin;
import javarpg.Characters.Hero;
import javarpg.Characters.King;
import javarpg.Characters.Monster;
import javarpg.Characters.Player;
import javarpg.Characters.Princess;
import javarpg.Characters.Slime;
import javarpg.Characters.SuperHero;
import javarpg.Characters.Wizard;
import javarpg.Characters.Wolfman;

public class Main {
    static final int heroMaxHp = 400;
    static final int superHeroMaxHp = 800; 
    static final int heroAttackPower = 100;
    static final String[] enemies = {"スライム","ゴブリン","狼男","魔王"};
    static int[] killedTimes = {0,0,0,0}; // 各敵が倒された回数を数える
    static int enemyNum = 0;
    
    public static void main(String[] args){
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        
        // Player の設定
        Hero hero = new Hero();
        hero.setAttackPower(heroAttackPower);
        
        SuperHero superHero = new SuperHero();
        superHero.setHp(superHeroMaxHp);
        Wizard wizard = new Wizard();
        wizard.setName("魔法使い");
        wizard.setHp(1000);
        
        // NPC の設定
        King king = new King();
        king.setName("王様");
        Princess princess = new Princess();
        princess.setName("ピーチ姫");
        
        // Monster の設定
        Monster monster;
        DemonKing demonKing = new DemonKing();
        demonKing.setHp(500);
        demonKing.setName("魔王");

        // ループ制御用の変数
        boolean ventureloop = true;
        boolean superHeroVentureLoop = false;
        boolean battleloop = false;
        boolean withWizard = false;
        int actionNum = 0;
        
        /******** ゲーム開始 ********/
        System.out.println("勇者の名前を付けて下さい: ");
        String hname = scanner.nextLine();
        hero.setName(hname);
        hero.setHp(heroMaxHp);
       
        String heroName = hero.getName();
        superHero.setName(heroName);
        
        System.out.println("勇者（" + heroName + ")が誕生した。");
        System.out.println("勇者（" + heroName + ")が王様に会いに行って、王様と出会った。");
        king.talk();
        hero.talk();
        System.out.println("「魔王を倒して、お姫様を助け出す」使命を受けった。");
        System.out.println("勇者（" + heroName + "）は冒険に出かけた。");

        
        while(ventureloop){
        	System.out.println("倒したモンスター数: スライム=" + killedTimes[0] + " ゴブリン=" + killedTimes[1] + " 狼男=" + killedTimes[2]);
            System.out.println("------------------------------------------------------------");
            
            enemyNum = random.nextInt(3); // 0ならスライム、1ならゴブリン、2なら狼男にランダムで遭遇
            
            System.out.println(enemies[enemyNum] + "に出会った、バトルが始まる");
           
            monster = createMonster(enemyNum);
            battleloop = true;
           
            while(battleloop){
            	System.out.println("**** 勇者のHP:" +hero.getHp() +" | "+ monster.getName() + "のHP:" + monster.getHp() + " ****");
                System.out.println("勇者(" + heroName + ")に指示を出してください「1.戦う 2.眠る 3.逃げる」:");
                actionNum = scanner.nextInt();
                
                battleloop = playerAction(actionNum, hero, monster);
                
                if(!battleloop){break;}
           
                if(withWizard==true){
                    battleloop = wizardAction(wizard, monster);
                    if(!battleloop){break;}
                }
                battleloop = monsterAction(hero, monster, 5);
                if(!battleloop){break;}
            }

            //　魔法使いと出会い
            if(withWizard == false && random.nextInt(3)==0){
                System.out.println("------------------------------------------------------------");
                System.out.println("スペシャル・イベント！");
                System.out.println("魔法使いと出会った、冒険の仲間になるように誘う。");
                if(random.nextInt(2)==0){
                    withWizard = true;
                    System.out.println("魔法使いは仲間になった。");
                }else{
                    System.out.println("魔法使いは仲間になってくれなかった。"); 
                }
            }
            
            //すべて種類のモンスターを倒れるか、魔法使いを仲間になれるかを判断する
            if(killedTimes[0] > 0 && killedTimes[1] > 0 && killedTimes[2] > 0 && withWizard == true){
                ventureloop = false;
            }   
        }

        System.out.println("勇者(" + heroName + ")はスーパー勇者に成長した！");
        System.out.println("スーパー勇者（" + heroName + "）は冒険に出かけた。");
        
        superHeroVentureLoop = true;
       
        // スーパーヒーローの冒険
        while(superHeroVentureLoop){ 
        	if (enemyNum == 3 && demonKing.getHp() <= 0) {
        		superHeroVentureLoop = false;
        		break;
        	}
        	System.out.println("------------------------------------------------------------");
        	
        	  // 0ならスライム、1ならゴブリン、2なら狼男、3なら魔王にランダムで遭遇
        	  enemyNum = random.nextInt(4);
              System.out.println(enemies[enemyNum] + "に出会った、バトルが始まる");
              if (enemyNum == 3) {
            	  	System.out.println("姫様に出会った。");
                    princess.talk();
                    demonKing.talk();
                    superHero.talk();
                    System.out.println("バトルが始まる！");
               }
              if(enemyNum < 3){
                  monster = createMonster(enemyNum);
              } else {
              	  monster = demonKing;
              }
               battleloop = true;
               while(battleloop){
            	    System.out.println("**** 勇者のHP:" + superHero.getHp() +" | "+ monster.getName() + "のHP:" + monster.getHp() + " ****");
                    System.out.println("スーパー勇者(" + heroName + ")に指示を出してください「1.戦う 2.眠る 3.逃げる 4.空を⾶ぶ 5.着陸する」:");
                    actionNum = scanner.nextInt();
                    battleloop = superAction(actionNum, superHero, monster);
                    if(!battleloop){break;}
                    battleloop = wizardAction(wizard, monster);
                    if(!battleloop){break;}
                    battleloop = monsterAction(superHero, monster, 10);
                    if(!battleloop){break;}
                    
                }
        }
        System.out.println("あなたの勝ちた！冒険終了！");
        scanner.close();
    }
    
    /******** Main method End ********/
    
    // Utils
    public static boolean playerAction(int actionNum, Hero hero, Monster monster){
        Random random = new Random();
        String monsterName = monster.getName();
        
        switch(actionNum){
            case 1:
            	int damage = random.nextInt(heroAttackPower);
                hero.attack(damage, monster);
                if(monster.getHp() == 0){
                    System.out.println(monsterName + "を倒した、戦闘終了。");
                    killedTimes[enemyNum]++;
                    return false;
                }else{
                    return true;
                }
            case 2:
                hero.sleep();
                return true;
            case 3:
                hero.run();
                return false;
            default:
                System.out.println("勇者(" + hero.getName() + "何もしなかった。");
                return true;
        }
    }
    public static boolean superAction(int actionNum, SuperHero superHero, Monster monster){
        Random random = new Random();
        String monsterName = monster.getName();
        
        switch(actionNum){
            case 1:
                int damage = random.nextInt(heroAttackPower);
                superHero.attack(damage, monster);
                if(monster.getHp() == 0){
                    System.out.println(monsterName + "を倒した、戦闘終了。");
                    killedTimes[enemyNum]++;
                    return false;
                }else{
                    return true;
                }
            case 2:
                superHero.sleep();
                return true;
            case 3:
                superHero.run();
                return false;
            case 4:
                superHero.fly();
                return true;
            case 5:
                superHero.land();
                return true;
            default:
                System.out.println("スーパー勇者(" + superHero.getName() + "何もしなかった。");
                return true;
        }
    }

    public static boolean wizardAction(Wizard wizard, Monster monster){
        Random random = new Random();
        String monsterName = monster.getName();
        
        int damage = random.nextInt(heroAttackPower);
        wizard.attack(damage, monster);
        if(monster.getHp() == 0){
            System.out.println(monsterName + "を倒した、戦闘終了。");
            killedTimes[enemyNum]++;
            return false;
        }
        return true;
    }
    
    public static boolean monsterAction(Player player, Monster monster, int escapeRate){
        Random random = new Random();
        int damage = random.nextInt(heroAttackPower);
        
        int actionAuto = random.nextInt(escapeRate); // 逃げる確率を制御する、数値が小さいほど逃げるチャンスが高くなる

        if(actionAuto == 0){    
            monster.run();   
            return false;
        }
        if(monster.canAttackPlayer(player)){
            monster.attack(damage,player);
            if(player.getHp() == 0){
                System.out.println(player.getName() + "は倒られた、戦闘終了。");
                System.out.println("ゲームオーバー！");
                System.exit(0);
                return false;
            }
        } 
        return true;
    }
    
    public static Monster createMonster(int enemyNum) {
        Monster monster;
        switch (enemyNum) {
            case 0:
                monster = new Slime();
                monster.setHp(50);
                break;
            case 1:
                monster = new Goblin();
                monster.setHp(100);
                break;
            case 2:
                monster = new Wolfman();
                monster.setHp(150);	
                break;
            default:
                throw new IllegalArgumentException("0-3を入力してください！");
        }
        monster.setName(enemies[enemyNum]);
        return monster;
    }
}
