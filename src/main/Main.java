package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import entities.Departamento;
import entities.Empresa;
import entities.Funcionario;

public class Main {
	
	private static Scanner scan = new Scanner( System.in );
	
	private static ArrayList<Empresa> empresas = new ArrayList<Empresa>();
	private static ArrayList<Departamento> departamentos  = new ArrayList<Departamento>();
	private static ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

	public static void main(String[] args) {
		
		boolean run = true;
		int opcaoCategoria = 0;
		int acaoVoltar = 0;
		
		//LOOP PRIMARIO - ESCOLHA CATEGORIA DE ACAO
		while( run ) {
			
			opcaoCategoria = scan.nextInt();
			
			switch( opcaoCategoria ) {
			case 1:
				criarFuncionario();
				break;
			case 2:
				criarDepartamento();
				break;
			case 3:
				criarEmpresa();
				break;
			}
			
		}
		
	}
	
	private static void criarFuncionario() {
		System.out.println("  Digite as seguintes informações do Funcionário... ");
		System.out.println( "Nome: " );
		String nome = scan.next();
		System.out.println( "Salario (ex 1000.00): " );
		float salario = scan.nextFloat();
		LocalDate admissao = null; // TODO - adicionar data
		
		funcionarios.add( new Funcionario(nome, float, admissao) )
//		private String nome;
//		private float salario;
//		private LocalDate dtAdmissao;
		
		
	}
	
	private static void criarDepartamento() {
		
	}
	
	private static void criarEmpresa() {
		String CNPJ;
		String nomeFantasia;
		
		System.out.println( " Entrar com CNPJ da empresa: " );
		CNPJ = scan.next();
		System.out.println( " Entrar com Nome Fantasia da empresa: " );
		nomeFantasia = scan.next();
		
		empresas.add( new Empresa(CNPJ, nomeFantasia) );
		
		
	}
	
	private static addFuncionarioToDepartamento( Funcionario func ) {
		
	}
	
	private static addDepartamentoToEmpresa( Departamento dep ) {
		
	}
	
	
}
