package virtual_pet;
public abstract class VirtualPet {
    protected String name;
    protected int age;
    protected String color;
    protected String type;
    public VirtualPet(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.type = null;
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }

    public abstract boolean deadCheck();
    public abstract String makePetNoise();
    public abstract void intro();
    public abstract void currentStats();
    public abstract void statsDepleteTick();
    public abstract void petTakesCareOfOwnNeedsTick();
    public abstract void walk();
    public abstract void play();
    public abstract void giveBath();
    public abstract void giveRandomTrivia();
    public abstract void giveSongSuggestion();
    public abstract void giveMovieSuggestion();
    public abstract void giveTvShowSuggestion();
    public abstract void giveFoodSuggestion();
    public abstract void giveBookSuggestion();
    public abstract void giveRandomQuote();
    public abstract void tellJoke();

}
