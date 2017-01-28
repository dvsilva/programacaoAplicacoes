package main;

import java.util.Scanner;

import service.DiretorService;
import service.FilmeService;
import dao.FilmeDAO;
import dto.DiretorDTO;
import dto.FilmeDTO;
import entity.Diretor;
import entity.Filme;
import exception.DaoException;
import exception.ServiceException;

public class Programa {
	private static FilmeDAO FilmeDAO;
	private static Scanner teclado;

	private static FilmeService filmeService = new FilmeService();
	private static DiretorService diretorService = new DiretorService();

	public static void main(String[] args) throws ServiceException {
		teclado = new Scanner(System.in);
		int op = 0;

		do {
			System.out.println("Escolha a operação desejada:");
			System.out.println("1-Criar filme");
			System.out.println("2-Buscar filme");
			System.out.println("3-Alterar filme");
			System.out.println("4-Remover filme");
			System.out.println("5-Sair");
			System.out.println("");

			op = new Scanner(System.in).nextInt();

			if (op == 1) {
				System.out.println("Informe o código do filme: ");
				int codigo = new Scanner(System.in).nextInt();
				System.out.println("Informe o nome do filme: ");
				String nome = new Scanner(System.in).nextLine();
				System.out.println("Informe o genero do filme: ");
				String genero = new Scanner(System.in).nextLine();
				System.out.println("Informe o diretor do filme: ");
				int diretor = new Scanner(System.in).nextInt();
				criarFilme(codigo, nome, genero, diretor);
			} else if (op == 2) {
				System.out.println("Informe o código do filme: ");
				int codigo = new Scanner(System.in).nextInt();
				System.out.println(buscarFilme(codigo));
			} else if (op == 3) {
				System.out.println("Informe o código do filme: ");
				int codigo = new Scanner(System.in).nextInt();
				System.out.println("Informe o nome do filme: ");
				String nome = new Scanner(System.in).nextLine();
				System.out.println("Informe o código do Diretor: ");
				int codigoDiretor = new Scanner(System.in).nextInt();
				System.out.println("Informe o nome do Diretor: ");
				String nomeDiretor = new Scanner(System.in).nextLine();
				System.out.println("Informe o genero do filme: ");
				String genero = new Scanner(System.in).nextLine();
				System.out.println("Informe o codigo do diretor do filme: ");
				int codDiretor = new Scanner(System.in).nextInt();
				alterarFilme(codigo, nome, genero, new Diretor(codigoDiretor,
						nomeDiretor));
			} else if (op == 4) {
				System.out.println("Informe o código do filme: ");
				int codigo = teclado.nextInt();
				removerFilme(codigo);
			} else if (op == 5) {
				System.out.println("Aplicação encerrada");
			} else {
				System.out.println("Digite um número válido");
			}

		} while (op != 5);
	}

	// Criar Filme ou Diretor
	private static void criarFilme(int codigo, String nome, String genero,
			int codDiretor) throws ServiceException {
		FilmeDTO filmeDTO = new FilmeDTO(codigo, nome, codDiretor);
		filmeService.cadastrarFilme(filmeDTO);

	}

	public static void criarDiretor(int codigo, String nome, String genero,
			Diretor diretor) throws ServiceException, DaoException {
		DiretorDTO diretorDTO = new DiretorDTO(codigo, nome);
		diretorService.cadastrarDiretor(diretorDTO);

	}

	// Buscar Filme ou Diretor
	public static String buscarFilme(int codigo) {

		try {
			FilmeDTO filme = filmeService.buscarFilme(codigo);
			return "Código: " + filme.getCodigo() + " / Nome: "
					+ filme.getNome() + filme.getcodDiretor();
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

	public static String buscarDiretor(int codigo) {

		try {
			DiretorDTO diretor = diretorService.buscarDiretor(codigo);
			return "Código: " + diretor.getCodigo() + " / Nome: "
					+ diretor.getNome();
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

	// Alterar Filme ou Diretor

	public static void alterarFilme(int codigo, String nome, String genero,
			Diretor diretor) {
	}

	public static void alterarDiretor(int codigo, String nome, String genero,
			Filme filme) {
	}

	// Remover Filme ou Diretor

	public static void removerFilme(int codigo) {

		try {
			filmeService.removerFilme(codigo);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void removerDiretor(int codigo) {

		try {
			diretorService.removerDiretor(codigo);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
		}

	}

}
