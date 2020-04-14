package lt.bit.services;

import lt.bit.model.Plant;

import java.util.List;

public interface PlantService {
    public List<Plant> allPlants();
    public void addPlant(Plant plant, String description);
    public void updatePlant(Plant plant, String description);
    public void deletePlant(Plant plant);
    public Plant getOne(Integer id);
}
