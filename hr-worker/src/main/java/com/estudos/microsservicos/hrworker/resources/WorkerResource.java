package com.estudos.microsservicos.hrworker.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudos.microsservicos.hrworker.entity.Worker;
import com.estudos.microsservicos.hrworker.repository.WorkerRepository;


@RestController()
@RequestMapping(value = "/workers")
public class WorkerResource {

	@Autowired
	private WorkerRepository wk;
	
	@GetMapping()
	public ResponseEntity<List<Worker>> getAllWorker() {
		List<Worker> worker = wk.findAll();

		return ResponseEntity.ok(worker);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Worker> getOneWorker(@PathVariable("id") Long id){
		Worker worker = wk.findById(id).get();
		
		return ResponseEntity.ok(worker);
	}
}
