package br.com.mcmit.AppContatos.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mcmit.AppContatos.model.Pessoa;
import br.com.mcmit.AppContatos.repository.PessoaRepository;
import br.com.mcmit.AppContatos.service.interfaces.PessoaServiceInterface;

@Service
public class PessoaService implements PessoaServiceInterface{
	private PessoaRepository pessoaRepository;
	
	@Autowired
	public PessoaService(PessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
	}
	
	@Override
	public Pessoa save(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

	@Override
	public Optional<Pessoa> getById(Long id) {
		return pessoaRepository.findById(id);
	}

	@Override
	public List<Pessoa> getAll() {
		return pessoaRepository.findAll();
	}

	@Override
	public Pessoa update(Pessoa pessoa) {
		Optional<Pessoa> findPessoa = pessoaRepository.findById(pessoa.getId());
		
		//se ele existir, vou atualizar:
		if(findPessoa.isPresent()) {
			Pessoa updatePessoa = findPessoa.get(); //setId
			updatePessoa.setNome(pessoa.getNome());
			updatePessoa.setEndereco(pessoa.getEndereco());
			updatePessoa.setCidade(pessoa.getCidade());
			updatePessoa.setUf(pessoa.getUf());
			updatePessoa.setCep(pessoa.getCep());
			return pessoaRepository.save(updatePessoa);
		}
		return pessoa;		
	}

	@Override
	public void delete(Long id) {
		pessoaRepository.deleteById(id);		
	}

}

