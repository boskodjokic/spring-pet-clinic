package com.bosko.springframework.springpetclinic.repositories;

import com.bosko.springframework.springpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
