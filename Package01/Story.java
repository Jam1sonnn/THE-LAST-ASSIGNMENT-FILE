package Package01;

import Package02.bigMonster;
import Package02.monsterGigachad;
import Package02.monsterZombie;
import Package02.weaponKnife;
import Package02.weaponSword;

public class Story {

    Game game;
    UI ui;
    VM vm;
    Player player = new Player();
    bigMonster monster;

    int silverRing;

    public Story(Game g, UI userInterface, VM vManager) {

        game = g;
        ui = userInterface;
        vm = vManager;

    }

    public void defaultSetup() {

        player.hp = 10;
        ui.hpNumberLabel.setText("" + player.hp);

        player.currentWeapon = new weaponKnife();
        ui.weaponNameLabel.setText(player.currentWeapon.name);

        silverRing = 0;
    }

    public void selectPosition(String nextPosition) {

        switch (nextPosition) {
            case "parkGate":
                parkGate();
                ;
                break;
            case "talkClown":
                talkClown();
                break;
            case "attackClown":
                attackClown();
                break;
            case "crossRoad":
                crossRoad();
                break;
            case "north":
                north();
                break;
            case "east":
                east();
                break;
            case "west":
                west();
                break;
            case "Fight":
                Fight();
                break;
            case "Win":
                Win();
                break;
            case "Lose":
                Lose();
                break;
            case "Ending":
                Ending();
                break;
            case "playerAttack":
                playerAttack();
                break;
            case "monsterAttack":
                monsterAttack();
                break;
            case "toTitle":
                toTitle();
                break;

        }
    }

    public void parkGate() {
        ui.mainTextArea.setText(
                "You are at the entrance to the park. \nA zombie clown is standing in front of you. \n\nWhat do you do?");
        ui.choice1.setText("Talk to the clown");
        ui.choice2.setText("Attack the clown");
        ui.choice3.setText("Leave");
        ui.choice4.setText("");

        game.nextPosition1 = "talkClown";
        game.nextPosition2 = "attackClown";
        game.nextPosition3 = "crossRoad";
        game.nextPosition4 = "";
    }

    public void talkClown() {

        if (silverRing == 0) {
            ui.mainTextArea.setText("Zombie: RAHHH DUHHH \n(He's a ZOMBIE clown dummy)");
            ui.choice1.setText(">");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "parkGate";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }

        else if (silverRing == 1) {
            ui.mainTextArea.setText(
                    "You have cleared the park of its curse. \n Sorry about earlier I couldn't help it. \n You will forever be a hero");

            ui.choice1.setVisible(false);
            ui.choice2.setVisible(false);
            ui.choice3.setVisible(false);
            ui.choice4.setVisible(false);

        }

    }

    public void attackClown() {
        ui.mainTextArea.setText("UGHHH! (He attacked you and you gave up. \n (You recieve 3 damage))");
        player.hp = player.hp - 3;
        ui.hpNumberLabel.setText("" + player.hp);
        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "parkGate";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";

        if (player.hp < 1) {
            game.nextPosition1 = "Lose";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";

        }
    }

    public void crossRoad() {

        ui.mainTextArea.setText("You are at a crossroad. \nIf you go south, you will go back to the gate.");
        ui.choice1.setText("Go North");
        ui.choice2.setText("Go East");
        ui.choice3.setText("Go South");
        ui.choice4.setText("Go West");

        game.nextPosition1 = "north";
        game.nextPosition2 = "east";
        game.nextPosition3 = "parkGate";
        game.nextPosition4 = "west";
    }

    public void north() {
        ui.mainTextArea.setText("You stumble across a game booth. \nYou find a candy bar and restore 2 HP!");
        player.hp = player.hp + 2;
        ui.hpNumberLabel.setText("" + player.hp);
        ui.choice1.setText("Go South");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "crossRoad";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void east() {

        ui.mainTextArea.setText("You stumble across a Sword in a storage closet");

        player.currentWeapon = new weaponSword();
        ui.weaponNameLabel.setText(player.currentWeapon.name);

        ui.choice1.setText("Go West");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "crossRoad";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void west() {

        int i = new java.util.Random().nextInt(100) + 1;

        if (i < 90) {

            monster = new monsterZombie();

        } else {
            monster = new monsterGigachad();
        }

        ui.mainTextArea.setText("You encounter a " + monster.name + '!');
        ui.choice1.setText("Fight");
        ui.choice2.setText("Run");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "Fight";
        game.nextPosition2 = "crossRoad";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void Fight() {

        ui.mainTextArea.setText(monster.name + ": " + monster.hp + "\n\nWhat do you do?");
        ui.choice1.setText("Attack");
        ui.choice2.setText("Run");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "playerAttack";
        game.nextPosition2 = "crossRoad";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void playerAttack() {

        int playerDamage = new java.util.Random().nextInt(player.currentWeapon.damage);

        ui.mainTextArea.setText("You attacked the " + monster.name + " and gave " + playerDamage + " damage!");

        monster.hp = monster.hp - playerDamage;

        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        if (monster.hp > 0) {
            game.nextPosition1 = "monsterAttack";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        } else if (monster.hp < 1) {
            game.nextPosition1 = "Win";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
    }

    public void monsterAttack() {
        int monsterDamage = new java.util.Random().nextInt(monster.attack);

        ui.mainTextArea.setText(monster.attackMessage + "\nYou recieved " + monsterDamage + " damage");

        player.hp = player.hp - monsterDamage;
        ui.hpNumberLabel.setText("" + player.hp);

        if (player.hp > 0) {
            ui.choice1.setText("Attack");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "playerAttack";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";

        } else if (player.hp < 1) {
            ui.choice1.setText(">");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "Lose";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";

        }
    }

    public void Win() {

        ui.mainTextArea.setText(
                "You've defeated the " + monster.name + "\nThey dropped a ring!\n\n(You obtained a Silver Ring)");

        silverRing = 1;

        ui.choice1.setText("Go East");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "crossRoad";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void Lose() {

        ui.mainTextArea.setText("You are dead! \n\nGAME OVER!");

        ui.choice1.setText("To the title screen");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "toTitle";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void Ending() {

        ui.mainTextArea.setText("You have cleared the park of its curse. \nYou will forever be a hero!");

        ui.choice1.setVisible(false);
        ui.choice2.setVisible(false);
        ui.choice3.setVisible(false);
        ui.choice4.setVisible(false);
    }

    public void toTitle() {

        defaultSetup();
        vm.showTitleScreen();
    }

}
