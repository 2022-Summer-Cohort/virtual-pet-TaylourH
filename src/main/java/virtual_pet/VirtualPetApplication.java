package virtual_pet;

import java.util.Scanner;

public class VirtualPetApplication {

    public static void main(String[] args) {
        VirtualPetApplication myApp = new VirtualPetApplication();
        myApp.gameLoop();
    }

    public void gameLoop() {
        Dog dog1 = new Dog("Kensington", "White", "Bull Boxer");
        Dog dog2 = new Dog("Iroh", "Brown","Shiba Inu");
        Dog dog3 = new Dog("Pepper","Black","Mutt");
        Dog dog4 = new Dog("Blue","Blue","Cartoon");

        Scanner input = new Scanner(System.in);

        VirtualPetShelter myShelter = new VirtualPetShelter();

        myShelter.addPet(dog1);
        myShelter.addPet(dog2);
        myShelter.addPet(dog3);
        myShelter.addPet(dog4);

        int keyPress = 0;
        myShelter.allDogIntros();
        while (myShelter.allPetsAlive()) {
            myShelter.showAllPetStats();
            myShelter.allPetsStatDepleteTick();
            myShelter.statsAllPetHandlesOwnNeedsTick();
            System.out.println("Press #1 to FEED all, press #2 to GIVE WATER to all, #3 to PLAY with all, #4 to WALK, #5 to GIVE BATH to all, #6 to ADMIT a new pet, #7 to ADOPT a pet from the shelter");
            keyPress = input.nextInt();
            input.nextLine();

            switch (keyPress) {
                case 1:
                    myShelter.feedAll();
                    break;
                case 2:
                    myShelter.giveWaterToAll();
                    break;
                case 3:
                    myShelter.playWithAll();
                    break;
                case 4:
                    myShelter.walkAll();
                    break;
                case 5:
                    myShelter.batheAll();
                    break;
                case 6:
                    System.out.println("Please give the dog a name.");
                    String name = input.nextLine();
                    System.out.println("Please specify the dog's fur color.");
                    String furColor = input.nextLine();
                    System.out.println("Please provide the dog's breed.");
                    String breed = input.nextLine();
                    myShelter.addPet(new Dog(name, furColor, breed));
                    break;
            case 7:
                System.out.println("Please write the name of the dog that you want to adopt.");
                String adoptName = input.nextLine();
                myShelter.adoptPet(adoptName);
                break;
            }
        }
    }

}
