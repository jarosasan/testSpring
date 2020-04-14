package lt.bit.controller;


import lt.bit.model.Plant;
import lt.bit.services.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PlantController {

    @Autowired
    private PlantService plantService;

    @GetMapping("/")
    public ModelAndView allPlants(){
        ModelAndView mav = new ModelAndView("index");
        List<Plant> plants = plantService.allPlants();
        mav.addObject("plants", plants);
        return mav;
    }


    @GetMapping("/add")
    public String createPlant(Model model){
        model.addAttribute("plant", new Plant());
        return "plantForm";
    }

    @PostMapping("/add")
    public ModelAndView addPlant(@ModelAttribute("plant") Plant plant, @RequestParam String descript, BindingResult result){
        ModelAndView mav = new ModelAndView();

        if (result.hasErrors()){
            mav.setViewName("plantForm");
            return mav;
        }

        plantService.addPlant(plant, descript);
        mav.setViewName("redirect:/");
        return mav;
    }

    @GetMapping("/edit/{id}")
    public String editPlant(Model model, @PathVariable("id") Integer id){
        Plant plant = plantService.getOne(id);
        model.addAttribute("plant", plant);
        return "plantForm";
    }

    @PostMapping("/edit")
    public ModelAndView updatePlant(@ModelAttribute("plant") Plant plant, @RequestParam String descript, BindingResult result){
        ModelAndView mav = new ModelAndView();

        if (result.hasErrors()){
            mav.setViewName("plantForm");
            return mav;
        }

        plantService.addPlant(plant, descript);
        mav.setViewName("redirect:/");
        return mav;
    }

    @PostMapping("/remove/{id}")
    public ModelAndView removePlant(@PathVariable("id") Integer id){
        ModelAndView mav = new ModelAndView();
        Plant plant = plantService.getOne(id);
        plantService.deletePlant(plant);
        mav.setViewName("redirect:/");
        return mav;
    }


}
