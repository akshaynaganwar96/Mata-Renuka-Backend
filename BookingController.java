package com.renukamata.booking.controller;

import com.renukamata.booking.dto.BookingDTO;
import com.renukamata.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "*")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // POST /api/bookings — Create new booking
    @PostMapping
    public ResponseEntity<BookingDTO> createBooking(@RequestBody BookingDTO dto) {
        BookingDTO saved = bookingService.saveBooking(dto);
        return ResponseEntity.ok(saved);
    }

    // GET /api/bookings — Get all bookings
    @GetMapping
    public ResponseEntity<List<BookingDTO>> getAllBookings(
            @RequestParam(required = false) String status) {
        List<BookingDTO> list;
        if (status != null && !status.isEmpty()) {
            list = bookingService.getBookingsByStatus(status.toUpperCase());
        } else {
            list = bookingService.getAllBookings();
        }
        return ResponseEntity.ok(list);
    }

    // GET /api/bookings/{id} — Get booking by ID
    @GetMapping("/{id}")
    public ResponseEntity<BookingDTO> getBookingById(@PathVariable Long id) {
        BookingDTO dto = bookingService.getBookingById(id);
        if (dto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }

    // PATCH /api/bookings/{id}/status — Update booking status
    @PatchMapping("/{id}/status")
    public ResponseEntity<BookingDTO> updateStatus(
            @PathVariable Long id,
            @RequestBody Map<String, String> body) {
        String status = body.get("status");
        BookingDTO updated = bookingService.updateStatus(id, status);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    // DELETE /api/bookings/{id} — Delete booking
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }
}
