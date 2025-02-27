package com.app.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.web.persistence.entity.ClientEntity;
import com.app.web.service.ClientService;

//	@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/v1")
public class ClientController
{
	@Autowired
	private ClientService clientService;

	@PostMapping("/clients")
	public ResponseEntity<ClientEntity> saveClient(@RequestBody ClientEntity client)
	{
		return new ResponseEntity<>(clientService.saveClient(client), HttpStatus.CREATED);
	}

	@GetMapping("/clients")
	public ResponseEntity<List<ClientEntity>> getClients()
	{
		return new ResponseEntity<>(clientService.getClients(), HttpStatus.OK);
	}

	@GetMapping("/clients/{id}")
	public ResponseEntity<ClientEntity> getClient(@PathVariable Long id)
	{
		return new ResponseEntity<>(clientService.getClient(id), HttpStatus.OK);
	}

	@PutMapping("/clients/{id}")
	public ResponseEntity<ClientEntity> updateClient(@PathVariable Long id, @RequestBody ClientEntity client)
	{
		return new ResponseEntity<>(clientService.updateClient(id, client), HttpStatus.OK);
	}

	@DeleteMapping("/clientes/{id}")
	public ResponseEntity<String> deleteClient(@PathVariable Long id)
	{
		return new ResponseEntity<>(clientService.deleteClient(id), HttpStatus.OK);
	}
}
