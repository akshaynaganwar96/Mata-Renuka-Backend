package com.renukamata.booking.repository;

import com.renukamata.booking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByStatusOrderByCreatedAtDesc(String status);

    List<Booking> findAllByOrderByCreatedAtDesc();
}
