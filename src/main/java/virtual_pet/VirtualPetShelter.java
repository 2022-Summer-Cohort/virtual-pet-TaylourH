package virtual_pet;

import java.util.ArrayList;


public class VirtualPetShelter {
    ArrayList<Dog> shelter;
    public VirtualPetShelter() {
        this.shelter = new ArrayList<>();

    }

    public void addPet(Dog dog) {
        shelter.add(dog);
    }

    public void adoptPet(String name){
        shelter.remove(findDogByName(name));
    }

    public void allDogIntros(){
        for(Dog dog:shelter){
        dog.dogIntro();
        }
    }

    public Dog findDogByName(String name){
        for(Dog dog:shelter){
            if(dog.getName().equalsIgnoreCase(name)){
                return dog;
            }
        }
        return null;
    }
    public void showAllPetStats() {
        for(Dog dog:shelter){
            dog.dogCurrentStats();
        }
    }
    public void feedAll(){
        for(Dog dog:shelter){
            dog.feed();
        }
    }

    public void feedOne(String name){
        for(Dog dog:shelter){
            if(dog.getName().equalsIgnoreCase(name)){
                dog.feed();
            }
        }
    }
    public void giveWaterToAll(){
        for(Dog dog:shelter){
            dog.giveWater();
        }
    }
    public void playWithAll(){
        for(Dog dog:shelter){
            dog.play();
        }
    }
    public void walkAll(){
        for(Dog dog:shelter){
            dog.walk();
        }
    }
    public void batheAll(){
        for(Dog dog:shelter){
            dog.giveBath();
        }
    }
    public boolean allPetsAlive() {
        for(Dog dog:shelter){
            if(!dog.isAlive()){
                return false;
            }
        }
        return true;
    }

    public void allPetsStatDepleteTick() {
        for(Dog dog:shelter){
            dog.statDepleteTick();
        }
    }

    public void statsAllPetHandlesOwnNeedsTick() {
        for(Dog dog:shelter){
            dog.statPetHandlesOwnNeedsTick();
        }
    }
}
