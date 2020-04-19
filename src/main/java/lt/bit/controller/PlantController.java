package lt.bit.controller;


import lt.bit.model.Description;
import lt.bit.model.Plant;
import lt.bit.repository.DescriptionRepository;
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

    @Autowired
    private DescriptionRepository descriptionRepository;

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
        model.addAttribute("description", new Description());
        return "plantForm";
    }

    @PostMapping("/add")
    public ModelAndView addPlant(@ModelAttribute("description") Description description, @ModelAttribute("plant") Plant plant,  BindingResult result){
        ModelAndView mav = new ModelAndView();
        if (result.hasErrors()){
            mav.setViewName("plantForm");
            return mav;
        }
        plantService.addPlant(plant, description);
        mav.setViewName("redirect:/");
        return mav;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editPlant( @PathVariable("id") Integer id){
        ModelAndView mav = new ModelAndView("plantForm");
        Plant plant = plantService.getOne(id);
        mav.addObject("plant", plant);
        mav.addObject("description", plant.getDescription() !=null?plant.getDescription():new Description());
        return mav;
    }

    @PostMapping("/edit")
    public ModelAndView updatePlant(@ModelAttribute("plant") Plant plant, @ModelAttribute("description") Description description, BindingResult result){
        ModelAndView mav = new ModelAndView();

        if (result.hasErrors()){
            mav.setViewName("plantForm");
            return mav;
        }

        plantService.updatePlant(plant, description);
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

    @GetMapping("/description/{id}")
    public ModelAndView getDescription(@PathVariable("id") Integer id){
        ModelAndView mav = new ModelAndView("description");
        Plant plant = plantService.getOne(id);
        mav.addObject("plant", plant);
        System.out.println("=====desc===="+plant.getDescription());
        return mav;
    }


}
