package com.bosko.springframework.springpetclinic.repositories;

import com.bosko.springframework.springpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
