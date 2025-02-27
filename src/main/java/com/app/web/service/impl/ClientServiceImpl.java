package com.app.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.exception.ResourceNotFoundException;
import com.app.web.persistence.entity.ClientEntity;
import com.app.web.persistence.repository.ClientRepository;
import com.app.web.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService
{
	@Autowired
	private ClientRepository clientRepository;

	@Override
	public ClientEntity saveClient(ClientEntity client)
	{
		return clientRepository.save(client);
	}

	@Override
	public List<ClientEntity> getClients()
	{
		return clientRepository.findAll();
	}

	@Override
	public ClientEntity getClient(Long id)
	{
		return clientRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("The client with that ID does not exist:" + id));
	}

	@Override
	public ClientEntity updateClient(Long id, ClientEntity client)
	{
		ClientEntity clientFound = clientRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("The client with that ID does not exist:" + id));

		clientFound.setName(client.getName());
		clientFound.setLastname(client.getLastname());
		clientFound.setEmail(client.getEmail());

		ClientEntity clientUpdate = clientRepository.save(clientFound);

		return clientUpdate;
	}

	@Override
	public String deleteClient(Long id)
	{
		ClientEntity clientFound = clientRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("The client with that ID does not exist:" + id));

		clientRepository.deleteById(clientFound.getId());
		return "Client deleted successfully";
	}

}
