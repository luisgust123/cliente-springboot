package com.project.service;

import java.util.List;

import com.project.dto.DTOkpideclientes;
import com.project.dto.DTOlistclientes;
import com.project.model.Usuario;

public interface IUserService {
	
	Usuario creacliente​(Usuario t);

	DTOkpideclientes kpideclientes​();

	List<DTOlistclientes> listclientes​();

}
