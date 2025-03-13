package cresb.codeChallengue.service;

import cresb.codeChallengue.dto.DriverDTO;
import cresb.codeChallengue.model.Driver;
import cresb.codeChallengue.repository.DriverRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class DriverServiceTest {

    @InjectMocks
    private DriverService driverService;

    @Mock
    private DriverRepository driverRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateDriver() {
        Driver driver = new Driver("John Doe", 30);
        when(driverRepository.save(driver)).thenReturn(driver);

        Driver createdDriver = driverService.createDriver(driver);

        assertEquals(driver, createdDriver);
        verify(driverRepository, times(1)).save(driver);
    }

    @Test
    public void testCreateDriverAlreadyExists() {
        Driver driver = new Driver("John Doe", 30);
        when(driverRepository.findByName(driver.getName())).thenReturn(driver);

        assertThrows(RuntimeException.class, () -> {
            driverService.createDriver(driver);
        });

        verify(driverRepository, times(0)).save(driver);
    }

    @Test
    public void testGetAllDrivers() {
        List<Driver> drivers = Arrays.asList(new Driver("John Doe", 30), new Driver("Jane Doe", 25));
        when(driverRepository.findAll()).thenReturn(drivers);

        List<Driver> result = driverService.getAllDrivers();

        assertEquals(drivers, result);
        verify(driverRepository, times(1)).findAll();
    }

    @Test
    public void testUpdateDriver() {
        Driver driver = new Driver("John Doe", 30);
        Driver updatedDriver = new Driver("Sara Conor", 31);
        when(driverRepository.findById(1L)).thenReturn(driver);
        when(driverRepository.save(driver)).thenReturn(updatedDriver);

        Driver result = driverService.updateDriver(1L, new DriverDTO("Sara Conor", 31));

        assertEquals(updatedDriver, result);
        verify(driverRepository, times(1)).findById(1L);
        verify(driverRepository, times(1)).save(driver);
    }

    @Test
    public void testUpdateDriverNotFound() {
        when(driverRepository.findById(1L)).thenReturn(null);

        assertThrows(RuntimeException.class, () -> {
            driverService.updateDriver(1L, new DriverDTO("Sara Conor", 31));
        });

        verify(driverRepository, times(1)).findById(1L);
        verify(driverRepository, times(0)).save(any(Driver.class));
    }

    @Test
    public void testDeleteDriver() {
        Driver driver = new Driver("John Doe", 30);
        when(driverRepository.findById(1L)).thenReturn(driver);

        driverService.deleteDriver(1L);

        verify(driverRepository, times(1)).findById(1L);
        verify(driverRepository, times(1)).delete(driver);
    }
}