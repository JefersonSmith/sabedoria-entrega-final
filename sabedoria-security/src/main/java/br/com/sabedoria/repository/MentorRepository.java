package br.com.sabedoria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sabedoria.model.Mentor;


public interface MentorRepository extends JpaRepository<Mentor, Long>{

}
