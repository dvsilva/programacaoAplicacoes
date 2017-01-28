package service;

import view.JanelaEstado;
import dao.EstadoDAO;
import dto.EstadoDTO;
import entity.Estado;
import exception.DaoException;
import exception.ServiceException;
import exception.ServiceExceptionEnum;

public class EstadoService {
	private EstadoDAO dao;
	private JanelaEstado jEstado;

	public EstadoService() {
		this.dao = EstadoDAO.getInstance();
	}

	public EstadoDTO buscarEstado(int codigo) throws DaoException {
		try{
			EstadoDTO estadoDTO = new EstadoDTO(dao.getEstado(codigo).getCodigo(), dao.getEstado(codigo).getNome(), 
					dao.getEstado(codigo).getSigla(), dao.getEstado(codigo).getCapital(), dao.getEstado(codigo).getRegiao());
			return estadoDTO;
		}
		catch(DaoException e)
		{
			throw new DaoException("Não há um Estado com o código informado");
		}
	}

	public void cadastrarEstado(EstadoDTO estadoDTO) throws ServiceException,
			DaoException {
		
		if ((estadoDTO.getCodigo() < 1) || (estadoDTO.getCodigo() > 99)) {
			throw new ServiceException(ServiceExceptionEnum.ESTADO_CODIGO_INVALIDO);
		}	
		if ((estadoDTO.getNome().length() < 1) || (estadoDTO.getNome().length() > 20)) {
			throw new ServiceException(ServiceExceptionEnum.ESTADO_NOME_INVALIDO);
		}
		if ((estadoDTO.getSigla().length() < 1) || (estadoDTO.getNome().length() > 3)) {
			throw new ServiceException(ServiceExceptionEnum.ESTADO_SIGLA_INVALIDO);
		}
		if ((estadoDTO.getCapital().length() < 1) || (estadoDTO.getCapital().length() > 20)) {
			throw new ServiceException(ServiceExceptionEnum.ESTADO_CAPITAL_INVALIDO);
		}
		if ((estadoDTO.getRegiao().length() < 1) || (estadoDTO.getRegiao().length() > 20)) {
			throw new ServiceException(ServiceExceptionEnum.ESTADO_IDIOMA_INVALIDO);
		}
		
	
				
		Estado estado = new Estado(estadoDTO.getCodigo(), estadoDTO.getNome(), estadoDTO.getSigla(), estadoDTO.getCapital(),
				estadoDTO.getRegiao());

		
		try {
			dao.addEstado(estado);
		} catch (DaoException e) {
			throw new DaoException("Erro no banco de dados");
		}
		
	}

	public void alterarEstado(EstadoDTO estadoDTO) throws ServiceException,
			DaoException {
		if ((estadoDTO.getCodigo() < 1) || (estadoDTO.getCodigo() > 99)) {
			throw new ServiceException(ServiceExceptionEnum.ESTADO_CODIGO_INVALIDO);
		}	
		if ((estadoDTO.getNome().length() < 1) || (estadoDTO.getNome().length() > 20)) {
			throw new ServiceException(ServiceExceptionEnum.ESTADO_NOME_INVALIDO);
		}
		if ((estadoDTO.getSigla().length() < 1) || (estadoDTO.getNome().length() > 3)) {
			throw new ServiceException(ServiceExceptionEnum.ESTADO_SIGLA_INVALIDO);
		}
		if ((estadoDTO.getCapital().length() < 1) || (estadoDTO.getCapital().length() > 20)) {
			throw new ServiceException(ServiceExceptionEnum.ESTADO_CAPITAL_INVALIDO);
		}
		if ((estadoDTO.getRegiao().length() < 1) || (estadoDTO.getRegiao().length() > 20)) {
			throw new ServiceException(ServiceExceptionEnum.ESTADO_IDIOMA_INVALIDO);
		}
				
		Estado estado = new Estado(estadoDTO.getCodigo(), estadoDTO.getNome(), estadoDTO.getSigla(), estadoDTO.getCapital(),
				estadoDTO.getRegiao());


		try {
			dao.updateEstado(estado);
		} catch (DaoException e) {
			throw new DaoException("Erro no banco de dados");
		}
	}

	public void removerEstado(int codigo) throws DaoException {
		try {
			dao.removeEstado(codigo);
		}
		catch(DaoException e)
		{
			throw new DaoException("Não há um Estado com o código informado");
		}
	}
}
