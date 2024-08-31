package main;

import java.util.ArrayList;
import java.util.Scanner;

import entities.Departamento;
import entities.Empresa;
import entities.Funcionario;

public class Main {
	
	private static Scanner scan = new Scanner(System.in);
	
	private static ArrayList<Empresa> empresas = new ArrayList<Empresa>();
	private static ArrayList<Departamento> departamentos = new ArrayList<Departamento>();
	private static ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
	
	//CRIAR ENTIDADES
	private static Empresa criarEmpresa() {
		//empresa
		System.out.println( " #### REGISTRO DE NOVA EMPRESA ####" );
		System.out.println( " >Digite as seguintes informações abaixo " );
		System.out.println( "-CNPJ:" );
		String CNPJ = scan.next();
		System.out.println( "-nome fantasia:" );
		String nomeFantasia = scan.next();
		Empresa emp = new Empresa(CNPJ, nomeFantasia);
		
		empresas.add(emp);
		return emp;
	}
	private static Departamento criarDepartamento() {
		System.out.println( " #### REGISTRO DE NOVO DEPARTAMENTO ####" );
		System.out.println( " >Digite as seguintes informações abaixo " );
		System.out.println( "-nome do departamento:" );
		String nomeDep = scan.next();
		System.out.println( "-bloco:" );
		String bloco = scan.next();
		Departamento dep = new Departamento(nomeDep, bloco); 
		
		departamentos.add(dep);
		return dep;
	}
	private static Funcionario criarFuncionario() {
		System.out.println( " #### REGISTRO DE NOVO FUNCIONARIO ####" );
		System.out.println( " >Digite as seguintes informações abaixo " );
		System.out.println( "-nome:" );
		String nomeFunc = scan.next();
		System.out.println( "-salário(ex 1000.00):" );
		float salario = scan.nextFloat();
		System.out.println( "-data de admissão:" );
		String dtAdmissao = scan.next();
		Funcionario func = new Funcionario(nomeFunc, salario, dtAdmissao);
		
		funcionarios.add(func);
		return func;
	}
	//PRINT LISTAS
	private static void printEmpresas() {
		System.out.println( " ---- PRINTANDO EMPRESAS ---- " );
		printListaDeEmpresas(empresas);
	}
	private static void printListaDeEmpresas( ArrayList<Empresa> emps ) {
		for( int i=0; i<emps.size(); i++ ) {
			Empresa empI = emps.get(i);
			System.out.println( i + ".> " );
			System.out.println( "CNPJ: " + empI.getCNPJ() );
			System.out.println( "nome fantasia: " + empI.getNomeFantasia() );
		}
	}
	
	private static void printFuncionarios() {
		System.out.println( " ---- PRINTANDO FUNCIONARIOS ---- " );
		printListaDeFuncionarios(funcionarios);
	}
	private static void printListaDeFuncionarios( ArrayList<Funcionario> funcs ) {
		for( int i=0; i<funcs.size(); i++ ) {
			Funcionario funcI = funcionarios.get(i);
			System.out.println( i + ".> " );
			System.out.println( "nome: " + funcI.getNome() );
			System.out.println( "salario: " + funcI.getSalario() );
			System.out.println( "data admissão: " + funcI.getDtAdmissao() );
		}
	}
	
	private static void printDepartamentos() {
		System.out.println( " ---- PRINTANDO DEPARTAMENTOS ---- " );
		printListaDeDepartamentos(departamentos);
	}
	private static void printListaDeDepartamentos( ArrayList<Departamento> departamentos ) {
		for( int i=0; i<departamentos.size(); i++ ) {
			Departamento depI = departamentos.get(i);
			System.out.println( i + ".> " );
			System.out.println( "nome: " + depI.getNome() );
			System.out.println( "bloco: " + depI.getBloco() );
		}
	}
	//RELACIONAMENTO
	private static void relacionaDepartamentoFuncionario( Departamento dep, Funcionario func ) {
		dep.associarFuncionarios(func);
	}
	private static void relacionaEmpresaDepartamento( Empresa emp, Departamento func ) {
		emp.associarDepartamento( func );
	}
	
	public static void main(String[] args) {
		
		Funcionario func1 = criarFuncionario();
		Departamento dep1 = criarDepartamento();
		Empresa emp1 =  criarEmpresa();
		
		printEmpresas();
		printDepartamentos();
		printFuncionarios();
		
		relacionaDepartamentoFuncionario(dep1, func1);
		relacionaEmpresaDepartamento(emp1, dep1);
		
		//PRINTAR RELACIONAMENTOS
		//mostrar departamentos da empresa
		System.out.println( " ---- PRINTANDO DEPARTAMENTOS DA EMPRESA " + emp1.getNomeFantasia() + " ---- " );
		printListaDeDepartamentos( emp1.getDepartamentos() );
		System.out.println( " ---- PRINTANDO FUNCIONARIOS DO DEPARTAMENTO " + dep1.getNome()+", "+dep1.getBloco() + " ---- " );
		printListaDeFuncionarios( dep1.getFuncionarios() );
		
	}
	
}
