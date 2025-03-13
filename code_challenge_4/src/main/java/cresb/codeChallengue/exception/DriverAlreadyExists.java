package cresb.codeChallengue.exception;

public class DriverAlreadyExists extends RuntimeException {
    public DriverAlreadyExists(String name) {
        super("Driver with name " + name + " already exists");
    }

}
