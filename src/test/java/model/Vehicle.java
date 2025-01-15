package model;

public class Vehicle {
    private String registrationNumber;
    private String makeModel;
    private String year;

    public Vehicle(String registrationNumber, String makeModel, String year) {
        this.registrationNumber = registrationNumber;
        this.makeModel = makeModel;
        this.year = year;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public String getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "registrationNumber='" + registrationNumber + '\'' +
                ", makeModel='" + makeModel + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
