package br.com.while42.treinofitness.model.treino;

import javax.persistence.Entity;

@Entity
public class ExercicioRepeticoes extends AbstractExercicio {
	
	private long repeticoes;

	@Deprecated
	public ExercicioRepeticoes() {
	}

	public ExercicioRepeticoes(String nome, long repeticoes) {
		this(nome, MINIMO_SERIES, repeticoes);
	}
	
	public ExercicioRepeticoes(String nome, long series, long repeticoes) {
		super(nome, series);
		this.repeticoes = repeticoes;
	}
	
	@SuppressWarnings("deprecation")
	public ExercicioRepeticoes(Treino treino){
		setTreino(treino);
	}

	public long getRepeticoes() {
		return repeticoes;
	}
	
	public void setRepeticoes(long repeticoes) {
		this.repeticoes = repeticoes;
	}
	
	public String getString(){
		return getNome() + " - " + getRepeticoes() + " repetições";
	}
}
