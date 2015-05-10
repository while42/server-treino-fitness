package br.com.while42.treinofitness.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Treino {

	private @Id @GeneratedValue Long id;
	
	private String nome;
	private String descricao;
	
	@OneToMany(cascade=CascadeType.PERSIST)
	private final List<AbstractExercicio> exercicios = new ArrayList<AbstractExercicio>();
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Aluno aluno;

	@Deprecated
	public Treino() {
	}
	
	public Treino(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}

	public Long getId(){
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public void addExercicio(AbstractExercicio exercicio) {
		exercicios.add(exercicio);
	}

	public List<AbstractExercicio> getExercicios() {
		return exercicios;
	}
	
	@Override
	public String toString() {
		return nome;
	}
}
