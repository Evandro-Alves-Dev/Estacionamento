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

import com.parking.evandro.modelo.Veiculos;
import com.parking.evandro.repositoty.VeiculosRepository;

@RestController
public class VeiculosController {

	@Autowired
	VeiculosRepository veiculosrepository;
	
	// Retorna toda a lista de veiculos cadastrados
	@GetMapping("/veiculos")
	public List<Veiculos> listaTodosVeiculos() {
		return veiculosrepository.findAll();
	}

	//Retorna um veiculo de acordo com o id
	@GetMapping("/veiculos/{id}")
	public Optional<Veiculos> listaVeiculos(@PathVariable(value = "id") Long id) {
		return veiculosrepository.findById(id);
	}
	
	// Salva um novo veiculo
	@PostMapping("/veiculos")
	public Veiculos salvaVeiculos(@RequestBody Veiculos veiculos) {
		return veiculosrepository.save(veiculos);
	}
	
	// Deleta um veiculo
	@DeleteMapping("/veiculos")
	public void deletaVeiculos(@RequestBody Veiculos veiculos) {
		veiculosrepository.delete(veiculos);
	}
	
	// Atualiza veiculos
	@PutMapping("/veiculos")
	public Veiculos atualizaVeiculos(@RequestBody Veiculos veiculos) {
		return veiculosrepository.save(veiculos);
	}
}
