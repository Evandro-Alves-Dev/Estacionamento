package com.parking.evandro.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.parking.evandro.modelo.Tickets;

@Repository
public interface TicketsRespository extends JpaRepository<Tickets, Long> {

	@Query(value = "SELECT SUM(valor) FROM tb_tickets", nativeQuery = true)
    Double selectTotal();
}
