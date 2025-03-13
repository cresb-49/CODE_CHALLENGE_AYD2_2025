package cresb.codeChallengue.repository;

import cresb.codeChallengue.model.Driver;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DriverRepository extends CrudRepository<Driver, Integer> {
    List<Driver> findAll();
    
    Driver save(Driver driver);
    Driver findByName(String name);
    Driver findById(Long id);
}
