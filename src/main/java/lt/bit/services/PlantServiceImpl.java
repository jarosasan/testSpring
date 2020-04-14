package lt.bit.services;

import lt.bit.model.Description;
import lt.bit.model.Plant;
import lt.bit.repository.DescriptionRepository;
import lt.bit.repository.PlantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlantServiceImpl implements PlantService {
    @Autowired
    private PlantsRepository plantsRepository;

    @Autowired
    private DescriptionRepository descriptionRepository;

    @Override
    @Transactional
    public List<Plant> allPlants() {
        return plantsRepository.findAll();
    }

    @Override
    @Transactional
    public void addPlant(Plant plant, String description) {
        Plant p = plantsRepository.save(plant);
        System.out.println(p);
//        Description d = new Description(description, p);
        Description d = new Description();
        d.setDescript(description);
        d.setPlant(p);

            descriptionRepository.save(d);

    }

    @Override
    @Transactional
    public void updatePlant(Plant plant, String description) {
        plantsRepository.save(plant);

    }

    @Override
    @Transactional
    public void deletePlant(Plant plant) {
        plantsRepository.delete(plant);
    }

    @Override
    @Transactional
    public Plant getOne(Integer id) {
        return plantsRepository.getOne(id);
    }
}
