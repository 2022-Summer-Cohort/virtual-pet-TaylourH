package virtual_pet;

public class RoboDog extends RoboPet {
    protected String type;
    public RoboDog(String name, int age, String color, String metalType) {
        super(name, age, color, metalType);
        this.type = "Robo Dog";
    }

    @Override
    public String getType() {
        return type;
    }
    @Override
    public String makePetNoise() {
        return "Beep, Woof";
    }
}
