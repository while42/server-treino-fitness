package br.com.while42.treinofitness.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.while42.treinofitness.model.Instrutor;
import br.com.while42.treinofitness.repository.InstrutorRepository;

@RestController
@RequestMapping(ApiControllerConfiguration.BASE_URL_API + "/instrutor")
public class InstrutorController {
	
	private @Autowired InstrutorRepository instrutorRepository;

	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public Iterable<Instrutor> lista(){
		return instrutorRepository.findAll();
	}

	@RequestMapping(value = "/{instrutorId}", method = RequestMethod.GET)
	public ResponseEntity<Instrutor> instrutor(@PathVariable String instrutorId) {
		return new ResponseEntity<Instrutor>(instrutorRepository.findOne(Long.valueOf(instrutorId)), HttpStatus.OK);
	}

	@RequestMapping(value = "/{instrutorId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable String instrutorId) {
		instrutorRepository.delete(Long.valueOf(instrutorId));
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

	@RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.PUT})
	public ResponseEntity<?> save(@RequestBody Instrutor instrutor) {
		if (instrutor.getId() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		HttpStatus httpStatus = (instrutor.getId() == null) ? HttpStatus.CREATED : HttpStatus.OK;
		instrutorRepository.save(instrutor);
		return new ResponseEntity<Instrutor>(instrutor, httpStatus);
	}
}
