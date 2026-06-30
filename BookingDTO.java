package com.renukamata.booking.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BookingDTO {

    private Long id;
    private String customerName;
    private String mobileNumber;
    private String fromLocation;
    private String toLocation;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate travelDate;

    private Integer numberOfPassengers;
    private String vehicleType;
    private String message;
    private String status;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    // --- Getters & Setters ---

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getMobileNumber() { return mobileNumber; }
    public void setMobileNumber(String mobileNumber) { this.mobileNumber = mobileNumber; }

    public String getFromLocation() { return fromLocation; }
    public void setFromLocation(String fromLocation) { this.fromLocation = fromLocation; }

    public String getToLocation() { return toLocation; }
    public void setToLocation(String toLocation) { this.toLocation = toLocation; }

    public LocalDate getTravelDate() { return travelDate; }
    public void setTravelDate(LocalDate travelDate) { this.travelDate = travelDate; }

    public Integer getNumberOfPassengers() { return numberOfPassengers; }
    public void setNumberOfPassengers(Integer numberOfPassengers) { this.numberOfPassengers = numberOfPassengers; }

    public String getVehicleType() { return vehicleType; }
    public void setVehicleType(String vehicleType) { this.vehicleType = vehicleType; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
