package virtual_pet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DogTest {

    @Test
    public void shouldIncreaseHungerLevelByFive() {
        Dog underTest = new Dog("Max","Brown","Boxer",0,0,0,0,0);
        underTest.feed();
        assertEquals(5, 5);
    }
    @Test
    public void shouldIncreaseThirstLevelByFive() {
        Dog underTest = new Dog("Max","Brown","Boxer",0,0,0,0,0);
        underTest.giveWater();
        assertEquals(5, 5);
    }
    @Test
    public void shouldIncreaseNeedsBathLevelByFive() {
        Dog underTest = new Dog("Max","Brown","Boxer",0,0,0,0,0);
        underTest.giveBath();
        assertEquals(5, 5);
    }
    @Test
    public void shouldDecreaseAllDogStatsByFive() {
        Dog underTest = new Dog("Max","Brown","Boxer",10,10,10,10,10);
        underTest.tick();
        assertEquals(5, 5);
    }
}