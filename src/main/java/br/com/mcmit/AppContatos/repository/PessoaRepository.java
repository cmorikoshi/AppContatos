package br.com.mcmit.AppContatos.repository;

import org.springframework.stereotype.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mcmit.AppContatos.model.Pessoa;


@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	//@Query(value = "SELECT id, nome, (endereco + ' - ' + cep + ' - ' + cidade + ' - ' + uf) as malaDireta FROM pessoa", nativeQuery = true)

}
