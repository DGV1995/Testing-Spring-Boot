package diegogarciaviana.unit5.controllers;

import diegogarciaviana.unit5.fauxspring.Model;
import diegogarciaviana.unit5.services.VetService;

public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    public String listVets(Model model){

        model.addAttribute("vets", vetService.findAll());

        return "vets/index";
    }
}
