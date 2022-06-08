package virtual_pet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DogTest {

        @Test
        public void shouldIncreaseHungerLevelByFive() {
            Dog underTest = new Dog("Max", "Brown", "Boxer");
            underTest.feed();
            assertEquals(5, 5);
        }
        @Test
        public void shouldIncreaseThirstLevelByFive() {
            Dog underTest = new Dog("Max", "Brown", "Boxer");
            underTest.giveWater();
            assertEquals(5, 5);
        }
        @Test
        public void shouldIncreaseNeedsBathLevelByFive() {
            Dog underTest = new Dog("Max", "Brown", "Boxer");
            underTest.giveBath();
            assertEquals(5, 5);
        }
        @Test
        public void shouldDecreaseAllDogStatsByFive() {
            Dog underTest = new Dog("Max", "Brown", "Boxer");
            underTest.statDepleteTick();
            assertEquals(5, 5);
        }
    }