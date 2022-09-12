package Classes;

import java.io.Serializable;

public  class Animal implements Serializable {
   private String BreedName;
   private String Petname;
   private String Age;
   private String Foodhabit;
   private String type;
   private  String owner;
   private String AnimalPic;


    public String getAnimalPic() {
        return AnimalPic;
    }

    public void setAnimalPic(String animalPic) {
        AnimalPic = animalPic;
    }


    public String getBreedName() {
        return BreedName;
    }

    public String getPetname() {
        return Petname;
    }

    public String getAge() {
        return Age;
    }

    public String getFoodhabit() {
        return Foodhabit;
    }

    public String getType() {
        return type;
    }

    public void setBreedName(String breedName) {
        BreedName = breedName;
    }

    public void setPetname(String petname) {
        Petname = petname;
    }

    public void setAge(String age) {
        Age = age;
    }

    public void setFoodhabit(String foodhabit) {
        Foodhabit = foodhabit;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Animal(String breedName, String petname, String age, String foodhabit, String type) {
        BreedName = breedName;
        Petname = petname;
        Age = age;
        Foodhabit = foodhabit;
        this.type = type;
    }
    public Animal(String breedName, String petname, String age, String foodhabit, String type,String owner){
        this(breedName,petname,age,foodhabit,type);
        this.owner=owner;
    }
    public Animal(String breedName, String petname, String age, String foodhabit, String type,String owner,String AnimalPic){
        this(breedName,petname,age,foodhabit,type,owner);
        this.AnimalPic=AnimalPic;


    }
}
