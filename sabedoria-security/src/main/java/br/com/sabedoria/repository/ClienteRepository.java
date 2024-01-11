package br.com.sabedoria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sabedoria.model.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
