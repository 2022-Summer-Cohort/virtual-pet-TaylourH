package virtual_pet;

import java.util.Scanner;

public class VirtualPetApplication {

    public static void main(String[] args) {
        //Interact with a VirtualPet object in this method
       VirtualPetApplication myApp = new VirtualPetApplication();
        myApp.gameLoop();
    }

    public int gameLoop(){
        Dog dog1 = new Dog("Kensington","white","Bull Boxer",100,100,100,100,100);
        Scanner input = new Scanner(System.in);
        int keyPress = 0;
        dog1.dogIntro();
        while (true){
            dog1.dogCurrentStats();
            dog1.tick();
            System.out.println("Press #1 to feed, press #2 to give water, #3 to play, #4 to walk, #5 to train," +
                    " press 6 to give bath, press #7 to treat, press #8 to scold, #9 ignore, press #10 to quit");
            keyPress = input.nextInt();

        switch (keyPress) {
            case 1:
                dog1.feed();
                break;
            case 2:
                dog1.giveWater();
                break;
            case 3:
                dog1.play();
                break;
            case 4:
                dog1.walk();
                break;
//            case 5:
//                dog1.train();
//                break;
            case 6:
                dog1.giveBath();
                break;
//            case 7:
//                dog1.treat();
//                break;
//            case 8:
//                dog1.scold();
//                break;
//            case 9:
//                dog1.ignore();
//                break;
//            case 10:
//
//                break;
            default:
                System.out.println("Goodbye!");
        }
//            dog1.tick();
        }
    }

}
