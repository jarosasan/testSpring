package lt.bit.services;

import lt.bit.model.Plant;
import lt.bit.repository.PlantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlantServiceImpl implements PlantService {
    @Autowired
    private PlantsRepository plantsRepository;

    @Override
    @Transactional
    public List<Plant> allPlants() {
        return plantsRepository.findAll();
    }

    @Override
    public void addPlant(Plant plant) {
        plantsRepository.save(plant);
    }

    @Override
    public void updatePlant(Plant plant) {
        plantsRepository.save(plant);

    }

    @Override
    public void deletePlant(Plant plant) {
        plantsRepository.delete(plant);
    }

    @Override
    public Plant getOne(Integer id) {
        return plantsRepository.getOne(id);
    }
}
