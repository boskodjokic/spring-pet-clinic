package com.bosko.springframework.springpetclinic.repositories;

import com.bosko.springframework.springpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

}
