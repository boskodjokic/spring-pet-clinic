package com.bosko.springframework.springpetclinic.services;

import com.bosko.springframework.springpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
