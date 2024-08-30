package main;

import java.util.ArrayList;
import java.util.Scanner;

import entities.Aviao;
import entities.Departamento;
import entities.Empresa;
import entities.Funcionario;

public class Main {
	
	private static Scanner scan = new Scanner(System.in);
	
	private static ArrayList<Empresa> empresas = new ArrayList<Empresa>();
	private static ArrayList<Departamento> departamentos = new ArrayList<Departamento>();
	private static ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
	

	public static void main(String[] args) {
		
		//CRIAR ENTIDADES
		//empresa
		System.out.println( " #### REGISTRO DE NOVA EMPRESA ####" );
		System.out.println( " >Digite as seguintes informações abaixo " );
		System.out.println( "-CNPJ:" );
		String CNPJ = scan.next();
		System.out.println( "-nome fantasia:" );
		String nomeFantasia = scan.next();
		Empresa emp = new Empresa(CNPJ, nomeFantasia);
		
		empresas.add(emp);
		//departamento
		System.out.println( " #### REGISTRO DE NOVO DEPARTAMENTO ####" );
		System.out.println( " >Digite as seguintes informações abaixo " );
		System.out.println( "-nome do departamento:" );
		String nomeDep = scan.next();
		System.out.println( "-bloco:" );
		String bloco = scan.next();
		Departamento dep = new Departamento(nomeDep, bloco); 
		
		departamentos.add(dep);
		//funcionario
		System.out.println( " #### REGISTRO DE NOVO DEPARTAMENTO ####" );
		System.out.println( " >Digite as seguintes informações abaixo " );
		System.out.println( "-nome do funcionário:" );
		String nomeFunc = scan.next();
		System.out.println( "-salário(ex 1000.00):" );
		float salario = scan.nextFloat();
		System.out.println( "-data de admissão:" );
		String dtAdmissao = scan.next();
		Funcionario func = new Funcionario(nomeFunc, salario, dtAdmissao);
		
		funcionarios.add(func);
		//PRINT LISTAS
		//empresas
		System.out.println( " ---- PRINTANDO EMPRESAS ---- " );
		for( int i=0; i<empresas.size(); i++ ) {
			Empresa empI = empresas.get(i);
			System.out.println( i + ".> " );
			System.out.println( "CNPJ:" + empI.getCNPJ() );
			System.out.println( "nome fantasia:" + empI.getNomeFantasia() );
		}
		//empresas
				System.out.println( " ---- PRINTANDO EMPRESAS ---- " );
				for( int i=0; i<empresas.size(); i++ ) {
					Empresa empI = empresas.get(i);
					System.out.println( i + ".> " );
					System.out.println( "CNPJ:" + empI.getCNPJ() );
					System.out.println( "nome fantasia:" + empI.getNomeFantasia() );
				}
		//CONTINUAR - terminar de printar as entidade
				//relaciona-los
	}
	
}
