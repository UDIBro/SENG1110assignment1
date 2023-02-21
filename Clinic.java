//student number: C3375424
//student name: Adil Nawaz Malik 

import java.util.*;

public class Clinic 
{
    //all set to null to begin with so i can check they're empty easily
    private Doctor doctor1 = null;
    private Doctor doctor2 = null;
    private Pet pet1 = null;
    private Pet pet2 = null;
    private Pet pet3 = null;
    private Pet pet4 = null;
    
    private void run() 
    {
        int option;
        do
        {
            option = chooseOption();
            switch (option)
            {
                case 1: addDoctor();
                case 2: addPet();
                case 3: removeDoctor();
                case 4: removePet();
                case 5: listDoctor();
                case 6: listPet();
                case 7: listDoctorPets();
                case 8: addDoctor2Pet();
                case 9: analysePet();
                case -1: break;
            }
        }
        while (option!=-1);  
    }
    
    //This method should control the flow of the program
    public static void main(String[] args)
    {
            Clinic clinic = new Clinic();
            clinic.run();
    }
    
    //asks for the option and returns the number
    private int chooseOption()
    {
        Scanner console = new Scanner(System.in);
        System.out.print("------------------------------------------\n"
        + "Welcome to the clinic!\n"
        + "------------------------------------------\n"
        + "Please select from the following options:\n"
        + " 1. Add New Doctor\n"
        + " 2. Add New Pet\n"
        + " 3. Remove Existing Doctor\n"
        + " 4. Remove Existing Pet\n"
        + " 5. List All Doctors\n"
        + " 6. List All Pets\n"
        + " 7. List Of Pets Assigned To Specifc Doctor\n"
        + " 8. Assign Pet To Doctor\n"
        + " 9. Analyse Pet\n"
        );
        int result = console.nextInt(); 
        
        //makes sure that a valid number was selected
        while (result < 1 || result > 9)
        {
            System.out.print("------------------------------------------\n"
            + "ERROR! selection was not valid, please try again!\n"
            );
            result = console.nextInt();
        };
        
        return result;
    }
    
    //adds a doctor if possible
    public void addDoctor()
    {
        Scanner console = new Scanner(System.in);
        String name, specialisation, doc1Name, doc2Name, doc1Spec, doc2Spec;
        //this is just a space saving measure, everything is done to temp and at the end its assigned to either doc1 or doc2
        Doctor temp = new Doctor();
        //declare variables like these are something because otherwise if they dont exist yet string will be set to nothing and java doesnt like that
        doc1Name = "";
        doc2Name = "";
        doc1Spec = "";
        doc2Spec = "";
        boolean i = false;
        
        //selects which doctor is available(if any)
        if (doctor1 == null || doctor2 == null)
        {
            if (doctor1 != null) {
            doc1Name = doctor1.getName();   
            doc1Spec = doctor1.getSpec();
            }
            if (doctor2 != null) {
            doc2Name = doctor2.getName();
            doc2Spec = doctor2.getSpec();
            }
            
            
            System.out.print("------------------------------------------\n"
            + "What is the doctors name?\n");
            name = console.nextLine().toLowerCase();
            name = name.replaceAll(" ", "");
            while(name.equals(doc1Name) || name.equals(doc2Name)){
                System.out.print("ERROR! Another doctor already possess' that name, please try again.\n");
                name = console.nextLine().toLowerCase();
            };
            temp.setName(name);
            
            System.out.print("What is the doctors specialisation?\n");
            specialisation = console.nextLine().toLowerCase();
            while (i != true) {
                if (specialisation.equals("dog")) {
                    i = true;
                } else if (specialisation.equals("cat")) {
                    i = true;
                } else {
                System.out.print("ERROR! Not a valid specialisation!, please try again.\n");
                specialisation = console.nextLine().toLowerCase();    
                };
            };
            i = false;
            
            while(specialisation.equals(doc1Spec) || specialisation.equals(doc2Spec)) {
                System.out.print("ERROR! Another doctor already possess' that specialisaition, please pick another.\n");
                specialisation = console.nextLine().toLowerCase();
            };
            temp.setSpec(specialisation);
            
            //this is where temp is assigned to doc1 or 2
            if (doctor1 == null) { 
                doctor1 = temp;
            } else if (doctor2 == null) {
                doctor2 = temp;
            }
        } else {
            System.out.print("------------------------------------------\n"
            + "Sorry, the maximum amount of doctors has been reached.\n");
        }
        
        run();
    }
    
    //adds a pet if possible
    public void addPet()
    {
        Scanner console = new Scanner(System.in);
        String type, size, name, pet1Name, pet2Name, pet3Name, pet4Name;
        pet1Name = "";
        pet2Name = "";
        pet3Name = "";
        pet4Name = "";

        double weight;
        int age;
        boolean i = false;
        Pet temp = new Pet();
        
        if (pet1 == null || pet2 == null || pet3 == null || pet4 == null)
        {
            if (pet1 != null) {
            pet1Name = pet1.getName();
            }
            if (pet2 != null) {
            pet2Name = pet2.getName();
            }
            if (pet3 != null) {
            pet3Name = pet3.getName();
            }
            if (pet4 != null) {
            pet4Name = pet4.getName();
            }
            
            System.out.print("------------------------------------------\n"
            + "Is it a cat or a dog?\n");
            type = console.nextLine().toLowerCase();
            while (i != true) {
                if (type.equals("dog")) {
                    i = true;
                } else if (type.equals("cat")) {
                    i = true;
                } else {
                System.out.print("ERROR! Not a valid type!, please try again.\n");
                type = console.nextLine();    
                };
            };
            temp.setType(type);
            i = false;
            
            System.out.print("Is your pet small, medium or large?\n");
            size = console.nextLine().toLowerCase();
            while (i != true) {
                if (size.equals("small")) {
                    i = true;
                } else if (size.equals("medium")) {
                    i = true;
                } else if (size.equals("large")) {
                    i = true;
                } else {
                System.out.print("ERROR! Not a valid selection, please try again.\n");
                size = console.nextLine().toLowerCase();  
                };
            };
            temp.setSize(size);
            i = false;
            
            System.out.print("What is your pets name?\n");
            name = console.nextLine().toLowerCase();
            name = name.replaceAll(" ", "");
            while (i != true) {
                if (name.equals(pet1Name)) {
                    System.out.print("ERROR! Name already taken by another pet, try again./n");
                    name = console.nextLine().toLowerCase();
                    name = name.replaceAll(" ", "");
                } else if (name.equals(pet2Name)) {
                    System.out.print("ERROR! Name already taken by another pet, try again./n");
                    name = console.nextLine().toLowerCase();
                    name = name.replaceAll(" ", "");
                } else if (name.equals(pet3Name)) {
                    System.out.print("ERROR! Name already taken by another pet, try again./n");
                    name = console.nextLine().toLowerCase();
                    name = name.replaceAll(" ", "");
                } else if (name.equals(pet4Name)) {
                    System.out.print("ERROR! Name already taken by another pet, try again./n");
                    name = console.nextLine().toLowerCase();
                    name = name.replaceAll(" ", "");
                } else {
                    i = true;
                };
            }
            temp.setName(name);
            i = false;
            
            //might just crash if an invalid input is put in :///
            System.out.print("What is your pets weight?\n");
            weight = console.nextDouble();
            temp.setWeight(weight);
            
            //might just crash if an invalid input is put in :///
            System.out.print("What is your pets age?\n");
            age = console.nextInt();
            temp.setAge(age);
            
            if (pet1 == null)
            {
                pet1 = temp;
            } else if (pet2 == null) {
                pet2 = temp;
            } else if (pet3 == null) {
                pet3 = temp;
            } else {
                pet4 = temp;
            };
            
            
        } else {
            System.out.print("------------------------------------------\n"
            + "Sorry, the maximum amount of pets has been reached.\n");
        }
        run();
    }
    
    public void removeDoctor()
    {
        Scanner console = new Scanner(System.in);
        String name, doc1Name, doc2Name;
        doc1Name = "";
        doc2Name = "";
        Doctor temp = null;
        
        if (doctor1 != null || doctor2 != null)
        {
            if (doctor1 != null) {
            doc1Name = doctor1.getName();
            }
            if (doctor2 != null) {
            doc2Name = doctor2.getName();
            }
            System.out.print("------------------------------------------\n"
            + "Which doctor would you like to remove?\n");
            name = console.nextLine().toLowerCase();
            name = name.replaceAll(" ", "");
            if (name.equals(doc1Name)) {
                removeAssignedDoctor(doctor1.getName());
                doctor1 = temp;
            } else if (name.equals(doc2Name)) {
                removeAssignedDoctor(doctor2.getName());
                doctor2 = temp;
            } else {
                System.out.print("No such doctor found./n");
            }
        } else {
            System.out.print("No doctors found./n");
        }
        run();
    }
    
    public void removeAssignedDoctor(String name)
    {
        if (pet1 != null) {
            if (pet1.getDoctor().equals(name)) {
            pet1.setDoctor("");
            }
        }
   
        if (pet2 != null) {
            if (pet1.getDoctor().equals(name)) {
            pet2.setDoctor("");
            }
        }
        
        if (pet3 != null) {
            if (pet1.getDoctor().equals(name)) {
            pet3.setDoctor("");
            }
        }
        
        if (pet4 != null) {
            if (pet1.getDoctor().equals(name)) {
            pet4.setDoctor("");
            }
        }
    }
    public void removePet()
    {
        Scanner console = new Scanner(System.in);
        String name, pet1Name, pet2Name, pet3Name, pet4Name;
        pet1Name = "";
        pet2Name = "";
        pet3Name = "";
        pet4Name = "";
        Pet temp = null;
        
        if (pet1 != null || pet2 != null || pet3 != null || pet4 != null) {
            if (pet1 != null) {
                pet1Name = pet1.getName();
            }
            if (pet2 != null) {
                pet2Name = pet2.getName();
            }
            if (pet3 != null) {
                pet3Name = pet3.getName();
            }
            if (pet4 != null) {
                pet4Name = pet4.getName();
            }
            
            System.out.print("------------------------------------------\n"
            + "Which pet would you like to remove?\n");
            name = console.nextLine().toLowerCase();
            name = name.replaceAll(" ", "");
            
            if (name.equals(pet1Name)) {
                pet1 = temp;
            } else if (name.equals(pet2Name)) {
                pet2 = temp;
            } else if (name.equals(pet3Name)) {
                pet3 = temp;
            } else if (name.equals(pet4Name)) {
                pet4 = temp;
            } else {
                System.out.print("No such pet found.\n");
            }
        }
        run();
    }
    
    public void listDoctor()
    {
        Scanner console = new Scanner(System.in);
        
        System.out.print("------------------------------------------\n");
        if (doctor1 != null) {
            System.out.print("Doctor "+ doctor1.getName() + ": " + doctor1.getSpec() + " specialist\n");            
        }
        
        if (doctor2 != null) {
            System.out.print("Doctor "+ doctor2.getName() + ": " + doctor2.getSpec() + " specialist\n");  
        }
        
        if (doctor1 == null || doctor2 == null) {
            System.out.print("ERROR! No doctors found, please add some through the menus.\n");
        }
        
        run();
    }
    
    public void listPet()
    {
        Scanner console = new Scanner(System.in);
        
        System.out.print("------------------------------------------\n");
        if (pet1 != null) {
            System.out.print("Pet " + pet1.getName() + ": " + pet1.getSize() + " " + pet1.getType() + " weighing " +  pet1.getWeight() + "kg at " + pet1.getAge() + " years old. (Doctor " + pet1.getDoctor() + ")\n");
        }
        
        if (pet2 != null) {
            System.out.print("Pet " + pet2.getName() + ": " + pet2.getSize() + " " + pet2.getType() + " weighing " +  pet2.getWeight() + "kg at " + pet2.getAge() + " years old. (Doctor " + pet2.getDoctor() + ")\n");
        }
        
        if (pet3 != null) {
            System.out.print("Pet " + pet3.getName() + ": " + pet3.getSize() + " " + pet3.getType() + " weighing " +  pet3.getWeight() + "kg at " + pet3.getAge() + " years old. (Doctor " + pet3.getDoctor() + ")\n");
        }
        
        if (pet4 != null) {
            System.out.print("Pet " + pet4.getName() + ": " + pet4.getSize() + " " + pet4.getType() + " weighing " +  pet4.getWeight() + "kg at " + pet4.getAge() + " years old. (Doctor " + pet4.getDoctor() + ")\n");
        }
        
        if (pet1 == null && pet2 == null && pet3 == null && pet4 == null) {
            System.out.print("ERROR! no pets found, please add some through the menus.\n");
        }
        
        run();
    }
    
    public void listDoctorPets()
    {
        Scanner console = new Scanner(System.in);
        String name, doc1Name, doc2Name;
        doc1Name = "";
        doc2Name = "";
        
        if (doctor1 != null || doctor2 != null)
        {
            if (doctor1 != null) {
            doc1Name = doctor1.getName();
            }
            if (doctor2 != null) {
            doc2Name = doctor2.getName();
            }
            
            System.out.print("------------------------------------------\n"
            + "Which doctors pets would you like listed?\n");
            name = console.nextLine().toLowerCase();
            name = name.replaceAll(" ", "");
        
            while (!name.equals(doc1Name) && !name.equals(doc2Name)) {
                System.out.print("Name not recognised, try again!\n");
                name = console.nextLine().toLowerCase();
                name = name.replaceAll(" ", "");
            }
        
            if (pet1 != null) {
                if (pet1.getDoctor().equals(name)) {
                    System.out.print("Pet " + pet1.getName() + ": " + pet1.getSize() + " " + pet1.getType() + " weighing " +  pet1.getWeight() + "kg at " + pet1.getAge() + " years old. (Doctor " + pet1.getDoctor() + ")\n");
                }
            }
        
            if (pet2 != null) {
                if (pet2.getDoctor().equals(name)) {
                    System.out.print("Pet " + pet2.getName() + ": " + pet2.getSize() + " " + pet2.getType() + " weighing " +  pet2.getWeight() + "kg at " + pet2.getAge() + " years old. (Doctor " + pet2.getDoctor() + ")\n");
                }
            }
        
            if (pet3 != null) {
                if (pet3.getDoctor().equals(name)) {
                    System.out.print("Pet " + pet3.getName() + ": " + pet3.getSize() + " " + pet3.getType() + " weighing " +  pet3.getWeight() + "kg at " + pet3.getAge() + " years old. (Doctor " + pet3.getDoctor() + ")\n");
                }
            }
        
            if (pet4 != null) {
                if (pet4.getDoctor().equals(name)) {
                    System.out.print("Pet " + pet4.getName() + ": " + pet4.getSize() + " " + pet4.getType() + " weighing " +  pet4.getWeight() + "kg at " + pet4.getAge() + " years old. (Doctor " + pet4.getDoctor() + ")\n");
                }
            }
        
            if (pet1 == null || pet2 == null || pet3 == null || pet4 == null) {
                System.out.print("ERROR! no pets found, please add some through the menus.\n");
            }
            
        } else {
            System.out.print("No doctors found, please add some through the menus.\n");
        }
        
        
        
        
        run();
    }
    
    public void addDoctor2Pet()
    {
        Scanner console = new Scanner(System.in);
        String doc, pet, doc1Name, doc2Name;
        
        
        
        System.out.print("------------------------------------------\n"
        + "Which doctor would you like to assign?\n");
        doc = console.nextLine().toLowerCase();
        doc = doc.replaceAll(" ", "");
        
        if (doctor1 != null || doctor2 != null)
        {
            if (doctor1 != null) {
            doc1Name = doctor1.getName();
            }
            if (doctor2 != null) {
            doc2Name = doctor2.getName();
            }
        
            if (doc.equals(doctor1.getName()) || doc.equals(doctor2.getName())) {
                System.out.print("Which pet would you like to assign to?\n");
                pet = console.nextLine().toLowerCase();
                pet = pet.replaceAll(" ", "");
                if (pet1 != null) {
                    if (pet.equals(pet1.getName())) {
                        pet1.setDoctor(doc);   
                    }
                }
                if (pet2 != null) {
                    if (pet.equals(pet2.getName())) {
                        pet2.setDoctor(doc);
                    }
                }
                if (pet3 != null) {
                    if (pet.equals(pet3.getName())) {
                        pet3.setDoctor(doc);
                    }
                }
                if (pet4 != null) {
                    if (pet.equals(pet4.getName())) {
                        pet4.setDoctor(doc);
                    }
                }
                if (pet1 == null || pet2 == null || pet3 == null || pet4 == null){
                   System.out.print("ERROR! No such pet found.\n"); 
                }
            } else {
                System.out.print("ERROR! No such doctor found.\n");
            }
        } else {
            System.out.print("No doctors found, please add some through the menus.\n");
        }
        
        
        run();
    }
    
    public void analysePet()
    {
        Scanner console = new Scanner(System.in);
        String pet;
        
        System.out.print("------------------------------------------\n"
        + "Which pet would you like to analyse?\n");
            pet = console.nextLine().toLowerCase();
            pet = pet.replaceAll(" ", "");
            
        if (pet1 != null) {
            if (pet.equals(pet1.getName())) {
                checkSize(pet1);   
            }
        }
        if (pet2 != null) {
            if (pet.equals(pet2.getName())) {
                checkSize(pet2);
            }
        }
        if (pet3 != null) {
            if (pet.equals(pet3.getName())) {
                checkSize(pet3);
            }
        }
        if (pet4 != null) {
            if (pet.equals(pet4.getName())) {
                checkSize(pet4);
            }
        }
        if (pet1 == null || pet2 == null || pet3 == null || pet4 == null){
            System.out.print("ERROR! No such pet found.\n"); 
        }
        
        
        
        run();
    }
    
    public void checkSize(Pet temp)
    {
        Scanner console = new Scanner(System.in);
        boolean overweight = false;
        
        if (temp.getType() == "dog") {
            if (temp.getSize() == "small") {
                if (temp.getWeight() > 6) {
                    overweight = true;
                }
            } else if (temp.getSize() == "medium") {
                if (temp.getWeight() > 9) {
                    overweight = true;
                }   
            } else if (temp.getSize() == "large") {
                if (temp.getWeight() > 12) {
                    overweight = true;
                }
            }        
        } else if (temp.getType() == "cat") {
            if (temp.getSize() == "small") {
                if (temp.getWeight() > 4) {
                    overweight = true;
                }
            } else if (temp.getSize() == "medium") {
                if (temp.getWeight() > 6) {
                    overweight = true;
                }   
            } else if (temp.getSize() == "large") {
                if (temp.getWeight() > 8) {
                    overweight = true;
                }
            }         
        }
        
        if (overweight == true) {
            System.out.print("Your pet is overweight.\n");   
        } else {
            System.out.print("Your pet is NOT overweight.\n");   
        }
    }
}
