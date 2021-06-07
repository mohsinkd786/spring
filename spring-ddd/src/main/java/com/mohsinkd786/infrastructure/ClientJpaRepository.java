package com.mohsinkd786.infrastructure;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohsinkd786.domain.Client;
import com.mohsinkd786.domain.imports.ClientRepository;
import com.mohsinkd786.infrastructure.imports.ImportedClientJpaRepository;

@Service
public class ClientJpaRepository implements ClientRepository {

    private final ImportedClientJpaRepository impl;

    @Autowired
    public ClientJpaRepository(final ImportedClientJpaRepository impl) {
        this.impl = impl;
    }

    public void deleteAll(){impl.deleteAll();}

    public Client save(final Client client){
        return impl.save(client);
    }

    public void delete(Client client){
        impl.delete(client);
    }

	@Override
	public Optional<Client> find(Long id) {
		return impl.findOneById(id);
	}

	@Override
	public Optional<Client> find(String username) {
		return impl.findOneByUsername(username);
	}

    public List<Client> findAll(){
        return impl.findAllByOrderByIdDesc();
    }

    public List<Client> findAllBornFrom(final LocalDate minDate){
        return impl.findAllByBirthDateGreaterThanEqualOrderByBirthDateDescIdDesc(minDate);
    }

}
