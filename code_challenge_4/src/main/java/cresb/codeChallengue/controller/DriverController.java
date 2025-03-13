package cresb.codeChallengue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.model.processor.PhaseIndicator;
import cresb.codeChallengue.dto.DriverDTO;
import cresb.codeChallengue.model.Driver;
import cresb.codeChallengue.service.DriverService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/api/driver")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @GetMapping("/all")
    public ResponseEntity<List<Driver>> getAllDrivers() {
        List<Driver> drivers = driverService.getAllDrivers();
        return ResponseEntity.ok(drivers);
    }

    @PostMapping()
    public ResponseEntity<Driver> createDriver(@RequestBody DriverDTO driverDTO) {
        Driver driver = new Driver(driverDTO.getName(), driverDTO.getAge());
        Driver createdDriver = driverService.createDriver(driver);
        return ResponseEntity.ok(createdDriver);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Driver> updateDriver(@PathVariable Long id,@RequestBody DriverDTO driverDTO) {
        Driver updatedDriver = driverService.updateDriver(id, driverDTO);
        return ResponseEntity.ok(updatedDriver);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDriver(@PathVariable Long id) {
        driverService.deleteDriver(id);
        return ResponseEntity.ok().build();
    }
}