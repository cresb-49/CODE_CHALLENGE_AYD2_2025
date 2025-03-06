package cresb.codeChallengue.service;

import cresb.codeChallengue.model.Driver;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cresb.codeChallengue.repository.DriverRepository;

@Service
public class DriverService {
    @Autowired
    DriverRepository driverRepository;

    public Driver createDriver(Driver driver) {
        if (driverRepository.findByName(driver.getName()) != null) {
            throw new RuntimeException("Driver with name " + driver.getName() + " already exists");
        }
        return driverRepository.save(driver);
    }

    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

}
