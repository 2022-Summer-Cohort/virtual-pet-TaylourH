package virtual_pet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VirtualPetShelterTest {
    @Test
    public void shouldAdmitNewPetToShelter() {
        VirtualPetShelter underTest = new VirtualPetShelter();
        underTest.admitPet(new OrganicDog("Davis",4,"Grey","Greyhound"));
        assertEquals(5,underTest.shelter.size());
    }
    @Test
    public void shouldFindPetByNameFromShelter() {
        VirtualPetShelter underTest = new VirtualPetShelter();
        underTest.findPetByName("gizmo");
        assertEquals("Gizmo",underTest.shelter.get(1).getName());
    }
    @Test
    public void shouldAdoptPetFromShelter() {
        VirtualPetShelter underTest = new VirtualPetShelter();
        underTest.adoptPet("jupiter");
        assertEquals(3,underTest.shelter.size());
    }
}
