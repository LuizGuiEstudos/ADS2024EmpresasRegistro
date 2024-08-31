package entities;

import java.util.ArrayList;

public class Departamento {
	private static ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
	
	private String nome;
	private String bloco;
	public ArrayList<Funcionario> getFuncionarios() { //><funcionarios
		return funcionarios;
	}
	public void associarFuncionarios( Funcionario fun ) {
		funcionarios.add(fun);
	}
	public String getNome() {
		return nome;
	}
	public String getBloco() {
		return bloco;
	}
	
	public Departamento(String nome, String bloco) {
		this.nome = nome;
		this.bloco = bloco;
	}
}
