package cresb.codeChallengue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cresb.codeChallengue.model.Driver;
import cresb.codeChallengue.service.DriverService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/driver")
public class DriverController {
    
    @Autowired
    private DriverService driverService;

    @GetMapping("/all")
    public String getAllDrivers() {
        return driverService.getAllDrivers().toString();
    }

    @GetMapping("/create")
    public String createDriver(@RequestParam String name, @RequestParam int age) {
        Driver driver = new Driver(name, age);
        return driverService.createDriver(driver).toString();
    }
    
    
}
