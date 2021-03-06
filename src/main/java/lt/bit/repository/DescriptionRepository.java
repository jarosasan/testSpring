package lt.bit.repository;

import lt.bit.model.Description;
import lt.bit.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DescriptionRepository extends JpaRepository<Description, Integer>, JpaSpecificationExecutor<Description> {
 Description findAllByPlant(Plant p);
}