package javarpg;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static final int heroMaxHp = 400;
    static final int superHeroMaxHp = 800; 
    static final int heroAttackPower = 100;
    static final double FlyHeroAttackReduceRatio = 0.6;
    static final String[] Enemies = {"スライム","ゴブリン","狼男","魔王"};
    static int[] encounterTimes = {0,0,0}; //count the times that each enemy appeared
    static int[] killedTimes = {0,0,0}; //count the times that each enemy appeared
    static int enemyNum = 0;
    
    public static void main(String[] args){
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        
        Hero hero = new Hero();
        SuperHero superHero = new SuperHero();
        Wizard wizard = new Wizard();
        Monster monster;
        DemonKing demonKing = new DemonKing();
        King king = new King();
        Princess princess = new Princess();

        boolean ventureloop = true;
        boolean battleloop = false;
        boolean withWizard = false;
        int actionNum = 0;
        
        //Game Start -------------------------------------------
        System.out.println("勇者の名前を付けて下さい: ");
        String hname = scanner.nextLine();
        hero.setName(hname);
        hero.setHp(heroMaxHp);
//        hero.setAttackPower(HeroAttackPower);
        System.out.println("勇者（" + hero.getName() + ")が誕生した。");
        System.out.println("勇者（" + hero.getName() + ")が王様に会いに行って、王様と出会った。");
        king.talk();
        hero.talk();
        System.out.println("「魔王を倒して、お姫様を助け出す」使命を受けった。");
        System.out.println("勇者（" + hero.getName() + "）は冒険に出かけた。");

        while(ventureloop){
        	System.out.println("Debug: Monster Killed time: スライム=" + killedTimes[0] + " ゴブリン="+killedTimes[1]+" 狼男="+killedTimes[2]);
    
            enemyNum = random.nextInt(3); //random with number 0 to meet slime, 1 to goblin, 2 to wolfman
            
            System.out.println(Enemies[enemyNum] + "に出会った、バトルが始まる");
           
            if(enemyNum == 0){  //すべて種類のmonsterに出会ったかどうかを判断するため
                monster = new Slime();
                monster.setHp(50);
                monster.setName(Enemies[enemyNum]);
                encounterTimes[0]++;
            }else if(enemyNum == 1){
                monster = new Goblin();
                monster.setHp(100);
                monster.setName(Enemies[enemyNum]);
                encounterTimes[1]++;
            }else{
                monster = new Wolfman();
                monster.setHp(200);
                monster.setName(Enemies[enemyNum]);
                encounterTimes[2]++;
            }

            battleloop = true;
            
            while(battleloop){
            	System.out.println("Debug: Your HP:" +hero.getHp() + " Monster HP:" + monster.getHp());
            	
                System.out.println("勇者(" + hero.getName() + ")に指示を出してください「1.戦う 2.眠る 3.逃げる」:");
                actionNum = scanner.nextInt();
                battleloop = playerAction(actionNum, Enemies[enemyNum], hero, monster);
                
                int monsterHp = monster.getHp();
            	if (monsterHp == 0) {
            		killedTimes[enemyNum]++;
            	}
//            	System.out.println("Debug: Your HP:" +hero.getHp() + "Monster HP:" + monster.getHp());
                if(!battleloop){break;}
           
                if(withWizard==true){
                    battleloop = wizardAction(Enemies[enemyNum], wizard, monster);
                    if(!battleloop){break;}
                }
                battleloop = monsterAction(Enemies[enemyNum], hero, monster);
//                System.out.println("battleLoop!!!!!" + battleloop);
                if(!battleloop){break;}
            }

            //meet with wizard
            if(withWizard==false && random.nextInt(3)==0){
                System.out.println("スペシャル・イベント！");
                System.out.println("魔法使いと出会った、冒険の仲間になるように誘う。");
                if(random.nextInt(2)==0){
                    withWizard = true;
                    System.out.println("魔法使いは仲間になった。");
//                    wizard.setAttackPower(HeroAttackPower);
                }else{
                    System.out.println("魔法使いは仲間になってくれなかった。"); 
                }
            }

            if(killedTimes[0]!=0 && killedTimes[1]!=0 && killedTimes[2]!=0 && withWizard==true){
                ventureloop = false;
            }   //すべて種類のモンスターを倒れるか、魔法使いを仲間になれるかを判断する
        }

        System.out.println("勇者(" + hero.getName() + ")はスーパー勇者に成長した！");
        superHero.setName(hero.getName());
        superHero.setHp(superHeroMaxHp);
//        superHero.setAttackPower(HeroAttackPower*2);
        System.out.println("スーパー勇者（" + superHero.getName() + "）は冒険に出かけた。");
        ventureloop = true;
        
        //superHero's venture
        while(ventureloop){ 
            enemyNum = random.nextInt(4); //random with number 0 to meet slime, 1 to goblin, 2 to wolfman, 3 to demonKing
            if(enemyNum < 3){
                System.out.println(Enemies[enemyNum] + "に出会った、バトルが始まる");
                battleloop = true;
                while(battleloop){
                    System.out.println("スーパー勇者(" + superHero.getName() + ")に指示を出してください「1.戦う 2.眠る 3.逃げる 4.空を⾶ぶ 5.着陸する」:");
                    actionNum = scanner.nextInt();
                    if(enemyNum == 0){
                        monster = new Slime();
                    }else if(enemyNum == 1){
                        monster = new Goblin();
                    }else{
                        monster = new Wolfman();
                    }
                    battleloop = superAction(actionNum, Enemies[enemyNum], superHero, monster);
                    if(!battleloop){break;}
                    battleloop = wizardAction(Enemies[enemyNum], wizard, monster);
                    if(!battleloop){break;}
                    battleloop = monsterAction(Enemies[enemyNum], superHero, monster);
                    if(!battleloop){break;}
                }
            }else{
                ventureloop = false;
            }
        }

        //final battle: Encounter with princess, Battle with the Demon King
        System.out.println("姫様に出会った。");
        princess.talk();
        System.out.println("魔王が現れた。");
        demonKing.talk();
//        demonKing.setAttackPower(HeroAttackPower*5);
        
        superHero.talk();
        System.out.println("バトルが始まる！");
        battleloop = true;
        while(battleloop){
            System.out.println("スーパー勇者(" + superHero.getName() + ")に指示を出してください「1.戦う 2.眠る 3.逃げる 4.空を⾶ぶ 5.着陸する」:");
            actionNum = scanner.nextInt();
            if(enemyNum == 0){
                monster = new Slime();
            }else if(enemyNum == 1){
                monster = new Goblin();
            }else{
                monster = new Wolfman();
            }
            princess.cheer(superHero);
            battleloop = superAction(actionNum, Enemies[enemyNum], superHero, monster);
            if(!battleloop){break;}
            battleloop = wizardAction(Enemies[enemyNum], wizard, monster);
            if(!battleloop){break;}
            battleloop = demonKingAction(superHero, demonKing);
            if(!battleloop){break;}
        }
        scanner.close();
    }
    //---------------------------------- Main method End -----------------------------------------------

    //method
    public static boolean playerAction(int actionNum, String enemy, Hero hero, Monster monster){
        Random random = new Random();
        switch(actionNum){
            case 1:
//                int damage = random.nextInt(hero.getAttackPower());
            	int damage = random.nextInt(heroAttackPower);
                hero.attack(damage, monster);
//                monster.receiveDamage(damage);
                if(monster.getHp() == 0){
                    System.out.println(enemy + "を倒した、戦闘終了。");
                    return false;
                }else{
                    return true;
                }
            case 2:
                hero.sleep();
                hero.setHp(heroMaxHp);
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
    public static boolean superAction(int actionNum, String enemy, SuperHero superHero, Monster monster){
        Random random = new Random();
        switch(actionNum){
            case 1:
                int damage = random.nextInt(heroAttackPower);
//                if(superHero.getIsFlying()){
//                    damage = (int)Math.round(damage * FlyHeroAttackReduceRatio);
//                }
                superHero.attack(damage, monster);
//                monster.receiveDamage(damage);
                if(monster.getHp() == 0){
                    System.out.println(enemy + "を倒した、戦闘終了。");
                    return false;
                }else{
                    return true;
                }
            case 2:
                superHero.sleep();
                superHero.setHp(superHeroMaxHp);
                return true;
            case 3:
                superHero.run();
                encounterTimes[enemyNum]--;
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

    public static boolean wizardAction(String enemy, Wizard wizard, Monster monster){
        Random random = new Random();
        int damage = random.nextInt(heroAttackPower);
        wizard.attack(damage,monster);
//        monster.receiveDamage(damage);
        if(monster.getHp() == 0){
            System.out.println(enemy + "を倒した、戦闘終了。");
            return false;
        }
        return true;
    }

    public static boolean monsterAction(String enemy, Player player, Monster monster){
        Random random = new Random();
        int actionAuto = random.nextInt(5);
        int damage = random.nextInt(heroAttackPower);
        if(actionAuto == 0){    //when the random number comes to be 0 (Possibilty: 20%), the monster will escape
            monster.run();   
            return false;
        }
        if(monster.canAttackPlayer(player)){
            monster.attack(damage,player);
//            player.receiveDamage(damage);
            if(player.getHp() == 0){
                System.out.println(player.name + "は倒られた、戦闘終了。");
                System.out.println("ゲームオーバー！");
                System.exit(0);
                return false;
            }
        } 
        return true;
    }

    public static boolean demonKingAction(SuperHero superHero, DemonKing demonKing){
        Random random = new Random();
        int actionAuto = random.nextInt(10);
        if(actionAuto == 0){    //when the random number comes to be 0 (Possibilty: 10%), demonKing will escape and superHero will win. Gameover.
            demonKing.run();
            return false;
        }
        int damage = random.nextInt(heroAttackPower);
        if(demonKing.canAttackPlayer(superHero)){
            demonKing.attack(damage,superHero);
//            superHero.receiveDamage(damage);
            if(superHero.getHp() == 0){
                System.out.println(superHero.name + "は倒られた、戦闘終了。");
                System.out.println("ゲームオーバー！");
                System.exit(0);
            }
            return false;
        }else{
            return true;
        }
    }
}
