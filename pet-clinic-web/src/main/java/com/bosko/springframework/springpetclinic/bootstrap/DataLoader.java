package com.bosko.springframework.springpetclinic.bootstrap;

import com.bosko.springframework.springpetclinic.model.Owner;
import com.bosko.springframework.springpetclinic.model.PetType;
import com.bosko.springframework.springpetclinic.model.Vet;
import com.bosko.springframework.springpetclinic.services.OwnerService;
import com.bosko.springframework.springpetclinic.services.PetTypeService;
import com.bosko.springframework.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Bosko");
        owner1.setLastName("Djokic");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Ivana");
        owner2.setLastName("Djokic");

        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Kosta");
        vet1.setLastName("Djokic");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Klara");
        vet2.setLastName("Djokic");

        vetService.save(vet2);

        System.out.println("Loaded vets...");


    }
}
