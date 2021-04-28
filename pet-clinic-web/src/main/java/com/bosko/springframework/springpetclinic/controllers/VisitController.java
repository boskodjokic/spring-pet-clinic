package com.bosko.springframework.springpetclinic.controllers;

import com.bosko.springframework.springpetclinic.model.Pet;
import com.bosko.springframework.springpetclinic.model.Visit;
import com.bosko.springframework.springpetclinic.services.PetService;
import com.bosko.springframework.springpetclinic.services.VisitService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class VisitController {

    private final VisitService visitService;
    private final PetService petService;

    public VisitController(VisitService visitService, PetService petService) {
        this.visitService = visitService;
        this.petService = petService;
    }

    @InitBinder
    public void dataBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");

//        dataBinder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
//
//            @Override
//            public void setAsText(String text) throws IllegalArgumentException {
//                setValue(LocalDate.parse(text));
//            }
//        });
    }

    @ModelAttribute
    public Visit loadPetWithVisit(@PathVariable Long petId, Map<String, Object>model) {
        Pet pet = petService.findById(petId);
        model.put("pet", pet);
        Visit visit = new Visit();
        pet.getVisits().add(visit);
        visit.setPet(pet);
        return visit;
    }

    @GetMapping("/owners/*/pets/{petId}/visits/new")
    public String initNewVisitForm(@PathVariable Long petId, Map<String, Object> model) {
        return "pets/createOrUpdateVisitForm";
    }

    @PostMapping("owners/{ownerId}/pets/{petId}/visits/new")
    public String processNewVisitForm(@Validated Visit visit, BindingResult result) {
        if(result.hasErrors()) {
            return "pets/createOrUpdateVisitForm";
        } else {
            visitService.save(visit);
            return "redirect:/owners/{ownerId}";
        }
    }
}

