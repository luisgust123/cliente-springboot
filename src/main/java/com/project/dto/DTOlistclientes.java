package com.project.dto;

import java.time.LocalDate;

import com.project.model.Usuario;

public class DTOlistclientes extends Usuario {
	
	
	private LocalDate fechaProvableMuerte;

	public LocalDate getFechaProvableMuerte() {
		return fechaProvableMuerte;
	}

	public void setFechaProvableMuerte(LocalDate fechaProvableMuerte) {
		this.fechaProvableMuerte = fechaProvableMuerte;
	}
	
	

}
