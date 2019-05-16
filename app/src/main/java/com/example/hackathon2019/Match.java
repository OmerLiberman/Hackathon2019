package com.example.hackathon2019;

public class Match {

    Animal animal;
    User user;

    public boolean allergyMatch()
    {
        //return true if not allergic or not allergic to this animal.
        return !(user.questionnaire.allergies && user.questionnaire.allergiesKind == animal.animalType);
    }

    public boolean otherAnimalsMatch()
    {
        //return true if its ok
        return (user.questionnaire.anotherAnimal == animal.suitableForMoreAnimals);
    }

    public double residenceMatch() {
        if (animal.animalType.equals("dog") || animal.animalType.equals("cat")) {
            //0 - garden, 1- first_floor, 2-high_floor
            if (user.house == 0 || animal.suitableForApartment == 0) {
                return 40;
            } else {
                if (animal.suitableForApartment == 2) {
                    return 0;
                } else {
                    if (animal.animalType.equals("cat")) {
                        if (user.house == 1) {
                            helpResidenceMatch(0, 0);
                        } else {
                            helpResidenceMatch(0, 5);
                        }
                    } else {
                        if (user.house == 1) {
                            helpResidenceMatch(5, 0);
                        } else {
                            helpResidenceMatch(5, 5);
                        }
                    }
                }
            }
    }


    private double helpResidenceMatch(int factor, int floor) {
        if (user.workStatuse == 0) {
            return 35 - factor - floor;
        } else if (user.workStatuse == 1) {
            if (user.animalFriendly) {
                return 35 - factor - floor;
            } else {
                return 25 - factor - floor;
            }
        } else {
            if (user.animalFriendly) {
                return 25 - factor - floor;
            } else {
                return 15 - factor - floor;
            }
        }
    }

}
