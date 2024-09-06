package entities;

public class Funcionario {

	private String nome;
	private float salario;
	private String dtAdmissao;
	
	private Departamento departamento;
	
	public String getNome() {
		return nome;
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario( float sal ) {
		salario = sal;
	}
	public String getDtAdmissao() {
		return dtAdmissao;
	}
	public Funcionario(String nome, float salario, String dtAdmissao) {
		this.nome = nome;
		this.salario = salario;
		this.dtAdmissao = dtAdmissao;
	}
	
}
