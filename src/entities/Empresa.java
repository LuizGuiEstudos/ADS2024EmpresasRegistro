package entities;

import java.util.ArrayList;

public class Empresa {
	
	private ArrayList<Departamento> departamentos = new ArrayList<Departamento>();

	String CNPJ;
	String nomeFantasia;
	//Departamentos
	
	public Empresa(String CNPJ, String nomeFantasia) {
		this.CNPJ = CNPJ;
		this.nomeFantasia = nomeFantasia;
	}
	
	public void associarDepartamento( Departamento departamento ) {
		departamentos.add(departamento);
	}
	
	
}
