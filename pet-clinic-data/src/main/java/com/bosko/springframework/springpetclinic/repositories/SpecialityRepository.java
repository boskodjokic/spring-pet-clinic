package com.bosko.springframework.springpetclinic.repositories;

import com.bosko.springframework.springpetclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
