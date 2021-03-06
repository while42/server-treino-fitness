package br.com.while42.treinofitness.model.treino;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public abstract class AbstractExercicio implements Exercicio {
	
	private @Id @GeneratedValue Long id;
	private String nome;
	private String descricao;
	private long series = MINIMO_SERIES;

	@ManyToOne(cascade=CascadeType.PERSIST)
	private Treino treino;

	private @JsonIgnore boolean deletado = false;
	
	public boolean isDeletado() {
		return deletado;
	}

	public void setDeletado(boolean deletado) {
		this.deletado = deletado; 
	}
	
	@Deprecated
	public AbstractExercicio() {
	}
	
	public AbstractExercicio(String nome, long series) {
		this.nome = nome;
		this.series = series;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Treino getTreino() {
		return treino;
	}
	
	public void setTreino(Treino treino) {
		this.treino = treino;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public String getNome() {
		return nome;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public final void setSeries(long series) {
		this.series = series;
	}
	
	@Override
	public final long getSeries() {
		return series;
	}
}
