package br.edu.fatecfranca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.edu.fatecfranca.model.Paciente;
import br.edu.fatecfranca.model.repositories.PacienteRepository;

// a classe é responsável por responder as requisições

@RestController
@RequestMapping("/paciente")

public class PacienteController {
	
	//Spring possui o recurso de injeção de dependência
	//objeto pode executar métodos de uma interface sem instanciar
		
	@Autowired	
	PacienteRepository injecao;
	
	// método para inserir no banco de dados
	//os valores do paciente virão no corpo (body) da requisição
	
	@PostMapping
	// CORS - Cross Origin Resource Sharing
	// O Cross Origem seja utilizado de qualquer lugar (ip de qualquer lugar)
	@CrossOrigin(origins="*")
	public String add(@RequestBody Paciente paciente) {
		
		//{
		// cpf: "12121",
		// idade: 20,
		// altura: 1.78,
		// peso: 78
		// }
		injecao.save(paciente);
		return "Paciente inserido com sucesso";
	}
	
	//método para consultar no banco de dados
	@GetMapping
	// CORS - Cross Origin Resource Sharing
	// O Cross Origem seja utilizado de qualquer lugar (ip de qualquer lugar)
	// A API pode ser acessada de qualquer IP
	@CrossOrigin(origins="*")
	
	
	public List<Paciente> get(){
		//procurar os pacientes no banco de dados
		return injecao.findAll();
	}
	
	//método para remover do banco de dados
	@DeleteMapping("/{id}")
	//remover um paciente no banco de dados
	// CORS - Cross Origin Resource Sharing
	// O Cross Origem seja utilizado de qualquer lugar (ip de qualquer lugar)
	@CrossOrigin(origins="*")

	public String remove(@PathVariable Long id) {
		injecao.deleteById(id);
		return "Paciente removido com sucesso";
	}
	
	//método para atualizar no banco de dados
	@PutMapping
	// CORS - Cross Origin Resource Sharing
	// O Cross Origem seja utilizado de qualquer lugar (ip de qualquer lugar)
	@CrossOrigin(origins="*")
	
	public String update(@RequestBody Paciente paciente) {
		// atualiza o paciente no banco de dados
		injecao.save(paciente); //paciente tem id, e portanto vai atualizar
		return "Paciente atualizado com sucesso";
	}
}
