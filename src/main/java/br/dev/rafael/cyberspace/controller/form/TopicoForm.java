package br.dev.rafael.cyberspace.controller.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.dev.rafael.cyberspace.model.Curso;
import br.dev.rafael.cyberspace.model.Topico;
import br.dev.rafael.cyberspace.repository.CursoRepository;

public class TopicoForm {
	
	@NotNull @NotEmpty @Min(value = 5)
	private String titulo;
	
	@NotNull @NotEmpty @Min(value = 10)
	private String mensagem;
	
	@NotNull @NotEmpty @Min(value = 10)
	private String nomeCurso;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getNomeCurso() {
		return nomeCurso;
	}
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	public Topico converter(CursoRepository cursoRepository) {
		Curso curso = cursoRepository.findByNome(nomeCurso);
		return new Topico(titulo, mensagem, curso);
	}
	
}
