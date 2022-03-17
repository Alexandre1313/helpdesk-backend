package com.alexandre.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alexandre.helpdesk.domain.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
