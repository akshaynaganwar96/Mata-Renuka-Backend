package com.renukamata.booking.service;

import com.renukamata.booking.dto.BookingDTO;
import com.renukamata.booking.entity.Booking;
import com.renukamata.booking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    // Save new booking
    public BookingDTO saveBooking(BookingDTO dto) {
        Booking booking = toEntity(dto);
        Booking saved = bookingRepository.save(booking);
        return toDTO(saved);
    }

    // Get all bookings
    public List<BookingDTO> getAllBookings() {
        return bookingRepository.findAllByOrderByCreatedAtDesc()
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    // Get bookings by status
    public List<BookingDTO> getBookingsByStatus(String status) {
        return bookingRepository.findByStatusOrderByCreatedAtDesc(status)
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    // Get booking by ID
    public BookingDTO getBookingById(Long id) {
        Optional<Booking> opt = bookingRepository.findById(id);
        return opt.map(this::toDTO).orElse(null);
    }

    // Update booking status
    public BookingDTO updateStatus(Long id, String status) {
        Optional<Booking> opt = bookingRepository.findById(id);
        if (opt.isPresent()) {
            Booking booking = opt.get();
            booking.setStatus(status);
            return toDTO(bookingRepository.save(booking));
        }
        return null;
    }

    // Delete booking
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    // --- Mapping helpers ---

    private Booking toEntity(BookingDTO dto) {
        Booking b = new Booking();
        b.setCustomerName(dto.getCustomerName());
        b.setMobileNumber(dto.getMobileNumber());
        b.setFromLocation(dto.getFromLocation());
        b.setToLocation(dto.getToLocation());
        b.setTravelDate(dto.getTravelDate());
        b.setNumberOfPassengers(dto.getNumberOfPassengers());
        b.setVehicleType(dto.getVehicleType());
        b.setMessage(dto.getMessage());
        return b;
    }

    private BookingDTO toDTO(Booking b) {
        BookingDTO dto = new BookingDTO();
        dto.setId(b.getId());
        dto.setCustomerName(b.getCustomerName());
        dto.setMobileNumber(b.getMobileNumber());
        dto.setFromLocation(b.getFromLocation());
        dto.setToLocation(b.getToLocation());
        dto.setTravelDate(b.getTravelDate());
        dto.setNumberOfPassengers(b.getNumberOfPassengers());
        dto.setVehicleType(b.getVehicleType());
        dto.setMessage(b.getMessage());
        dto.setStatus(b.getStatus());
        dto.setCreatedAt(b.getCreatedAt());
        return dto;
    }
}
