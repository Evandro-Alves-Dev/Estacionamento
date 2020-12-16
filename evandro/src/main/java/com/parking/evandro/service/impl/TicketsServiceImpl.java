package com.parking.evandro.service.impl;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.evandro.modelo.Tickets;
import com.parking.evandro.repositoty.TicketsRespository;
import com.parking.evandro.repositoty.VeiculosRepository;
import com.parking.evandro.service.TicketsService;

@Service
public class TicketsServiceImpl implements TicketsService {

	@Autowired
	VeiculosRepository veiculosrepository;

	@Autowired
	TicketsRespository ticketsrepository;

	@Override
	public Tickets iniciaPeriodo(Tickets tickets) {
		tickets.setHoraEntrada(LocalDateTime.now());
		return tickets;
	}

	@Override
	public Tickets finalizazarPeriodo(Long id, Tickets tickets) {
		tickets.getHoraEntrada();
		tickets.getId();
		tickets.getValor();
		tickets.getVeiculos();
		tickets.setHoraSaida(LocalDateTime.now());
		Long horas = ChronoUnit.HOURS.between(tickets.getHoraEntrada(), tickets.getHoraSaida());
		Long total;
		if (horas < 1) {
			total = 7L;
		} else {
			total = ((horas - 1) * 3) + 7L;
		}

		tickets.setValor(total);
		return tickets;

	}

	@Override
	public List<Tickets> geraRelatorio() {
		List<Tickets> listaComValor = new ArrayList<>();
		List<Tickets> lista = ticketsrepository.findAll();
		for (Tickets tickets : lista) {
			if (tickets.getValor() != null) {
				Tickets save = ticketsrepository.save(tickets);
				listaComValor.add(save);
			}

		}
		return listaComValor;

	}

}
