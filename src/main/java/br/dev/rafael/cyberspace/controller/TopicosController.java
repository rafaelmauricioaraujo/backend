package br.dev.rafael.cyberspace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.dev.rafael.cyberspace.controller.dto.TopicoDto;
import br.dev.rafael.cyberspace.model.Topico;
import br.dev.rafael.cyberspace.repository.TopicoRepository;

@RestController
public class TopicosController {
	
	@Autowired
	private TopicoRepository topicoRepository;	

	@RequestMapping("/topicos")
	public List<TopicoDto> lista(){
		List<Topico> topicos = topicoRepository.findAll();
		return TopicoDto.converter(topicos);
	}

}
