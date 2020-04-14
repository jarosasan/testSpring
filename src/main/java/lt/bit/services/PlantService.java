package lt.bit.services;

import lt.bit.model.Plant;

import java.util.List;

public interface PlantService {
    public List<Plant> allPlants();
    public void addPlant(Plant plant);
    public void updatePlant(Plant plant);
    public void deletePlant(Plant plant);
    public Plant getOne(Integer id);
}
