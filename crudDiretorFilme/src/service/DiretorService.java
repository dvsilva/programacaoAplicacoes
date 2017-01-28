package service;

import dao.DiretorDAO;
import dto.DiretorDTO;
import entity.Diretor;
import exception.DaoException;
import exception.ServiceException;
import exception.ServiceExceptionEnum;

public class DiretorService {
	private DiretorDAO dao;
	private DiretorDTO diretorDTO;

	public DiretorService() {
		this.dao = DiretorDAO.getInstance();
	}

	public DiretorDTO buscarDiretor(int codigo) throws DaoException {
		DiretorDTO filmeDTO = new DiretorDTO(dao.getDiretor(codigo).getCodigo(),
				dao.getDiretor(codigo).getNome());
		return filmeDTO;
	}

	public void cadastrarDiretor(DiretorDTO diretorDTO) throws ServiceException, DaoException {
		if ((diretorDTO.getCodigo() < 1) || (diretorDTO.getCodigo() > 99)) {
			System.out.println("DIRETOR_CODIGO_INVALIDO");
			throw new ServiceException(
					ServiceExceptionEnum.DIRETOR_CODIGO_INVALIDO);
		}
		if ((diretorDTO.getNome().length() < 1)
				|| (diretorDTO.getNome().length() > 20)) {
			System.out.println("FILME_NOME_INVALIDO");
			throw new ServiceException(ServiceExceptionEnum.FILME_NOME_INVALIDO);
		}
		Diretor diretor = new Diretor(diretorDTO.getCodigo(),
				diretorDTO.getNome());
		dao.addDiretor(diretor);
	}

	public void alterarDiretor(DiretorDTO diretorDTO) throws DaoException {
		if ((diretorDTO.getCodigo() < 1) || (diretorDTO.getCodigo() > 99)) {
			System.out.println("DIRETOR_CODIGO_INVALIDO");
		}
		if ((diretorDTO.getNome().length() < 1)
				|| (diretorDTO.getNome().length() > 20)) {
			System.out.println("FILME_NOME_INVALIDO");
		}

		Diretor diretor = new Diretor(diretorDTO.getCodigo(),
				diretorDTO.getNome());

		dao.updateDiretor(diretor);
	}

	public void removerDiretor(int codigo) throws DaoException {
		dao.removeDiretor(codigo);
	}
}
