package com.estudos.microsservicos.hrpayroll.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.estudos.microsservicos.hrpayroll.entity.Worker;

/*
 a anotação FeignClient na interface, através dela, dizemos qual é a url da nossa API. 
 Nas versões mais recentes do Feign, precisamos passar além da url, um nome para nosso cliente. 
 O método responsável por buscar o usuário pelo email pode ser declarado utilizando anotações já conhecidas do Spring.
 
 @FeignClient: Registra no contexto a interface como um client do Feigh;
url: Define a URL do serviço a ser requisitado;
path: Define o path do serviço, que pode ser configurado separadamente da url;
name: Define um nome para o client;
@RequestMapping: Define o mapeamento do serviço utilizando os padrões do Spring MVC.
 
 */

@Component
@FeignClient(name = "hr-worker", url = "localhost:8001", path = "/workers")
public interface WorkerFeignClient {

	@GetMapping("/{id}")
	public ResponseEntity<Worker> getOneWorker(@PathVariable("id") Long id);
}
