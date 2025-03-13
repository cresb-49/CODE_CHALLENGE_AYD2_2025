package cresb.codeChallengue.service;

import cresb.codeChallengue.dto.DriverDTO;
import cresb.codeChallengue.exception.DriverAlreadyExists;
import cresb.codeChallengue.exception.DriverNotExists;
import cresb.codeChallengue.model.Driver;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cresb.codeChallengue.repository.DriverRepository;

@Service
public class DriverService {

    @Autowired
    DriverRepository driverRepository;

    public Driver createDriver(Driver driver) throws DriverAlreadyExists {
        if (driverRepository.existsByName(driver.getName())) {
            throw new DriverAlreadyExists(driver.getName());
        }
        return driverRepository.save(driver);
    }

    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    public Driver updateDriver(Long id, DriverDTO driverDTO) {
        Driver driver = driverRepository.findById(id);
        if (driver == null) {
            throw new DriverNotExists("Driver with id " + id + " not found");
        }
        if (driverRepository.existsByName(driverDTO.getName())) {
            throw new DriverAlreadyExists(driverDTO.getName());
        }
        driver.update(driverDTO);
        return driverRepository.save(driver);
    }

    public void deleteDriver(Long id) {
        Driver driver = driverRepository.findById(id);
        if (driver == null) {
            throw new DriverNotExists("Driver with id " + id + " not found");
        }
        driverRepository.delete(driver);
    }

}
