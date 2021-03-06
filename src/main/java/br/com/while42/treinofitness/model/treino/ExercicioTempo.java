package br.com.while42.treinofitness.model.treino;

import javax.persistence.Entity;

@Entity
public class ExercicioTempo extends AbstractExercicio {
	
	private double tempoEmMinutos;

	@Deprecated
	public ExercicioTempo() {
	}
	
	public ExercicioTempo(String nome, double tempoEmMinutos) {
		this(nome, MINIMO_SERIES, tempoEmMinutos);
	}

	public ExercicioTempo(String nome, long series, double tempoEmMinutos) {
		super(nome, series);
		this.tempoEmMinutos = tempoEmMinutos;
	}

	@SuppressWarnings("deprecation")
	public ExercicioTempo(Treino treinoQueVaiReceberUmExercicio) {
		setTreino(treinoQueVaiReceberUmExercicio);
	}

	public double getTempo() {
		return tempoEmMinutos;
	}
	
	public void setTempo(double minutos) {
		this.tempoEmMinutos = minutos;
	}
	
	public String getString(){
		return getNome() + " - Por " + getTempo() + "min";
	}
}
