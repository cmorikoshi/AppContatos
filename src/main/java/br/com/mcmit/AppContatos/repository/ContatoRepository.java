package br.com.mcmit.AppContatos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mcmit.AppContatos.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {

}
