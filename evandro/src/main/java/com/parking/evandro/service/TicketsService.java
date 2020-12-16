package com.parking.evandro.service;

import java.util.List;

import com.parking.evandro.modelo.Tickets;

public interface TicketsService {
	
	Tickets finalizazarPeriodo(Long id, Tickets tickets);
	Tickets iniciaPeriodo(Tickets tickets);
	List<Tickets> geraRelatorio();
	

}
