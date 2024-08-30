package entities;

import java.util.ArrayList;

public class Departamento {
	private static ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
	
	private String nome;
	private String bloco;
	
	public Departamento(String nome, String bloco) {
		this.nome = nome;
		this.bloco = bloco;
		this.funcionarios = funcionarios;
	}
}
