package com.bosko.springframework.springpetclinic.repositories;

import com.bosko.springframework.springpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
