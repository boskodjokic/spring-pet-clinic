package com.bosko.springframework.springpetclinic.repositories;

import com.bosko.springframework.springpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
