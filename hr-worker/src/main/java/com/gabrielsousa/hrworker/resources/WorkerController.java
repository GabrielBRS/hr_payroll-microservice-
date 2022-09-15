package com.gabrielsousa.hrworker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielsousa.hrworker.entities.Worker;
import com.gabrielsousa.hrworker.repositories.WorkerRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping(value="/workers")
public class WorkerController {

	@Autowired
	private WorkerRepository workerRepository;
	
	@Autowired
	private Environment env;
	
	private static Logger logger = LoggerFactory.getLogger(WorkerController.class);
	
	@GetMapping
	@CircuitBreaker(name = "workerController", fallbackMethod = "getDefaultWorkerList")
	public ResponseEntity<List<Worker>> findAll(){
		List<Worker> list = workerRepository.findAll();
		return ResponseEntity.ok(list);
	}
	
	public ResponseEntity<String> getDefaultWorkerList(Exception ex){
		return new ResponseEntity<String>("Não foi possível fazer a chamada do Trabalhador", HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id){
		
		logger.info("PORT = " + env.getProperty("local.server.port"));
		
		Worker obj = workerRepository.findById(id).get();
		return ResponseEntity.ok(obj);
	}
}