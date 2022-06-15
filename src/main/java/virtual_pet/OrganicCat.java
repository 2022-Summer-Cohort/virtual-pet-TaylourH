package virtual_pet;

public class OrganicCat extends OrganicPet {
    protected String type;
    public OrganicCat(String name, int age, String color, String breed) {
        super(name, age, color, breed);
        this.type = "Organic Cat";
    }
    @Override
    public String getType() {
        return type;
    }
    @Override
    public String makePetNoise() {
        return "Meow, Meow";
    }

    @Override
    public void currentStats() {
        super.currentStats();
        System.out.println("Litter-Box Cleanliness: (" + dwellingArea + ")");
    }
}
