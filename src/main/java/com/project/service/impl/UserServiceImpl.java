package com.project.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.project.dto.DTOkpideclientes;
import com.project.dto.DTOlistclientes;
import com.project.model.Usuario;
import com.project.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	List<Usuario> listausuarios = new ArrayList<>();

	public Usuario creacliente​(Usuario usuario) {
		Usuario u = new Usuario();

		u.setNombre(usuario.getNombre());
		u.setApellido(usuario.getApellido());
		u.setEdad(usuario.getEdad());
		u.setFechaNacimiento(usuario.getFechaNacimiento());

		listausuarios.add(u);

		return u;
	}

	public DTOkpideclientes kpideclientes​() {

		DTOkpideclientes kpideclientes = new DTOkpideclientes();

		List<Integer> edades = new ArrayList<>();

		listausuarios.forEach(e -> {

			edades.add(e.getEdad());

		});

		kpideclientes.setPromedioEdad(promedio(edades));
		kpideclientes.setDeviacionEstandarEdad(desviacion(edades));

		return kpideclientes;
	}

	public List<DTOlistclientes> listclientes​() {

		List<DTOlistclientes> dtolistclientes​ = new ArrayList<>();

		listausuarios.forEach(arg0 -> {

			DTOlistclientes dtoListClientes = new DTOlistclientes();

			LocalDate provableMuerte = arg0.getFechaNacimiento().plusYears(76).plusDays(randonNumero(1, 28))
					.plusMonths(randonNumero(1, 12));

			dtoListClientes.setNombre(arg0.getNombre());
			dtoListClientes.setApellido(arg0.getApellido());
			dtoListClientes.setEdad(arg0.getEdad());
			dtoListClientes.setFechaNacimiento(arg0.getFechaNacimiento());
			dtoListClientes.setFechaProvableMuerte(provableMuerte);

			dtolistclientes​.add(dtoListClientes);

		});

		return dtolistclientes​;
	}

	public int randonNumero( int min,int max) {

		return (int) ((Math.random() * (max - min)) + min);
	}

	public double promedio(List<Integer> v) {
		double prom = 0.0;
		for (int i = 0; i < v.size(); i++)
			prom += v.get(i);

		return prom / (double) v.size();
	}

	public double desviacion(List<Integer> v) {
		double prom, sum = 0;
		int i, n = v.size();
		prom = promedio(v);

		for (i = 0; i < n; i++)
			sum += Math.pow(v.get(i) - prom, 2);

		return Math.sqrt(sum / (double) n);
	}

}
