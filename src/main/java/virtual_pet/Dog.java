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
    public Dog(String name, String furColor, String breed){
        this.name = name;
        this.furColor = furColor;
        this.breed = breed;
        this.hungerLevel = 100;
        this.thirstLevel = 100;
        this.boredomLevel = 100;
        this.needToPotty = 100;
        this.needsBath = 100;
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
        System.out.println("Woof Woof! My name is " + name + ". I have " + furColor + " fur. I'm a " + breed + ".");
    }
    public void dogCurrentStats() {
        System.out.println(name + ": Hunger: (" + hungerLevel + ") Thirst: (" + thirstLevel +
                ") Boredom: (" + boredomLevel + ") Need to Potty: (" + needToPotty +
                ") Hygiene: (" + needsBath + ")");
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
    public void statDepleteTick() {
        hungerLevel -= 3;
        thirstLevel -= 3;
        boredomLevel -= 3;
        needToPotty -= 3;
        needsBath -=3;
    }
    public void statPetHandlesOwnNeedsTick() {
        hungerLevel += 1;
        thirstLevel += 1;
        boredomLevel += 1;
        needToPotty += 1;
        needsBath +=1;
    }

    public boolean isAlive() {
        if(hungerLevel==0||thirstLevel==0||boredomLevel==0){
            return false;
        }
        return true;
    }
}
