package lt.bit.repository;

import lt.bit.model.Description;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DescriptionRepository extends JpaRepository<Description, Integer>, JpaSpecificationExecutor<Description> {

}