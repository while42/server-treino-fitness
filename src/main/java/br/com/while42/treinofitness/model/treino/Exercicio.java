package br.com.while42.treinofitness.model.treino;

public interface Exercicio {

	public static final long MINIMO_SERIES = 1;

	public abstract Long getId();

	public abstract String getNome();

	public abstract void setSeries(long series);

	public abstract long getSeries();
	
	public abstract String getDescricao();
	
}