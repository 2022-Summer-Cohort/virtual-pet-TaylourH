package virtual_pet;

public class Dog {
    private String name;
    private String furColor;
    private String breed;
    private int hungerLevel;
    private int thirstLevel;
    private int boredomLevel;
    private int needToPotty;
    private int needsBath;

    public Dog(String name, String furColor, String breed, int hungerLevel, int thirstLevel, int boredomLevel, int needToPotty, int needsBath) {
        this.name = name;
        this.furColor = furColor;
        this.breed = breed;
        this.hungerLevel = hungerLevel;
        this.thirstLevel = thirstLevel;
        this.boredomLevel = boredomLevel;
        this.needToPotty = needToPotty;
        this.needsBath = needsBath;
    }

    public String getName() {
        return name;
    }

    public String getFurColor() {
        return furColor;
    }

    public String getBreed() { return breed; }

    public int getHungerLevel() {
        return hungerLevel;
    }

    public int getThirstLevel() {
        return thirstLevel;
    }

    public int getBoredomLevel() {
        return boredomLevel;
    }

    public int getNeedToPotty() {
        return needToPotty;
    }

    public int getNeedsBath() {
        return needsBath;
    }
    public void dogIntro() {
        System.out.println("Woof Woof! My name is " + name + " and I have " + furColor + " fur. I am a " + breed + ".");
    }
    public void dogCurrentStats() {
        System.out.println("Currently, my HUNGER is at " + hungerLevel + ", my THRIST is at " + thirstLevel +
                ", my BOREDOM is at " + boredomLevel + ", my NEED TO POTTY is at " + needToPotty +
                " and my NEED FOR A BATH is at " + needsBath + ".");
    }
    public void feed() {
        hungerLevel = Math.min(100,hungerLevel+5);
//        hungerLevel = Math.max(0, hungerLevel-5);
    }
    public void giveWater() {
        thirstLevel = Math.min(100,thirstLevel+5);
//        thirstLevel = Math.max(0, thirstLevel-5);
    }
    public void play() {
        boredomLevel = Math.min(100, boredomLevel+5);
    }
    public void walk() {
        needToPotty = Math.min(100, needsBath+5);
    }
    public void giveBath() {
        needsBath = Math.min(100, needsBath+5);
    }
//    public void treat() {
//        happiness = Math.min(500,happiness+10);
//    }
//    public void train() {
//        stubbornness = Math.max(0,stubbornness-10);
//    }
//    public void scold() {
//        stubbornness = Math.min(100,stubbornness+5);
//    }
//    public void ignore() {
//        happiness = Math.max(0,happiness-25);
//    }
    public void tick() {
        hungerLevel -= 5;
        thirstLevel -= 5;
        boredomLevel -= 5;
        needToPotty -= 5;
        needsBath -=5;
    }
}
    /* Establish HEALTH (total 500) and HAPPINESS (total 500) overall stats that are affected by hungerLvl, thirstLvl,
    boredomLvl, needToPotty, & needsBath
    Health = 0; pet dead Happiness = as it decreases pet gets difficult
    run these stats through a loop?
    hunger, thirst, decreases health by 1 every 1 minute and happiness by 1 every 5 minutes
    boredom, potty, bath decreases happiness by 1 every 5 minutes and health every 10 minutes
    Stats increase by user input (number 1-9) [1. feed, 2. give water, 3. play, 4. walk, 5. let into backyard,
    6. give bath, 7. treat, 8. yell at/scold, 9. ignore]
    */
