package Package01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {

    ChoiceHandler cHandler = new ChoiceHandler();
    UI ui = new UI();
    VM vm = new VM(ui);

    public static void main(String[] args){

        new Game();

    }

    public Game(){

        ui.createUI(cHandler);
        vm.showTitleScreen();
    }
    
    public class ChoiceHandler implements ActionListener{

        public void actionPerformed(ActionEvent event){

            String yourChoice = event.getActionCommand();

            switch(yourChoice){
                case "start": vm.titleToPark(); break;
                case "c1": break;
                case "c2": break;
                case "c3": break;
                case "c4": break;
            }

        }
    }
    
}
