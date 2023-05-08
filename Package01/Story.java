package Package01;

import Package02.weaponKnife;

public class Story {

    Game game;
    UI ui;
    VM vm;
    Player player = new Player();

    public Story(Game g, UI userInterface, VM vManager){

        game = g;
        ui = userInterface;
        vm = vManager;

    }

    public void defaultSetup(){

        player.hp = 10;
        ui.hpNumberLabel.setText("" + player.hp);

        player.currentWeapon = new weaponKnife();
        ui.weaponNameLabel.setText(player.currentWeapon.name);


    }
    
}
