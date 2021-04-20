package com.bosko.springframework.springpetclinic.bootstrap;

import com.bosko.springframework.springpetclinic.model.*;
import com.bosko.springframework.springpetclinic.services.OwnerService;
import com.bosko.springframework.springpetclinic.services.PetTypeService;
import com.bosko.springframework.springpetclinic.services.SpecialityService;
import com.bosko.springframework.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService,
                      PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if(count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Bosko");
        owner1.setLastName("Djokic");
        owner1.setAddress("Dragoslava Srejovica");
        owner1.setCity("Beograd");
        owner1.setTelephone("12312325");

        Pet boskosPet = new Pet();
        boskosPet.setPetType(savedDogPetType);
        boskosPet.setOwner(owner1);
        boskosPet.setBirthDate(LocalDate.now());
        boskosPet.setName("Crnjo");
        owner1.getPets().add(boskosPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Ivana");
        owner2.setLastName("Djokic");
        owner2.setAddress("Dragoslava Srejovica");
        owner2.setCity("Beograd");
        owner2.setTelephone("98745685");

        Pet ivanasPet = new Pet();
        ivanasPet.setName("Mjau Mjau");
        ivanasPet.setOwner(owner2);
        ivanasPet.setBirthDate(LocalDate.now());
        ivanasPet.setPetType(savedCatPetType);
        owner2.getPets().add(ivanasPet);

        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Kosta");
        vet1.setLastName("Djokic");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Klara");
        vet2.setLastName("Djokic");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded vets...");
    }
}
