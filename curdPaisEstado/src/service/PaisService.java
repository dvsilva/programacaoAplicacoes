package service;

import java.util.Collection;

import dao.PaisDAO;
import dto.PaisDTO;
import entity.Pais;
import exception.DaoException;
import exception.ServiceException;
import exception.ServiceExceptionEnum;

public class PaisService {
	private PaisDAO dao;

	public PaisService() {
		this.dao = PaisDAO.getInstance();
	}

	public PaisService(EstadoService estadoService) {
		// TODO Auto-generated constructor stub
	}

	public PaisDTO buscarPais(int codigo) throws DaoException {
		try{
			PaisDTO paisDTO = new PaisDTO(dao.getPais(codigo).getCodigo(), dao.getPais(codigo).getNome(), dao.getPais(codigo).getCapital(), 
					dao.getPais(codigo).getContinente(),dao.getPais(codigo).getIdioma(), dao.getPais(codigo).getMoeda(), 
					dao.getPais(codigo).getArea());
			return paisDTO;
		}
		catch(DaoException e)
		{
			throw new DaoException("Não há Pais com o código informado");
		}
	}

	public void cadastrarPais(PaisDTO paisDTO) throws ServiceException,
			DaoException {
		if ((paisDTO.getCodigo() < 1) || (paisDTO.getCodigo() > 99)) {
			throw new ServiceException(ServiceExceptionEnum.PAIS_CODIGO_INVALIDO);
		}
		if ((paisDTO.getNome().length() < 1) || (paisDTO.getNome().length() > 20)) {
			throw new ServiceException(ServiceExceptionEnum.PAIS_NOME_INVALIDO);
		}
		if ((paisDTO.getContinente().length() < 1) || (paisDTO.getContinente().length() > 30)) {
			throw new ServiceException(ServiceExceptionEnum.PAIS_CONTINENTE_INVALIDO);
		}
		if ((paisDTO.getCapital().length() < 1) || (paisDTO.getCapital().length() > 30)) {
			throw new ServiceException(ServiceExceptionEnum.PAIS_CAPITAL_INVALIDO);
		}
		if ((paisDTO.getIdioma().length() < 1) || (paisDTO.getIdioma().length() > 20)) {
			throw new ServiceException(ServiceExceptionEnum.PAIS_IDIOMA_INVALIDO);
		}
		if ((paisDTO.getMoeda().length() < 1)
				|| (paisDTO.getMoeda().length() > 30)) {
			throw new ServiceException(ServiceExceptionEnum.PAIS_MOEDA_INVALIDO);
		}	
		
		Pais pais = new Pais(paisDTO.getCodigo(), paisDTO.getNome(), paisDTO.getContinente(), paisDTO.getCapital(), paisDTO.getIdioma(), 
				paisDTO.getMoeda(), paisDTO.getArea());

		
		try {
			dao.addPais(pais);
		} catch (DaoException e) {
			throw new DaoException("Erro no banco de dados");
		}
	}

	public void alterarPais(PaisDTO paisDTO) throws ServiceException,
			DaoException {
		if ((paisDTO.getCodigo() < 1) || (paisDTO.getCodigo() > 99)) {
			throw new ServiceException(ServiceExceptionEnum.PAIS_CODIGO_INVALIDO);
		}
		if ((paisDTO.getNome().length() < 1) || (paisDTO.getNome().length() > 20)) {
			throw new ServiceException(ServiceExceptionEnum.PAIS_NOME_INVALIDO);
		}
		if ((paisDTO.getContinente().length() < 1) || (paisDTO.getContinente().length() > 30)) {
			throw new ServiceException(ServiceExceptionEnum.PAIS_CONTINENTE_INVALIDO);
		}
		if ((paisDTO.getCapital().length() < 1) || (paisDTO.getCapital().length() > 30)) {
			throw new ServiceException(ServiceExceptionEnum.PAIS_CAPITAL_INVALIDO);
		}
		if ((paisDTO.getIdioma().length() < 1) || (paisDTO.getIdioma().length() > 20)) {
			throw new ServiceException(ServiceExceptionEnum.PAIS_IDIOMA_INVALIDO);
		}
		if ((paisDTO.getMoeda().length() < 1)
				|| (paisDTO.getMoeda().length() > 30)) {
			throw new ServiceException(ServiceExceptionEnum.PAIS_MOEDA_INVALIDO);
		}	
		
		Pais pais = new Pais(paisDTO.getCodigo(), paisDTO.getNome(), paisDTO.getContinente(), paisDTO.getCapital(), paisDTO.getIdioma(), 
				paisDTO.getMoeda(), paisDTO.getArea());


		try {
			dao.updatePais(pais);
		} catch (DaoException e) {
			throw new DaoException("Erro no banco de dados");
		}
	}

	public void removerPais(int codigo) throws DaoException {
		try {
			dao.removePais(codigo);
		}
		catch(DaoException e)
		{
			throw new DaoException("Não há curso com o código informado");
		}
	}
}
