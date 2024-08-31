package entities;

import java.util.ArrayList;

public class Empresa {

	private static ArrayList<Departamento> departamentos = new ArrayList<Departamento>();
	

	private String CNPJ;
	private String nomeFantasia;
	
	
	public ArrayList<Departamento> getDepartamentos() {
		return departamentos;
	}
	public void associarDepartamento( Departamento dep ) { //>< Departamento
		departamentos.add( dep );
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
	
	
	
}
