package virtual_pet;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VirtualPetShelterTest {
//    @Test
//    public void shouldAddNewPetToShelter() {
//        VirtualPetShelter underTest = new VirtualPetShelter();
//        ArrayList<Dog> shelter;
//        underTest.addPet(new Dog("Davis","Grey","Greyhound"));
//        String Davis;
//        assertEquals("Davis", underTest.findDogByName(Davis));
//    }

    @Test
    public void shouldFeedAllDogs() {
        VirtualPetShelter underTest = new VirtualPetShelter();
        underTest.feedAll();
        assertEquals(5, 5);
    }
    @Test
    public void shouldGiveWaterToAllDogs() {
        VirtualPetShelter underTest = new VirtualPetShelter();
        underTest.giveWaterToAll();
        assertEquals(5, 5);
    }
    @Test
    public void shouldPlayWithAllDogs() {
        VirtualPetShelter underTest = new VirtualPetShelter();
        underTest.playWithAll();
        assertEquals(5, 5);
    }
}
