package com.parking.evandro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.parking.evandro.modelo.Tickets;
import com.parking.evandro.repositoty.TicketsRespository;
import com.parking.evandro.service.impl.TicketsServiceImpl;

@RestController
public class TicketController {

	@Autowired
	TicketsRespository ticketsrepository;

	@Autowired
	TicketsServiceImpl ticketserviceimpl;

	// Retorna toda a lista de tickets cadastrados
	@GetMapping("/tickets")
	public List<Tickets> listaTodosTickets() {
		return ticketsrepository.findAll();
	}

	// Retorna um ticket de acordo com o id
	@GetMapping("/tickets/{id}")
	public Optional<Tickets> listaTickets(@PathVariable(value = "id") Long id) {
		return ticketsrepository.findById(id);
	}

	// Salva um novo ticket
	@PostMapping("/tickets")
	public Tickets salvaTickets(@RequestBody Tickets tickets) {
		Tickets entrada = ticketserviceimpl.iniciaPeriodo(tickets);
		return ticketsrepository.save(entrada);
	}

	// Deleta um ticket
	@DeleteMapping("/tickets")
	public void deletaTickets(@RequestBody Tickets tickets) {
		ticketsrepository.delete(tickets);
	}

	// Atualiza tickets
	@PutMapping("/tickets")
	public Tickets atualizaTickets(@RequestBody Tickets tickets) {
		return ticketsrepository.save(tickets);
	}

	// Finaliza periodo
	@PutMapping("/tickets/{id}")
	public Tickets registrarSaida(@PathVariable Long id, @RequestBody Tickets tickets) {
		Tickets saida = ticketserviceimpl.finalizazarPeriodo(id, tickets);
		return ticketsrepository.save(saida);
	}
	
//	// Gera Relatório com todos os valores pagos
//	@GetMapping("/ticketsrelatorio")
//	public List<Tickets> listaTodosTicketsPagos() {
//		List<Tickets> relatorio = ticketserviceimpl.geraRelatorio();
//		return relatorio;
//	}
	
	// Gera Relatório com todos os valores pagos
	@GetMapping("/relatorio")
    public Double getForecastTotals() {
        return ticketsrepository.selectTotal();
    }

}
