package pe.edu.examen.backoffice_final.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


import java.util.Date;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer carId;
    private String make;
    private String model;
    private Integer year;
    private String vin;
    private String license_plate;
    private String owner_name;
    private String owner_contact;
    private Date purchase_date;
    private Integer mileage;
    private String engine_type;
    private String color;
    private String insurance_company;
    private String  insurance_policy_number;
    private Date registration_expiration_date;
    private Date service_due_date;

    public Car() {
    }

    public Car(Integer carId, String make, String model, Integer year, String vin, String license_plate, String owner_name,
               String owner_contact, Date purchase_date, Integer mileage, String engine_type, String color, String insurance_company,
               String insurance_policy_number, Date registration_expiration_date, Date service_due_date) {
        this.carId = carId;
        this.make = make;
        this.model = model;
        this.year = year;
        this.vin = vin;
        this.license_plate = license_plate;
        this.owner_name = owner_name;
        this.owner_contact = owner_contact;
        this.purchase_date = purchase_date;
        this.mileage = mileage;
        this.engine_type = engine_type;
        this.color = color;
        this.insurance_company = insurance_company;
        this.insurance_policy_number = insurance_policy_number;
        this.registration_expiration_date = registration_expiration_date;
        this.service_due_date = service_due_date;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getLicense_plate() {
        return license_plate;
    }

    public void setLicense_plate(String license_plate) {
        this.license_plate = license_plate;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public String getOwner_contact() {
        return owner_contact;
    }

    public void setOwner_contact(String owner_contact) {
        this.owner_contact = owner_contact;
    }

    public Date getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(Date purchase_date) {
        this.purchase_date = purchase_date;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public String getEngine_type() {
        return engine_type;
    }

    public void setEngine_type(String engine_type) {
        this.engine_type = engine_type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getInsurance_company() {
        return insurance_company;
    }

    public void setInsurance_company(String insurance_company) {
        this.insurance_company = insurance_company;
    }

    public String getInsurance_policy_number() {
        return insurance_policy_number;
    }

    public void setInsurance_policy_number(String insurance_policy_number) {
        this.insurance_policy_number = insurance_policy_number;
    }

    public Date getRegistration_expiration_date() {
        return registration_expiration_date;
    }

    public void setRegistration_expiration_date(Date registration_expiration_date) {
        this.registration_expiration_date = registration_expiration_date;
    }

    public Date getService_due_date() {
        return service_due_date;
    }

    public void setService_due_date(Date service_due_date) {
        this.service_due_date = service_due_date;
    }
}
