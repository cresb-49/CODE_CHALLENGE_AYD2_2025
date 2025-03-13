package cresb.codeChallengue.model;

import cresb.codeChallengue.dto.DriverDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "driver")
public class Driver {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "age")
    private int age;

    public Driver(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Driver(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Driver() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void update(DriverDTO driverDTO) {
        if (driverDTO.getName() != null) {
            this.name = driverDTO.getName();
        }
        if (driverDTO.getAge() != null) {
            this.age = driverDTO.getAge();
        }
    }
}
