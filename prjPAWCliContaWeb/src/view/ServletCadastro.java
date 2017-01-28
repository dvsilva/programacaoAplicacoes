package view;

import java.io.IOException;
import java.util.Collection;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ClienteService;
import service.ContaService;
import dto.ClienteDTO;
import dto.ContaDTO;
import entity.EstadoCivil;
import entity.Sexo;
import entity.TipoConta;
import exception.DaoException;
import exception.ServiceException;

@WebServlet("/cadastro")
public class ServletCadastro extends HttpServlet{
	
	private int contContas = 0;
	private static ContaService contaService = new ContaService();
	private static ClienteService clienteService = new ClienteService(
			contaService);
	
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		long cpfl = Long.parseLong(request.getParameter("cpf"));
		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		int estadoCivilJsp = Integer.parseInt(request.getParameter("estadocivil"));
		int sexoJsp = Integer.parseInt(request.getParameter("sexo"));
		String cep = request.getParameter("cep");
		String endereco = request.getParameter("endereco");
		int conta = Integer.parseInt(request.getParameter("conta"));
		
		Sexo sexo = null;
		if (sexoJsp == 1) {
			sexo = Sexo.MASCULINO;
		} else {
			sexo = Sexo.FEMININO;
		}
		
		EstadoCivil estadoCivil = null;
		if (estadoCivilJsp == 1) {
			estadoCivil = EstadoCivil.SOLTEIRO;
		} else {
			if (estadoCivilJsp == 2) {
				estadoCivil = EstadoCivil.CASADO;
			} else {
				if (estadoCivilJsp == 3) {
					estadoCivil = EstadoCivil.DIVORCIADO;
				} else {
					estadoCivil = EstadoCivil.OUTROS;
				}
			}
		}
		
		criarCliente(cpfl, nome, sobrenome, sexo, estadoCivil,
				cep, endereco);
		
		String agencia = new String("AgPilares");
		int randomico = new Random().nextInt(10);
		int codigo = ++contContas + randomico;//código da conta é composto da qtd de contas existentes mais um número aleatório
		if (conta == 1)
			criarConta(codigo, agencia, 0L, TipoConta.CORRENTE,cpfl);
		else
			criarConta(codigo, agencia, 0L, TipoConta.POUPANCA,cpfl);
		
		RequestDispatcher rd = request.getRequestDispatcher("/paginamensagem.jsp");
		rd.forward(request,response);
		
	}
	
	private static void criarCliente(long cpf, String nome, String sobrenome,
			Sexo sexo, EstadoCivil estadoCivil, String cep, String endereco) {
		ClienteDTO clienteDTO = new ClienteDTO(cpf, nome, sobrenome, sexo, estadoCivil, cep, endereco);
		try {
			clienteService.cadastrarCliente(clienteDTO);
		} catch (ServiceException e) {
			//System.out.println(e.getTipo());
		} catch (DaoException e) {
			//System.out.println(e.getMessage());
		}

	}

	private static void criarConta(int codigo, String agencia, float saldo,
			TipoConta tipo, long cpf) {
		ContaDTO contaDTO = new ContaDTO(codigo, agencia, saldo, tipo, cpf);
		try {
			contaService.cadastrarConta(contaDTO);
		} catch (ServiceException e) {
			//System.out.println(e.getTipo());
		} catch (DaoException e) {
			//System.out.println(e.getMessage());
		}

		Collection<ClienteDTO> clientesCadastrados = null;
		try {
			clientesCadastrados = (Collection<ClienteDTO>) clienteService.buscarclientesDTO();
		} catch (DaoException e) {
			//e.printStackTrace();
		}
		for (ClienteDTO clienteDTO : clientesCadastrados) {
			if (contaDTO.getClienteCpf() == clienteDTO.getCpf())
				clienteDTO.adicionarContaDTO(codigo);
		}
		clienteService.adicionarContaCliente(cpf);
	}

}
