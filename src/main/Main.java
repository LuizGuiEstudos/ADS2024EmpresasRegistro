package main;

import java.util.ArrayList;
import java.util.Scanner;

import entities.Departamento;
import entities.Empresa;
import entities.Funcionario;

public class Main {
	
	private static Scanner scan = new Scanner(System.in);
	private static String SYMBOL_SCAN_IN = "<";
	private static String SYMBOL_SCAN_OUT = ">";
	private static String SYMBOL_SCAN_ASK = "-";
	
	
	private static ArrayList<Empresa> empresas = new ArrayList<Empresa>();
	private static ArrayList<Departamento> departamentos = new ArrayList<Departamento>();
	private static ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
	
	private static Funcionario selecionadoFuncionario;
	private static Departamento selecionadoDepartamento;
	private static Empresa selecionadoEmpresa;
	
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
		
		selecionadoEmpresa = emp;
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
		
		selecionadoDepartamento = dep;
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
		
		selecionadoFuncionario = func;
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
			printEmpresa(empI);
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
			printFuncionario(funcI);
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
			printDepartamento(depI);
			
		}
	}
	//PRINT INFORMACOES ENTIDADE
	//funcionario
	private static void printFuncionario( Funcionario func ) {
		System.out.println( "nome: " + func.getNome() );
		System.out.println( "salario: " + func.getSalario() );
		System.out.println( "data admissão: " + func.getDtAdmissao() );
	}
	//departamento
	private static void printDepartamento( Departamento dep ) {
		System.out.println( "nome: " + dep.getNome() );
		System.out.println( "bloco: " + dep.getBloco() );
	}
	//empresa
	private static void printEmpresa( Empresa emp ) {
		System.out.println( "CNPJ: " + emp.getCNPJ() );
		System.out.println( "nome fantasia: " + emp.getNomeFantasia() );
	}
	//RELACIONAMENTO
	//departamento < funcionario
	private static void relacionaDepartamentoFuncionario() {
		Funcionario func;
		Departamento dep;
		
		System.out.println( " ---- RELACIONANDO FUNCIONARIO COM DEPARTAMENTO ---- " );
		func = selecionaFuncionario();
		selecionadoFuncionario = func;
		
		dep = selecionaDepartamento();
		selecionadoDepartamento = dep;
		
		relaciona_diretoDepartamentoFuncionario(dep, func);
		
		System.out.println( ">Funcionário " + func.getNome() + "associado ao Departamento: " + dep.getNome() + " " + dep.getBloco()  );
	}
	
	private static void relaciona_diretoDepartamentoFuncionario( Departamento dep, Funcionario func ) {
		dep.associarFuncionarios(func);
	}
	//empresa < departamento
	private static void relacionaEmpresaDepartamento() {
		Departamento dep;
		Empresa emp;
		
		System.out.println( " ---- RELACIONANDO FUNCIONARIO COM DEPARTAMENTO ---- " );
		dep = selecionaDepartamento();
		selecionadoDepartamento = dep;
		
		emp = selecionaEmpresa();
		selecionadoEmpresa = emp;
		
		relaciona_diretoEmpresaDepartamento(emp, dep);
		
		System.out.println( ">Departamento " + dep.getNome() + " " + dep.getBloco() + " associado a Empresa: " + emp.getNomeFantasia() );
	}
	private static void relaciona_diretoEmpresaDepartamento( Empresa emp, Departamento func ) {
		emp.associarDepartamento( func );
	}
	
	//BUSCA
	//funcionario
	private static Funcionario selecionaFuncionario() 
	{
		Funcionario funcToReturn;
		int indice;
		
		System.out.println( " ---- SELEÇÃO DE FUNCIONARIO ---- " );
		printFuncionarios();
		
		System.out.println();
		System.out.println( "-Selecione o indice do Funcionário desejado, apresentado acima: " );
		System.out.println(SYMBOL_SCAN_IN);
		indice = scan.nextInt();
		funcToReturn = funcionarios.get(indice);
		
		return funcToReturn;
	}
	//departamento
	private static Departamento selecionaDepartamento() {
		Departamento depToReturn;
		int indice;
		
		System.out.println( " ---- SELEÇÃO DE DEPARTAMENTO ---- " );
		printDepartamentos();
		System.out.println();
		System.out.println( "-Selecione o indice do Departamento desejado, apresentado acima: " );
		System.out.println(SYMBOL_SCAN_IN);
		indice = scan.nextInt();
		depToReturn = departamentos.get(indice);
		
		return depToReturn;
	}
	//empresa
	private static Empresa selecionaEmpresa() {
		Empresa empToReturn;
		int indice;
		
		System.out.println( " ---- SELEÇÃO DE EMPRESA ---- " );
		printEmpresas();
		
		System.out.println();
		System.out.println( "-Selecione o indice da Empresa desejada, apresentado acima: " );
		System.out.println(SYMBOL_SCAN_IN);
		indice = scan.nextInt();
		empToReturn = empresas.get(indice);
		
		return empToReturn;
	}
	//INFORMA
	private static void informaFuncionario() {
		selecionaFuncionario();
		System.out.println( ">informações sobre o Funcionário selecionado: "  );
		printFuncionario( selecionadoFuncionario );
	}
	private static void informaDepartamento() {
		selecionaDepartamento();
		System.out.println( ">informações sobre o Departamento selecionado: "  );
		printDepartamento( selecionadoDepartamento );
		System.out.println( " funcionários pertencentes:" );
		printListaDeFuncionarios( selecionadoDepartamento.getFuncionarios() );
		
	}
	private static void informaEmpresa() {
		selecionaEmpresa();
		System.out.println( ">Informações sobre a Empresa selecionado: "  );
		printEmpresa( selecionadoEmpresa );
		System.out.println( " departamentos pertencentes:" );
		printListaDeDepartamentos( selecionadoEmpresa.getDepartamentos() );
	}
	//AUMENTO
	private static void aumentoSalario(){
		for( int i=0; i<funcionarios.size(); i++) {
			Funcionario funcI = funcionarios.get(i);
			float funcISal = funcI.getSalario();
			funcISal += funcISal * .1; 
			funcI.setSalario(funcISal);
		}
	}
	
	public static void main(String[] args) { //MAIN
		
		//LOOP - PANEL
		String cmd = "";
		String cmdQuit = "0";
		
		System.out.println(" >INICIANDO PAINEL DE AÇÕES... ");
		while( !cmd.equals(cmdQuit) ) {
			System.out.println();
			System.out.println();
			System.out.println();
			
			//acoes possiveis: adicionar *, listar *
			System.out.println( " Escolha as seguintes ações: 1-Adionar Funcionário, 2-Adicionar Departamento, 3-Adicionar Empresa \n" +
					" 4-Listar Funcionarios, 5-Listar Departamentos, 6-Listar Empresas \n" +
					" 7-Relacionar Funcionario com Departamento, 8-Relacionar Departamento com Empresa\n" +
					" 9-Selecionar e ver informações de Funcionário, 10-Selecionar e ver informações de Departamento, 11-Selecionar e ver infomações de Empresa" +
					" 12-Aumentar salário em 10% de todos os funcionários " +
					" 0-sair");
			System.out.print("<");
			cmd = scan.next();
			switch( cmd ) {
			case "0":
				System.out.println(">saindo..."); break;
			case "1": 
				criarFuncionario(); break;
			case "2": 
				criarDepartamento(); break;
			case "3":
				criarEmpresa();break;
				
			case "4":
				printFuncionarios();break;
			case "5": 
				printDepartamentos();break;
			case "6": 
				printEmpresas();break;
			case "7":
				relacionaDepartamentoFuncionario(); break;
			case "8":
				relacionaEmpresaDepartamento(); break;
			
			case "9":
				informaFuncionario(); break;
			case "10":
				informaDepartamento(); break;
			case "11":
				informaEmpresa(); break;
			case "12":
				aumentoSalario();
				
			} 

		}
		
	}
	
}
