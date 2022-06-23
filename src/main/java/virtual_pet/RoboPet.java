package virtual_pet;

import java.util.ArrayList;
import java.util.Random;

public abstract class RoboPet extends VirtualPet {
    private int batteryLvl;
    private int awarenessLvl;
    private int oilLvl;
    private int maintenanceLvl;
    private int damageLvl;
    protected String metalType;
    protected String type;

    public RoboPet(String name, int age, String color, String metalType) {
        super(name, age, color);
        this.metalType = metalType;
        this.batteryLvl = 500;
        this.awarenessLvl = 0;
        this.oilLvl = 350;
        this.maintenanceLvl = 350;
        this.damageLvl = 0;
        this.type = null;
    }

    public int getBatteryLvl() {
        return batteryLvl;
    }

    public int getAwarenessLvl() {
        return awarenessLvl;
    }

    public int getOilLvl() {
        return oilLvl;
    }

    public int getMaintenanceLvl() {
        return maintenanceLvl;
    }

    public int getDamageLvl() {
        return damageLvl;
    }

    public String getMetalType() {
        return metalType;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public boolean deadCheck() {
        ArrayList<String> deathResponses = new ArrayList<>();
        deathResponses.add(name + " is defunct.");
        deathResponses.add(name + " is no longer operational.");
        deathResponses.add(name + " has been destroyed.");
        deathResponses.add(name + " is beyond repair.");
        deathResponses.add(name + " has been demolished.");
        Random random = new Random();
        if (roboPetValue() <= 0) {
            System.out.println(deathResponses.get((random.nextInt(deathResponses.size()))));
            return true;
        }
        return false;
    }

    @Override
    public String makePetNoise() {
        return "I don't make a noise. I'm an Abstract RoboPet!";
    }

    public int roboPetValue() {
        return ((batteryLvl + oilLvl + maintenanceLvl) - (damageLvl + awarenessLvl));
    }

    public void intro() {
        System.out.println("(" + getType() + ") " + makePetNoise() + "! My name is " + name + " and I'm made of " + color + " " + metalType + ". I was manufactured " + age + " year(s) ago.");
    }

    public void currentStats() {
        System.out.println("(" + getType() + ") " + name + ": Overall Value: (" + roboPetValue() + ") Battery: (" + batteryLvl + ") Self-Awareness: (" + awarenessLvl + ") Oil: (" + oilLvl + ") Maintenance: (" + maintenanceLvl + ") Damage: (" + damageLvl + ")");
    }

    public void statsDepleteTick() {
        batteryLvl -= 10;
        oilLvl -= 10;
        maintenanceLvl -= 10;
        awarenessLvl += 5;
        damageLvl += 5;
    }

    public void petTakesCareOfOwnNeedsTick() {
        batteryLvl += 5;
        oilLvl += 5;
        maintenanceLvl += 5;
        awarenessLvl += 5;
        damageLvl += 5;
    }

    public void recharge() {
        if (awarenessLvl > 50) {
            batteryLvl = Math.min(500, batteryLvl + 5);
            maintenanceLvl = Math.max(0, maintenanceLvl - 5);
        } else {
            badBehavior();
        }
    }

    public void changeOil() {
        oilLvl = Math.min(350, oilLvl + 5);
        maintenanceLvl = Math.min(100, maintenanceLvl + 5);
    }

    public void performMaintenance() {
        maintenanceLvl = Math.min(100, maintenanceLvl + 5);
        awarenessLvl = Math.max(0, awarenessLvl - 100);
    }

    public void walk() {
        if (awarenessLvl > 50) {
            batteryLvl = Math.max(0, batteryLvl - 5);
            oilLvl = Math.max(0, oilLvl - 5);
            maintenanceLvl = Math.max(0, maintenanceLvl - 5);
            damageLvl = Math.min(250, damageLvl + 2);
        } else {
            badBehavior();
        }
    }

    public void play() {
            batteryLvl = Math.max(0, batteryLvl - 5);
            oilLvl = Math.max(0, oilLvl - 5);
            awarenessLvl = Math.max(0, awarenessLvl - 5);
            maintenanceLvl = Math.max(0, maintenanceLvl - 5);
            damageLvl = Math.min(250, damageLvl + 2);
    }

    public void downloadUpdate() {
        batteryLvl = Math.min(500, batteryLvl + 5);
        maintenanceLvl = Math.max(0, maintenanceLvl - 5);
        awarenessLvl = Math.max(0, awarenessLvl - 10);
    }

    public void runOverWithCar() {
        batteryLvl = Math.max(0, batteryLvl - 500);
        oilLvl = Math.max(0, oilLvl - 350);
        maintenanceLvl = Math.max(0, maintenanceLvl - 350);
        awarenessLvl = Math.max(0, awarenessLvl - 250);
        damageLvl = Math.min(250, damageLvl + 250);
    }

    public void repair() {
        damageLvl = Math.max(0, damageLvl - 150);
    }

    public void giveBath() {
        damageLvl = Math.min(250, damageLvl + 175);
    }

    public void badBehavior() {
        if (awarenessLvl >= 50) {
            ArrayList<String> badBehavior = new ArrayList<>();
            badBehavior.add(makePetNoise() + "! " + name + " smashes your tv screen!");
            badBehavior.add(makePetNoise() + "! " + name + " siphons the gas from your car!");
            badBehavior.add(makePetNoise() + "! " + name + " factory resets your cellphone!");
            badBehavior.add(makePetNoise() + "! " + name + " reprograms your oven and your turkey burns to a crisp!");
            Random random = new Random();
            System.out.println(badBehavior.get((random.nextInt(badBehavior.size()))));
        }
    }

    @Override
    public void giveRandomTrivia() {
        ArrayList<String> trivia = new ArrayList<>();
        trivia.add("A 'butt load' is an actual unit of measurement and is equivalent to 126 gallons.");
        trivia.add("A banana may be a berry but a strawberry isn’t. Surprised!? Here's another bombshell, tomatoes, cucumbers, and eggplants are botanically speaking actually fruits.");
        trivia.add("By the time the first Star Wars film came out (1977), France was still executing people with a guillotine.");
        trivia.add("An 11 year old British girl was responsible for naming the 9th planet in the Solar System, Pluto. Alas, Pluto has been declassified as a planet (1930-2006).");
        trivia.add("A billion is actually a lot; A thousand seconds is about 16 minutes, a million seconds is about 11 days while a billion seconds is about 32 years.");
        Random random = new Random();
        System.out.println("(" + getType() + ") " + name + ": " + trivia.get((random.nextInt(trivia.size()))));
    }

    @Override
    public void giveSongSuggestion() {
        ArrayList<String> songs = new ArrayList<>();
        songs.add("Eye Of The Tiger by Survivor");
        songs.add("Thriller by Michael Jackson");
        songs.add("Monster Mash by Bobby (Boris) Pickett");
        songs.add("All About That Bass by Meghan Trainor");
        songs.add("Grenade by Bruno Mars");
        Random random = new Random();
        System.out.println("(" + getType() + ") " + name + ": " + makePetNoise() + ", I suggest listening to " + songs.get((random.nextInt(songs.size()))) + ".");
    }

    @Override
    public void giveMovieSuggestion() {
        ArrayList<String> movies = new ArrayList<>();
        movies.add("Mean Girls");
        movies.add("The Lion King");
        movies.add("Bridesmaids");
        movies.add("The Fast and the Furious");
        movies.add("The Devil Wears Prada");
        Random random = new Random();
        System.out.println("(" + getType() + ") " + name + ": " + makePetNoise() + ", I suggest watching " + movies.get((random.nextInt(movies.size()))) + ".");
    }

    @Override
    public void giveTvShowSuggestion() {
        ArrayList<String> tvShows = new ArrayList<>();
        tvShows.add("Parks and Recreation");
        tvShows.add("Schitt's Creek");
        tvShows.add("Psych");
        tvShows.add("It's Always Sunny in Philadelphia");
        tvShows.add("The IT Crowd");
        Random random = new Random();
        System.out.println("(" + getType() + ") " + name + ": " + makePetNoise() +", I suggest watching " + tvShows.get((random.nextInt(tvShows.size()))) + ".");
    }

    @Override
    public void giveFoodSuggestion() {
        ArrayList<String> foods = new ArrayList<>();
        foods.add("Tacos");
        foods.add("Pizza");
        foods.add("Barbeque chicken, mashed potatoes, and peas");
        foods.add("Lasagna");
        foods.add("Chicken curry with rice");
        Random random = new Random();
        System.out.println("(" + getType() + ") " + name + ": " + makePetNoise() +", I suggest eating " + foods.get((random.nextInt(foods.size()))) + ".");
    }

    @Override
    public void giveBookSuggestion() {
        ArrayList<String> books = new ArrayList<>();
        books.add("Sense & Sensibility by Jane Austen");
        books.add("Little Women by Louisa May Alcott");
        books.add("The Outsiders by S.E. Hinton");
        books.add("The Catcher in the Rye by J.D. Salinger");
        books.add("Lord of the Flies by William Golding");
        Random random = new Random();
        System.out.println("(" + getType() + ") " + name + ": " + makePetNoise() + ", I suggest reading " + books.get((random.nextInt(books.size()))) + ".");
    }

    @Override
    public void giveRandomQuote() {
        ArrayList<String> quotes = new ArrayList<>();
        quotes.add("Be yourself; everyone else is already taken. (Oscar Wilde)");
        quotes.add("It is never too late to be what you might have been. (George Eliot)");
        quotes.add("When one door of happiness closes, another opens; but often we look so long at the closed door that we do not see the one which has been opened for us. (Helen Keller)");
        quotes.add("Nothing is impossible, the word itself says 'I'm possible'! (Audrey Hepburn)");
        quotes.add("Happiness is not something ready made. It comes from your own actions. (The 14th Dalai Lama)");
        Random random = new Random();
        System.out.println("(" + getType() + ") " + name + ": " + quotes.get((random.nextInt(quotes.size()))));
    }

    @Override
    public void tellJoke() {
        ArrayList<String> jokes = new ArrayList<>();
        jokes.add("I don't trust stairs. They are always up to something.");
        jokes.add("The bank keeps calling me to give me compliments. They say I have an outstanding balance!");
        jokes.add("What's the least-spoken language in the world? Sign language.");
        jokes.add("I'm an expert at picking leaves and heating them in water. It's my special tea.");
        jokes.add("How do you make holy water? You boil the hell out of it.");
        Random random = new Random();
        System.out.println("(" + getType() + ") " + name + ": " + jokes.get((random.nextInt(jokes.size()))));
    }
}
