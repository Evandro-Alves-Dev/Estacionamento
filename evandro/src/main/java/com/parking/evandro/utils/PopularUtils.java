package com.parking.evandro.utils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.parking.evandro.modelo.Tickets;
import com.parking.evandro.modelo.Veiculos;
import com.parking.evandro.repositoty.TicketsRespository;
import com.parking.evandro.repositoty.VeiculosRepository;

@Configuration
@EnableTransactionManagement
@Component
public class PopularUtils {

	@Autowired
	VeiculosRepository veiculosrepository;
	
	@Autowired
	TicketsRespository ticketsrepository;

	// Anotação para popular o banco de dados, esta comentado para não popular todo vez que for atualizado.
	//@PostConstruct 
	public void saveEntrada() {

		List<Veiculos> veiculoList = new ArrayList<>();
		List<Tickets> ticketList = new ArrayList<>();			

		Veiculos ent1 = new Veiculos();
		ent1.setPlaca("APT-20454");
		ent1.setModelo("Celta");
		ent1.setMarca("Chevrolet");
		
		Tickets tick1 = new Tickets();
		tick1.setHoraEntrada(LocalDateTime.now());
		tick1.setVeiculos(ent1);			
		
		
		veiculoList.add(ent1);
		
		ticketList.add(tick1);	

		for (Veiculos veiculos : veiculoList) {
			Veiculos entradaSaved = veiculosrepository.save(veiculos);
			System.out.println(entradaSaved.getId());

		for(Tickets tickets : ticketList) {
			ticketsrepository.save(tickets);
		}
			
		}
	}
}
