package virtual_pet;

public class RoboCat extends RoboPet{
    protected String type;
    public RoboCat(String name, int age, String color, String metalType) {
        super(name, age, color, metalType);
        this.type = "Robo Cat";
    }

    @Override
    public String getType() {
        return type;
    }
    @Override
    public String makePetNoise() {
        return "Beep, Meow";
    }
}
