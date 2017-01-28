package service;

import dao.FilmeDAO;
import dto.FilmeDTO;
import entity.Filme;
import exception.DaoException;
import exception.ServiceException;
import exception.ServiceExceptionEnum;


public class FilmeService {
	private FilmeDAO dao;
	private FilmeDTO filmeDTO;

	public FilmeService() {
		this.dao = FilmeDAO.getInstance();
	}

	public FilmeDTO buscarFilme(int codigo) throws DaoException {
		FilmeDTO filmeDTO = new FilmeDTO(dao.getFilme(codigo).getCodigo(), dao
				.getFilme(codigo).getNome(),dao.getFilme(codigo).getCodDiretor());
		return filmeDTO;
	}

	public void cadastrarFilme(FilmeDTO filmeDTO) throws ServiceException {
		if ((filmeDTO.getCodigo() < 1) || (filmeDTO.getCodigo() > 99)) {
			System.out.println("FILME_CODIGO_INVALIDO");
			throw new ServiceException(
					ServiceExceptionEnum.FILME_CODIGO_INVALIDO);
		}
		if ((filmeDTO.getNome().length() < 1) || (filmeDTO.getNome().length() > 20)) {
			System.out.println("FILME_NOME_INVALIDO");
			throw new ServiceException(ServiceExceptionEnum.FILME_NOME_INVALIDO);
		}
		}
		
		Filme filme = new Filme(filmeDTO.getCodigo(), filmeDTO.getNome(),filmeDTO.getcodDiretor());{

		dao.addFilme(filme);
		
	}

	public void alterarFilme(FilmeDTO filmeDTO) throws DaoException{
		if ((filmeDTO.getCodigo() < 1) || (filmeDTO.getCodigo() > 99)) {
			System.out.println("FILME_CODIGO_INVALIDO");
		}
		if ((filmeDTO.getNome().length() < 1) || (filmeDTO.getNome().length() > 20)) {
			System.out.println("FILME_NOME_INVALIDO");
		}

		Filme filme = new Filme(filmeDTO.getCodigo(), filmeDTO.getNome(),filmeDTO.getcodDiretor());

		dao.updateFilme(filme);
	}

	public void removerFilme(int codigo) throws DaoException {
		dao.removeFilme(codigo);
	}
	}
	
