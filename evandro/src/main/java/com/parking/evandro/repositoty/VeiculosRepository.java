package com.parking.evandro.repositoty;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parking.evandro.modelo.Veiculos;

@Repository
public interface VeiculosRepository extends JpaRepository<Veiculos, Long> {
	//Optional<Veiculos> findById(Long id);
	List<Veiculos> findAll();
	

}
