//package javarpg;
//
//public class Main_Test2 {
//	 //superHero's venture
//    while(ventureloop){ 
//        enemyNum = random.nextInt(4); //random with number 0 to meet slime, 1 to goblin, 2 to wolfman, 3 to demonKing
//        if(enemyNum < 3){
//            System.out.println(Enemies[enemyNum] + "に出会った、バトルが始まる");
//            battleloop = true;
//            while(battleloop){
//                System.out.println("スーパー勇者(" + superHero.getName() + ")に指示を出してください「1.戦う 2.眠る 3.逃げる 4.空を⾶ぶ 5.着陸する」:");
//                actionNum = scanner.nextInt();
//                if(enemyNum == 0){
//                    monster = new Slime();
//                }else if(enemyNum == 1){
//                    monster = new Goblin();
//                }else{
//                    monster = new Wolfman();
//                }
//                battleloop = superAction(actionNum, Enemies[enemyNum], superHero, monster);
//                if(!battleloop){break;}
//                battleloop = wizardAction(Enemies[enemyNum], wizard, monster);
//                if(!battleloop){break;}
//                battleloop = monsterAction(Enemies[enemyNum], superHero, monster);
//                if(!battleloop){break;}
//            }
//        } else{
//            ventureloop = false;
//        }
//    }
//    
//  //final battle: Encounter with princess, Battle with the Demon King
//    System.out.println("姫様に出会った。");
//    princess.talk();
//    System.out.println("魔王が現れた。");
//    demonKing.talk();
//    // demonKing.setAttackPower(HeroAttackPower*5);
//    
//    superHero.talk();
//    System.out.println("バトルが始まる！");
//    boolean battleloopWithDemon = true;
//    while(battleloopWithDemon){
//        System.out.println("スーパー勇者(" + superHero.getName() + ")に指示を出してください「1.戦う 2.眠る 3.逃げる 4.空を⾶ぶ 5.着陸する」:");
//        actionNum = scanner.nextInt();
//        if(enemyNum == 0){
//            monster = new Slime();
//        }else if(enemyNum == 1){
//            monster = new Goblin();
//        }else{
//            monster = new Wolfman();
//        }
//        
//        System.out.println("Debug: Your HP:" +superHero.getHp() + " Monster HP:" + demonKing.getHp());
//        princess.cheer(superHero);
//        battleloopWithDemon = superAction(actionNum, Enemies[enemyNum], superHero, demonKing);
//        if(!battleloopWithDemon){break;}
//        battleloopWithDemon = wizardAction(Enemies[enemyNum], wizard, demonKing);
//        if(!battleloopWithDemon){break;}
//        battleloopWithDemon = demonKingAction(superHero, demonKing);
//        if(!battleloopWithDemon){break;}
//    }
//    System.out.println("Game Finished");
//}
