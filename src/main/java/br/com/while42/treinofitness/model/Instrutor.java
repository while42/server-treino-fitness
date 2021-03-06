package br.com.while42.treinofitness.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Instrutor extends Usuario {

	@OneToMany(cascade=CascadeType.PERSIST)
	public @JsonIgnore final List<Aluno> alunos = new ArrayList<Aluno>();

	@Deprecated
	public Instrutor() {
	}

	public Instrutor(String login, String nome) {
		super(login, nome, TipoUsuario.INSTRUTOR);
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public final void addAluno(Aluno aluno) {
		alunos.add(aluno);
	}

	@Override
	public String toString() {
		return getUsername();
	}
}
