package br.com.mcmit.AppContatos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mcmit.AppContatos.model.Contato;
import br.com.mcmit.AppContatos.model.Pessoa;
import br.com.mcmit.AppContatos.repository.ContatoRepository;
import br.com.mcmit.AppContatos.repository.PessoaRepository;
import br.com.mcmit.AppContatos.service.interfaces.ContatoServiceInterface;

@Service
public class ContatoService  implements ContatoServiceInterface{

	private ContatoRepository contatoRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	public ContatoService(ContatoRepository contatoRepository) {
		this.contatoRepository = contatoRepository;
	}
	
	@Override
	public Contato save(Contato contato) {
		if(contato.getPessoa().getId() != null) {
		Optional<Pessoa> findPessoa = pessoaRepository.findById(contato.getPessoa().getId());
		if(findPessoa.isEmpty()) {
			return null;
		}
		else {
			contato.setPessoa(findPessoa.get());
			return contatoRepository.save(contato);
		}
	}else {
		return null;
	}
	}

	@Override
	public Optional<Contato> getById(Long id) {
		return contatoRepository.findById(id);
	}

	@Override
	public List<Contato> getAll() {
		return contatoRepository.findAll();
	}

	@Override
	public Contato update(Contato contato) {
		Optional<Contato> findContato = contatoRepository.findById(contato.getId());
		if(findContato.isPresent()) {
			Contato updateContato = findContato.get();
			updateContato.setContato(contato.getContato());
			updateContato.setPessoa(contato.getPessoa());
			updateContato.setTipoContato(contato.getTipoContato());
			return contatoRepository.save(updateContato);
		}
		return contato;
	}

	@Override
	public void delete(Long id) {
		contatoRepository.deleteById(id);
		
	}

}
