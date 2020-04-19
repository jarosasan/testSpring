package lt.bit.services;

import lt.bit.model.Description;
import lt.bit.model.Plant;

import java.util.List;

public interface PlantService {
    public List<Plant> allPlants();
    public void addPlant(Plant plant, Description description);
    public void updatePlant(Plant plant, Description description);
    public void deletePlant(Plant plant);
    public Plant getOne(Integer id);
}
