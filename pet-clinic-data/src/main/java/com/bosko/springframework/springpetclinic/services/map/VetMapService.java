package com.bosko.springframework.springpetclinic.services.map;

import com.bosko.springframework.springpetclinic.model.Speciality;
import com.bosko.springframework.springpetclinic.model.Vet;
import com.bosko.springframework.springpetclinic.services.SpecialityService;
import com.bosko.springframework.springpetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialityService specialityService;

    public VetMapService(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {

        if(object.getSpecialities().size() > 0) {
            object.getSpecialities().forEach(speciality -> {
                if(speciality.getId() == null) {
                    Speciality savedSpecialty = specialityService.save(speciality);
                    speciality.setId(savedSpecialty.getId());
                }
            });
        }
        return super.save(object);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}