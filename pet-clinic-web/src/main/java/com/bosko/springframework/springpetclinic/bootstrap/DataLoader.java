package com.bosko.springframework.springpetclinic.bootstrap;

import com.bosko.springframework.springpetclinic.model.Owner;
import com.bosko.springframework.springpetclinic.model.Vet;
import com.bosko.springframework.springpetclinic.services.OwnerService;
import com.bosko.springframework.springpetclinic.services.VetService;
import com.bosko.springframework.springpetclinic.services.map.OwnerServiceMap;
import com.bosko.springframework.springpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Bosko");
        owner1.setLastName("Djokic");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Ivana");
        owner2.setLastName("Djokic");

        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Kosta");
        vet1.setLastName("Djokic");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Klara");
        vet2.setLastName("Djokic");

        vetService.save(vet2);

        System.out.println("Loaded vets...");


    }
}
