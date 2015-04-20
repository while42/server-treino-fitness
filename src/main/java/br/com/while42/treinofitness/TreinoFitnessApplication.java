package br.com.while42.treinofitness;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

import br.com.while42.treinofitness.model.Academia;
import br.com.while42.treinofitness.model.Aluno;
import br.com.while42.treinofitness.repository.AcademiaRepository;
import br.com.while42.treinofitness.repository.UsuarioRepository;

//import org.springframework.security.core.context.SecurityContextHolder;

@RestController
@EnableAutoConfiguration
@ComponentScan
public class TreinoFitnessApplication {

	private @Autowired UsuarioRepository usuarioRepository;
	private @Autowired AcademiaRepository academiaRepository;
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(TreinoFitnessApplication.class, args);
	}

	@PostConstruct
	public void init() {
		Academia vip = academiaRepository.save(new Academia("VIP Extreme"));
		Aluno aluno = new Aluno("Aluno");
		//aluno.setAcademia(vip);
		usuarioRepository.save(aluno);
		
		// SecurityContextHolder.clearContext();
	}
}