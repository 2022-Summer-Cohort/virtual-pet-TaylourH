package virtual_pet;

import java.util.ArrayList;
import java.util.Random;

public abstract class OrganicPet extends VirtualPet implements DwellingAid {
    private int happinessLvl;
    private int stubbornnessLvl;
    private int boredomLvl;
    private int hungerLvl;
    private int thirstLvl;
    private int needToPottyLvl;
    private int cleanlinessLvl;
    protected String breed;
    protected int dwellingArea;
    protected String type;

    public OrganicPet(String name, int age, String color, String breed) {
        super(name, age, color);
        this.breed = breed;
        this.happinessLvl = 200;
        this.stubbornnessLvl = 0;
        this.boredomLvl = 200;
        this.hungerLvl = 300;
        this.thirstLvl = 300;
        this.needToPottyLvl = 100;
        this.cleanlinessLvl = 100;
        this.dwellingArea = 50;
        this.type = null;
    }

    public int getHappinessLvl() {
        return happinessLvl;
    }

    public int getStubbornnessLvl() {
        return stubbornnessLvl;
    }

    public int getBoredomLvl() {
        return boredomLvl;
    }

    public int getHungerLvl() {
        return hungerLvl;
    }

    public int getThirstLvl() {
        return thirstLvl;
    }

    public int getNeedToPottyLvl() {
        return needToPottyLvl;
    }

    public int getCleanlinessLvl() {
        return cleanlinessLvl;
    }

    public String getBreed() {
        return breed;
    }

    public int getDwellingArea() {
        return dwellingArea;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public boolean deadCheck() {
        ArrayList<String> deathResponses = new ArrayList<>();
        deathResponses.add(name + " is dead.");
        deathResponses.add(name + " has bought the farm.");
        deathResponses.add(name + " has gone on to digital pet heaven.");
        deathResponses.add(name + " has bit the dust.");
        deathResponses.add(name + " has died.");
        Random random = new Random();
        if (overallHealth() <= 0) {
            System.out.println(deathResponses.get((random.nextInt(deathResponses.size()))));
            return true;
        }
        return false;
    }

    @Override
    public String makePetNoise() {
        return "I don't make a noise. I'm an Abstract Organic Pet!";
    }

    public int overallHealth() {
        return (hungerLvl + boredomLvl + thirstLvl + needToPottyLvl + cleanlinessLvl + happinessLvl);
    }

    public void intro() {
        System.out.println("(" + getType() + ") " + makePetNoise() + "! My name is " + name + ". I'm a/an " + age + " year old " + color + " " + breed + ".");
    }

    public void currentStats() {
        System.out.println("(" + getType() + ") " + name + ": Overall Health: (" + overallHealth() + ") Happiness: (" + happinessLvl + ") Stubbornness: (" + stubbornnessLvl + ") Hunger: (" + hungerLvl + ") Thirst: (" + thirstLvl + ") Boredom: (" + boredomLvl + ") Need to Potty: (" + needToPottyLvl + ") Hygiene: (" + cleanlinessLvl + ")");
    }

    public void statsDepleteTick() {
        hungerLvl -= 10;
        thirstLvl -= 10;
        boredomLvl -= 10;
        needToPottyLvl -= 10;
        cleanlinessLvl -= 10;
        stubbornnessLvl += 5;
        happinessLvl -= 5;
        dwellingArea -= 10;
    }

    public void petTakesCareOfOwnNeedsTick() {
        hungerLvl += 5;
        thirstLvl += 5;
        boredomLvl += 5;
        needToPottyLvl += 5;
        cleanlinessLvl += 5;
        stubbornnessLvl += 5;
    }

    public void feed() {
        if (stubbornnessLvl < 5) {
            hungerLvl = Math.min(300, hungerLvl + 5);
            happinessLvl = Math.min(200, happinessLvl + 5);
        } else {
            badBehavior();
        }
    }

    public void giveWater() {
        thirstLvl = Math.min(300, thirstLvl + 5);
        happinessLvl = Math.min(200, happinessLvl + 5);
    }

    public void play() {
            boredomLvl = Math.min(200, boredomLvl + 5);
            happinessLvl = Math.min(200, happinessLvl + 5);
            hungerLvl = Math.max(0, hungerLvl - 2);
            thirstLvl = Math.max(0, thirstLvl - 2);
    }

    public void walk() {
        if (stubbornnessLvl < 5) {
            needToPottyLvl = Math.min(100, cleanlinessLvl + 5);
            happinessLvl = Math.min(200, happinessLvl + 5);
            hungerLvl = Math.max(0, hungerLvl - 3);
            thirstLvl = Math.max(0, thirstLvl - 3);
            dwellingArea = Math.max(0, dwellingArea - 10);
        } else {
            badBehavior();
        }
    }

    public void giveBath() {
        cleanlinessLvl = Math.min(100, cleanlinessLvl + 5);
        happinessLvl = Math.min(200, happinessLvl + 5);
    }

    public void treat() {
        happinessLvl = Math.min(200, happinessLvl + 5);
        stubbornnessLvl = Math.max(0, stubbornnessLvl - 2);
        hungerLvl = Math.min(300, hungerLvl + 1);
    }

    public void train() {
        stubbornnessLvl = Math.max(0, stubbornnessLvl - 3);
        happinessLvl = Math.min(200, happinessLvl + 1);
        hungerLvl = Math.max(0, hungerLvl - 1);
        thirstLvl = Math.max(0, thirstLvl - 1);
    }

    public void cuddle() {
        happinessLvl = Math.min(200, happinessLvl + 5);
        stubbornnessLvl = Math.max(0, stubbornnessLvl - 3);
    }

    public void badBehavior() {
        if (stubbornnessLvl >= 5) {
            ArrayList<String> badBehavior = new ArrayList<>();
            badBehavior.add(makePetNoise() + "! " + name + " bites you!");
            badBehavior.add(makePetNoise() + "! " + name + " pees on your favorite shirt!");
            badBehavior.add(makePetNoise() + "! " + name + " chews on your sofa!");
            badBehavior.add(makePetNoise() + "! " + name + " scratches your hand!");
            Random random = new Random();
            System.out.println(badBehavior.get((random.nextInt(badBehavior.size()))));
        }
    }

    public void euthanize() {
        hungerLvl = Math.max(0, hungerLvl - 300);
        thirstLvl = Math.max(0, thirstLvl - 300);
        boredomLvl = Math.max(0, boredomLvl - 200);
        needToPottyLvl = Math.max(0, needToPottyLvl - 100);
        cleanlinessLvl = Math.max(0, cleanlinessLvl - 100);
        stubbornnessLvl = Math.max(0, stubbornnessLvl - 10);
        happinessLvl = Math.max(0, happinessLvl - 200);
    }

    public void cleanPetArea() {
        dwellingArea = Math.min(50, dwellingArea + 50);
    }

    @Override
    public void giveRandomTrivia() {
        ArrayList<String> no = new ArrayList<>();
        no.add(name + " stares at you blankly.");
        no.add(makePetNoise() + "! " + name + " runs away from you!");
        no.add(makePetNoise() + "! " + name + " throws up.");
        Random random = new Random();
        System.out.println(no.get((random.nextInt(no.size()))));
    }

    @Override
    public void giveSongSuggestion() {
        ArrayList<String> no = new ArrayList<>();
        no.add(name + " stares at you blankly.");
        no.add(makePetNoise() + "! " + name + " runs away from you!");
        no.add(makePetNoise() + "! " + name + " throws up.");
        Random random = new Random();
        System.out.println(no.get((random.nextInt(no.size()))));
    }

    @Override
    public void giveMovieSuggestion() {
        ArrayList<String> no = new ArrayList<>();
        no.add(name + " stares at you blankly.");
        no.add(makePetNoise() + "! " + name + " runs away from you!");
        no.add(makePetNoise() + "! " + name + " throws up.");
        Random random = new Random();
        System.out.println(no.get((random.nextInt(no.size()))));
    }

    @Override
    public void giveTvShowSuggestion() {
        ArrayList<String> no = new ArrayList<>();
        no.add(name + " stares at you blankly.");
        no.add(makePetNoise() + "! " + name + " runs away from you!");
        no.add(makePetNoise() + "! " + name + " throws up.");
        Random random = new Random();
        System.out.println(no.get((random.nextInt(no.size()))));
    }

    @Override
    public void giveFoodSuggestion() {
        ArrayList<String> no = new ArrayList<>();
        no.add(name + " stares at you blankly.");
        no.add(makePetNoise() + "! " + name + " runs away from you!");
        no.add(makePetNoise() + "! " + name + " throws up.");
        Random random = new Random();
        System.out.println(no.get((random.nextInt(no.size()))));
    }

    @Override
    public void giveBookSuggestion() {
        ArrayList<String> no = new ArrayList<>();
        no.add(name + " stares at you blankly.");
        no.add(makePetNoise() + "! " + name + " runs away from you!");
        no.add(makePetNoise() + "! " + name + " throws up.");
        Random random = new Random();
        System.out.println(no.get((random.nextInt(no.size()))));
    }

    @Override
    public void giveRandomQuote() {
        ArrayList<String> no = new ArrayList<>();
        no.add(name + " stares at you blankly.");
        no.add(makePetNoise() + "! " + name + " runs away from you!");
        no.add(makePetNoise() + "! " + name + " throws up.");
        Random random = new Random();
        System.out.println(no.get((random.nextInt(no.size()))));
    }

    @Override
    public void tellJoke() {
        ArrayList<String> no = new ArrayList<>();
        no.add(name + " stares at you blankly.");
        no.add(makePetNoise() + "! " + name + " runs away from you!");
        no.add(makePetNoise() + "! " + name + " throws up.");
        Random random = new Random();
        System.out.println(no.get((random.nextInt(no.size()))));
    }
}
