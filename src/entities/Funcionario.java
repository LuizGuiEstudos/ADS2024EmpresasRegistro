package entities;

import java.time.LocalDate;

public class Funcionario {
	private String nome;
	private float salario;
	private LocalDate dtAdmissao;
	
	public Funcionario(String nome, float salario, LocalDate dtAdmissao) {
		this.nome = nome;
		this.salario = salario;
		this.dtAdmissao = dtAdmissao;
	}
	
	
	
}
