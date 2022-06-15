package virtual_pet;


import java.util.ArrayList;
import java.util.Scanner;

public class VirtualPetApplication {
    String[] shelterMain = {"Admit New Pet", "Adopt Pet", "Take Care of All pets","Ask Pets For Suggestions","Quit Game"};
    String[] careForAllPetsMenu = {"Replenish", "Refill Liquids", "Tend to Internal Needs", "Play", "Walk", "Bathe", "Improve Temperament", "Treat","Have 2 Pets Play Together", "Kill", "Clean Pet Areas","return to shelter main menu","Quit Game"};
    String[] allPetAskMenu = {"Get Trivia Facts", "Song Suggestions", "Movie Suggestions", "TV Show Suggestions", "Meal Suggestions", "Book Suggestions", "Get Quotes", "Get Jokes", "return to care for all pets menu","return to shelter main menu","Quit Game" };

    public static void main(String[] args) {
        VirtualPetApplication myApp = new VirtualPetApplication();
        myApp.gameLoop();
    }

    public void gameLoop() {
        Scanner input = new Scanner(System.in);
        VirtualPetShelter myShelter = new VirtualPetShelter();

        int keyPress = 0;

        while (keyPress != 5) {
            myShelter.shelterOverview();
            myShelter.listShelterPets();
            System.out.println(displayMenu(shelterMain));

            keyPress = input.nextInt();
            input.nextLine();

            switch (keyPress) {
                case 1:
                    System.out.println("Please give the pet a name.");
                    String name = input.nextLine();
                    System.out.println("Please specify the pet's age (as a number).");
                    int age = input.nextInt();
                    input.nextLine();
                    System.out.println("Please provide the pet's color.");
                    String color = input.nextLine();
                    System.out.println("Is it robotic or organic?");
                    String type = input.nextLine();
                    System.out.println("Is it a dog or cat");
                    String dogOrCat = input.nextLine();
                    if (type.equalsIgnoreCase("robotic") && dogOrCat.equalsIgnoreCase("dog")) {
                        System.out.println("What is the dog's metal type?");
                        String metal = input.nextLine();
                        myShelter.admitPet(new RoboDog(name, age, color, metal));
                    } else if (type.equalsIgnoreCase("robotic") && dogOrCat.equalsIgnoreCase("cat")) {
                        System.out.println("What is the cat's metal type?");
                        String metal = input.nextLine();
                        myShelter.admitPet(new RoboCat(name, age, color, metal));
                    } else if (type.equalsIgnoreCase("organic") && dogOrCat.equalsIgnoreCase("dog")) {
                        System.out.println("What is the dog's breed?");
                        String breed = input.nextLine();
                        myShelter.admitPet(new OrganicDog(name, age, color, breed));
                    } else if (type.equalsIgnoreCase("organic") && dogOrCat.equalsIgnoreCase("cat")) {
                        System.out.println("What is the cat's breed?");
                        String breed = input.nextLine();
                        myShelter.admitPet(new OrganicCat(name, age, color, breed));
                    }
                    break;
                case 2:
                    System.out.println("Please write the name of the pet that you want to adopt.");
                    String adoptName = input.nextLine();
                    myShelter.adoptPet(adoptName);
                    break;
                case 3:
                    allPetMenu(input, myShelter);
                    break;
                case 4:
                    allAskPetMenu(input, myShelter);
                    break;
                case 5:
                    break;
                default:
            }
        }
    }
    public String displayMenu(String[] menu) {
        String output = "Please Enter: \n";
        int count = 1;
        for (String menuOption : menu) {
            output += "\t\t#" + count + " " + menuOption + "\n";
            count++;
        }
        output = output.substring(0, output.length() - 1);
        return output;
    }

    public void allPetMenu(Scanner input, VirtualPetShelter myShelter) {
        int choice = 0;
        while (choice != 13 && (myShelter.aliveShelterPets() >= 1)) {
            myShelter.shelterOverview();
            myShelter.showAllPetsStats();
            myShelter.allPetsStatDeplete();
            myShelter.statsAllPetsHandleOwnNeedsTick();
            myShelter.shelterPetsDeathCheckAndRemoval();
            System.out.println(displayMenu(careForAllPetsMenu));
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1:
                    myShelter.allReplenish();
                    break;
                case 2:
                    myShelter.allRefillLiquids();
                    break;
                case 3:
                    myShelter.allInternalNeeds();
                    break;
                case 4:
                    myShelter.allPlay();
                    break;
                case 5:
                    myShelter.allWalk();
                    break;
                case 6:
                    myShelter.allGiveBath();
                    break;
                case 7:
                    myShelter.giveAttention();
                    break;
                case 8:
                    myShelter.allTreat();
                    break;
                case 9:
                    myShelter.listShelterPets();
                    System.out.println("Please write the name of the 1st pet that you want to play together.");
                    String playName1 = input.nextLine();
                    myShelter.listShelterPets();
                    System.out.println("Please write the name of the 2nd pet that you want to play together.");
                    String playName2 = input.nextLine();
                    myShelter.twoPetsPlay(playName1, playName2);
                    break;
                case 10:
                    myShelter.allKill();
                    break;
                case 11:
                    myShelter.cleanAllDwellingAreas();
                    break;
                case 12:
                    gameLoop();
                    break;
                case 13:
                    break;
                default:
            }
        }
    }
    public void allAskPetMenu(Scanner input, VirtualPetShelter myShelter) {
        int choice = 0;
        while (choice != 10) {
            System.out.println("Feel free to ask the shelter pets any of the following--- ");
            System.out.println(displayMenu(allPetAskMenu));
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    myShelter.allGiveRandomTrivia();
                    break;
                case 2:
                    myShelter.allGiveSongSuggestion();
                    break;
                case 3:
                    myShelter.allGiveMovieSuggestion();
                    break;
                case 4:
                    myShelter.allGiveTvShowSuggestion();
                    break;
                case 5:
                    myShelter.allGiveFoodSuggestion();
                    break;
                case 6:
                    myShelter.allGiveBookSuggestion();
                    break;
                case 7:
                    myShelter.allGiveRandomQuote();
                    break;
                case 8:
                    myShelter.allTellJoke();
                    break;
                case 9:
                    gameLoop();
                    break;
                case 10:
                    break;
                default:
            }
        }
    }
}