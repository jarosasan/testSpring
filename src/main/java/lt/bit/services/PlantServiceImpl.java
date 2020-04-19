package lt.bit.services;

import com.google.protobuf.Descriptors.Descriptor;
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
    public void addPlant(Plant plant, Description description) {
        Plant p = plantsRepository.save(plant);
        description.setPlant(p);
        descriptionRepository.save(description);

    }

    @Override
    @Transactional
    public void updatePlant(Plant plant, Description description) {
        Plant p = plantsRepository.getOne(plant.getId());
        Description d = p.getDescription();
        if(d != null){
            d.setDescripto(description.getDescripto());
        }else{
            p.setDescription(description);
        }
        p.setName(plant.getName());
        p.setAmount(plant.getAmount());
        p.setPrice(plant.getPrice());
        p.setPlantType(plant.getPlantType());
        plantsRepository.save(p);
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
