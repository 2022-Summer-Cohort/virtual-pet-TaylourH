package virtual_pet;


public class OrganicDog extends OrganicPet {
    protected String type;
    public OrganicDog(String name, int age, String color, String breed) {
        super(name, age, color, breed);
        this.type = "Organic Dog";
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String makePetNoise() {
        return "Woof, Woof";
    }

    @Override
    public void currentStats() {
        super.currentStats();
        System.out.println("Crate Cleanliness: (" + dwellingArea + ")");
    }
}
