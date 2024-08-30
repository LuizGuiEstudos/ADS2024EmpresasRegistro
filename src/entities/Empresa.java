package entities;

import java.util.ArrayList;

public class Empresa {

	private ArrayList<Departamento> departamentos = new ArrayList<Departamento>();

	private String CNPJ;
	private String nomeFantasia;
	
	//Departamentos
	
	public ArrayList<Departamento> getDepartamentos() {
		return departamentos;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public Empresa(String CNPJ, String nomeFantasia) {
		this.CNPJ = CNPJ;
		this.nomeFantasia = nomeFantasia;
	}
	
	public void associarDepartamento( Departamento departamento ) {
		departamentos.add(departamento);
	}
	
}
