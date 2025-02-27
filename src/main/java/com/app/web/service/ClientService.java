package com.app.web.service;

import java.util.List;

import com.app.web.persistence.entity.ClientEntity;

public interface ClientService	
{
	ClientEntity saveClient(ClientEntity client);
	
	List<ClientEntity> getClients();
	
    ClientEntity getClient(Long id);

    ClientEntity updateClient(Long id, ClientEntity client);

    String deleteClient(Long id);
}
