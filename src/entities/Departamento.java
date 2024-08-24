package entities;

import java.util.ArrayList;

public class Departamento 
{
	private String nome;
	private String bloco;
	private ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
	
	public Departamento(String nome, String bloco, ArrayList<Funcionario> funcionarios) {
		this.nome = nome;
		this.bloco = bloco;
		this.funcionarios = funcionarios;
	}
	
	
	
	
}
