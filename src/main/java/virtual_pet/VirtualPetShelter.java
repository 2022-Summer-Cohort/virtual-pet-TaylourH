package virtual_pet;

import java.util.ArrayList;

public class VirtualPetShelter {
    ArrayList<VirtualPet> shelter;

    public VirtualPetShelter() {
        this.shelter = new ArrayList<>();

        shelter.add(new OrganicDog("Jupiter", 4, "black", "collie"));
        shelter.add(new RoboDog("Gizmo", 2, "green", "stainless steel"));
        shelter.add(new OrganicCat("Fluffs", 6, "tan", "tabby"));
        shelter.add(new RoboCat("Zeus", 1, "blue", "aluminum"));
    }

    public void admitPet(VirtualPet pet) {
        shelter.add(pet);
    }

    public void adoptPet(String name) {
        shelter.remove(findPetByName(name));
    }

    public VirtualPet findPetByName(String name) {
        for (VirtualPet pet : shelter) {
            if (pet.getName().equalsIgnoreCase(name)) {
                return pet;
            }
        }
        return null;
    }

    public void showAllPetsStats() {
        for (VirtualPet pet : shelter) {
            pet.currentStats();
        }
    }
    public void shelterPetsDeathCheckAndRemoval() {
        ArrayList<VirtualPet> petsToRemove = new ArrayList<>();
        for (VirtualPet pet : shelter) {
            if (pet.deadCheck()) {
                petsToRemove.add(pet);
            }
        }
        shelter.removeAll(petsToRemove);
    }

    public void shelterOverview() {
        System.out.println("There are currently " + shelter.size() + " pets in the shelter.");
    }

    public int aliveShelterPets() {
        return shelter.size();
    }

    public void listShelterPets() {
        System.out.print("Shelter list: ");
        String output = "";
        for (VirtualPet pet : shelter) {
            output += "(" + pet.getType() + "): " + pet.getName() + ", ";
        }
        output = output.substring(0,output.length()-2);
        System.out.println(output + " ");
    }

    public void allPetIntros() {
        for (VirtualPet pet : shelter) {
            pet.intro();
        }
    }

    public void allPetsStatDeplete() {
        for (VirtualPet pet : shelter) {
            pet.statsDepleteTick();
        }
    }

    public void statsAllPetsHandleOwnNeedsTick() {
        for (VirtualPet pet : shelter) {
            pet.petTakesCareOfOwnNeedsTick();
        }
    }

    public void allPlay() {
        for (VirtualPet pet : shelter) {
            pet.play();
        }
    }

    public void allWalk() {
        for (VirtualPet pet : shelter) {
            pet.walk();
        }
    }

    public void allGiveBath() {
        for (VirtualPet pet : shelter) {
            pet.giveBath();
        }
    }

    public void cleanAllDwellingAreas() {
        for (VirtualPet pet : shelter) {
            if (pet instanceof OrganicPet) {
                ((OrganicPet) pet).cleanPetArea();
            }
        }
    }

    public void allReplenish() {
        for (VirtualPet pet : shelter) {
            if (pet instanceof OrganicPet) {
                ((OrganicPet) pet).feed();
            } else if (pet instanceof RoboPet) {
                ((RoboPet) pet).recharge();
            }
        }
    }

    public void allRefillLiquids() {
        for (VirtualPet pet : shelter) {
            if (pet instanceof OrganicPet) {
                ((OrganicPet) pet).giveWater();
            } else if (pet instanceof RoboPet) {
                ((RoboPet) pet).changeOil();
            }
        }
    }

    public void allKill() {
        for (VirtualPet pet : shelter) {
            if (pet instanceof OrganicPet) {
                ((OrganicPet) pet).euthanize();
            } else if (pet instanceof RoboPet) {
                ((RoboPet) pet).runOverWithCar();
            }
        }
    }

    public void allTreat() {
        for (VirtualPet pet : shelter) {
            if (pet instanceof OrganicPet) {
                ((OrganicPet) pet).treat();
            } else if (pet instanceof RoboPet) {
                ((RoboPet) pet).downloadUpdate();
            }
        }
    }

    public void giveAttention() {
        for (VirtualPet pet : shelter) {
            if (pet instanceof OrganicPet) {
                ((OrganicPet) pet).cuddle();
            } else if (pet instanceof RoboPet) {
                ((RoboPet) pet).performMaintenance();
            }
        }
    }

    public void allInternalNeeds() {
        for (VirtualPet pet : shelter) {
            if (pet instanceof OrganicPet) {
                ((OrganicPet) pet).train();
            } else if (pet instanceof RoboPet) {
                ((RoboPet) pet).downloadUpdate();
            }
        }
    }
    public void twoPetsPlay(String name1, String name2) {
        for (VirtualPet pet : shelter) {
            if (pet.getName().equalsIgnoreCase(name1) || pet.getName().equalsIgnoreCase(name2)) {
                pet.play();
            }
        }
        System.out.println(name1 + " played with " + name2 + "! They had a blast!");
    }
    public void allGiveRandomTrivia() {
        for (VirtualPet pet : shelter) {
            pet.giveRandomTrivia();
        }
    }

    public void allGiveSongSuggestion() {
        for (VirtualPet pet : shelter) {
            pet.giveSongSuggestion();
        }
    }

    public void allGiveMovieSuggestion() {
        for (VirtualPet pet : shelter) {
            pet.giveMovieSuggestion();
        }
    }

    public void allGiveTvShowSuggestion() {
        for (VirtualPet pet : shelter) {
            pet.giveTvShowSuggestion();
        }
    }

    public void allGiveFoodSuggestion() {
        for (VirtualPet pet : shelter) {
            pet.giveFoodSuggestion();
        }
    }

    public void allGiveBookSuggestion() {
        for (VirtualPet pet : shelter) {
            pet.giveBookSuggestion();
        }
    }

    public void allGiveRandomQuote() {
        for (VirtualPet pet : shelter) {
            pet.giveRandomQuote();
        }
    }

    public void allTellJoke() {
        for (VirtualPet pet : shelter) {
            pet.tellJoke();
        }
    }
}
