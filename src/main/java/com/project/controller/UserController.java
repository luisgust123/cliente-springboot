package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.DTOkpideclientes;
import com.project.dto.DTOlistclientes;
import com.project.model.Usuario;
import com.project.service.IUserService;

@RestController
//@RequestMapping("/api")
public class UserController {

	@Autowired
	private IUserService serService;

	@PostMapping(value = "creacliente")
	public Usuario creacliente​(@RequestBody Usuario user) {

		return serService.creacliente​(user);
	}

	@GetMapping(value = "/kpideclientes")
	public DTOkpideclientes kpideclientes​() {

		return serService.kpideclientes​();
	}

	@GetMapping(value = "/listclientes")
	public List<DTOlistclientes> listaClientes() {

		return serService.listclientes​();
	}

}
