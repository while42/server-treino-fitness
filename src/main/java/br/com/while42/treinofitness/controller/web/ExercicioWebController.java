package br.com.while42.treinofitness.controller.web;

import lombok.extern.log4j.Log4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.while42.treinofitness.model.Aluno;
import br.com.while42.treinofitness.model.treino.AbstractExercicio;
import br.com.while42.treinofitness.model.treino.ExercicioCustomizado;
import br.com.while42.treinofitness.model.treino.ExercicioDistanciaPorTempo;
import br.com.while42.treinofitness.model.treino.ExercicioPesoPorTempo;
import br.com.while42.treinofitness.model.treino.ExercicioRepeticoes;
import br.com.while42.treinofitness.model.treino.ExercicioRepeticoesComPeso;
import br.com.while42.treinofitness.model.treino.ExercicioTempo;
import br.com.while42.treinofitness.model.treino.Treino;
import br.com.while42.treinofitness.repository.AlunoRepository;
import br.com.while42.treinofitness.repository.ExercicioRepository;
import br.com.while42.treinofitness.repository.TreinoRepository;

@Log4j
@Controller
@RequestMapping("/exercicio")
public class ExercicioWebController {

	private @Autowired ExercicioRepository exercicioRepository;
	private @Autowired AlunoRepository alunoRepository;
	private @Autowired TreinoRepository treinoRepository;

	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public String all(Model model) {
		Iterable<AbstractExercicio> exercicios = exercicioRepository.findAll();

		model.addAttribute("exercicios", exercicios);

		return "exercicio-lista";
	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String form(@RequestParam Long alunoId, @RequestParam Long treinoId,
			Model model) {
		Aluno aluno = alunoRepository.findOne(alunoId);
		Treino treinoQueVaiReceberUmExercicio = treinoRepository.findOne(treinoId);
		
		model.addAttribute("aluno", aluno);
		model.addAttribute("treino", treinoQueVaiReceberUmExercicio);
		model.addAttribute("exercicioDistanciaPorTempo" , new ExercicioDistanciaPorTempo(treinoQueVaiReceberUmExercicio));
		model.addAttribute("exercicioPesoPorTempo" , new ExercicioPesoPorTempo(treinoQueVaiReceberUmExercicio));
		model.addAttribute("exercicioRepeticoes" , new ExercicioRepeticoes(treinoQueVaiReceberUmExercicio));
		model.addAttribute("exercicioRepeticoesComPeso" , new ExercicioRepeticoesComPeso(treinoQueVaiReceberUmExercicio));
		model.addAttribute("exercicioCustomizado" , new ExercicioCustomizado(treinoQueVaiReceberUmExercicio));
		model.addAttribute("exercicioTempo" , new ExercicioTempo(treinoQueVaiReceberUmExercicio));
		return "exercicio-form";
	}
	
	
	@RequestMapping(value = "/excluir", method = RequestMethod.GET)
	public String exclui(@RequestParam Long exercicioId){
		log.debug(" ==============> idExercicio = " + exercicioId);
		exercicioRepository.delete(exercicioId);
		log.debug(" --------------> idExercicio = " + exercicioId);
		return "exercicio-lista";
		
	}
}
