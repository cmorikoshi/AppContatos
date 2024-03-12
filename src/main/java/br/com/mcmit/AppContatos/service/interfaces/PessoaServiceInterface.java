package br.com.mcmit.AppContatos.service.interfaces;

import java.util.List;
import java.util.Optional;

import br.com.mcmit.AppContatos.dto.PessoaDTO;
import br.com.mcmit.AppContatos.model.Pessoa;

public interface PessoaServiceInterface {
	//Salvar o pessoa
	Pessoa save(Pessoa pessoa);
	//Recuperar 1 pessoa
	Optional<Pessoa> getById(Long id);
	//Recuperar todos os pessoas
	List<Pessoa> getAll();
	//Atualizar o pessoa
	Pessoa update(Pessoa pessoa);
	//Deletar o pessoa
	void delete(Long id);
}
