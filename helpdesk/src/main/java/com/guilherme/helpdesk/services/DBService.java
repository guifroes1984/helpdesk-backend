package com.guilherme.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilherme.helpdesk.domain.Chamado;
import com.guilherme.helpdesk.domain.Cliente;
import com.guilherme.helpdesk.domain.Tecnico;
import com.guilherme.helpdesk.domain.enums.Perfil;
import com.guilherme.helpdesk.domain.enums.Prioridade;
import com.guilherme.helpdesk.domain.enums.Status;
import com.guilherme.helpdesk.repositories.ChamadoRepository;
import com.guilherme.helpdesk.repositories.ClienteRepository;
import com.guilherme.helpdesk.repositories.TecnicoRepository;

@Service
public class DBService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ChamadoRepository chamadoRepository;

	
	public void instaciaDB() {
		Tecnico tec1 = new Tecnico(null, "Caio", "29651958073", "caio@email.com", "123");
		tec1.addPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Lia", "86355939016", "lia@email.com", "123");
		
		Chamado c1 = new Chamado(null, Prioridade.ALTA, Status.ANDAMENTO, "Chamado 4", "teste chamado 4", tec1, cli1);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
	}

}
