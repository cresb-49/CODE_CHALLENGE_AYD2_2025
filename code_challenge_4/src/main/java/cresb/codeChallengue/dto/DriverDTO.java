package cresb.codeChallengue.dto;

public class DriverDTO {
    private String name;
    private Integer age;

    public DriverDTO() {
    }

    public DriverDTO(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}