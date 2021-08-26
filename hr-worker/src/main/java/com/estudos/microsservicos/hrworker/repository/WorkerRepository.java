package com.estudos.microsservicos.hrworker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudos.microsservicos.hrworker.entity.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>  {

}
