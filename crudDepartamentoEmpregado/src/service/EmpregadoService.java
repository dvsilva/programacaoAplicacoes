package service;

import java.util.Collection;

import dao.EmpresaDAO;
import dto.EmpregadoDTO;
import entity.Empregado;
import exception.DaoException;
import exception.ServiceException;
import exception.ServiceExceptionEnum;

public class EmpregadoService {
	private EmpresaDAO dao;

	public EmpregadoService() {
		this.dao = EmpresaDAO.getInstance();
	}

	public EmpregadoDTO buscarEmpregado(int codigo) throws DaoException {
		try {
			EmpregadoDTO EmpregadoDTO = new EmpregadoDTO(
					dao.getEmpregado(codigo).getCodigo(), dao.getEmpregado(codigo).getNome(),
					dao.getEmpregado(codigo).getIdade(), dao.getEmpregado(codigo).getDepartamento().getCodigo());
			return EmpregadoDTO;
		} catch (DaoException e) {
			throw new DaoException("Não há Empregado com o código informado");
		}
	}

	public void cadastrarEmpregado(EmpregadoDTO EmpregadoDTO)
			throws ServiceException, DaoException {
		if ((EmpregadoDTO.getCodigo() < 1) && (EmpregadoDTO.getCodigo() > 1000)) {
			throw new ServiceException(
					ServiceExceptionEnum.EMPREGADO_CODIGO_INVALIDO);
		}
		if ((EmpregadoDTO.getNome().length() < 1)
				|| (EmpregadoDTO.getNome().length() > 20)) {
			throw new ServiceException(
					ServiceExceptionEnum.EMPREGADO_NOME_INVALIDO);
		}
		//Alterar
		Empregado Empregado = new Empregado(EmpregadoDTO.getCodigo(),EmpregadoDTO.getNome(),
				EmpregadoDTO.getIdade(), EmpresaDAO.getDepartamento(EmpregadoDTO.getCodDepartamento()));

		try {
			dao.addEmpregado(Empregado);
		} catch (DaoException e) {
			throw new DaoException("Erro no banco de dados");
		}
	}

	public void alterarEmpregado(EmpregadoDTO EmpregadoDTO) throws ServiceException,
			DaoException {
		if ((EmpregadoDTO.getCodigo() < 1) && (EmpregadoDTO.getCodigo() > 1000)){
			throw new ServiceException(
					ServiceExceptionEnum.EMPREGADO_CODIGO_INVALIDO);
		}
		if ((EmpregadoDTO.getNome().length() < 1)
				|| (EmpregadoDTO.getNome().length() > 20)) {
			throw new ServiceException(
					ServiceExceptionEnum.EMPREGADO_NOME_INVALIDO);
		}
		//Alterar...
		Empregado Empregado = new Empregado(EmpregadoDTO.getCodigo(),EmpregadoDTO.getNome(),
				EmpregadoDTO.getIdade(), EmpresaDAO.getDepartamento(EmpregadoDTO.getCodDepartamento()));

		try {
			dao.updateEmpregado(Empregado);
		} catch (DaoException e) {
			throw new DaoException("Erro no banco de dados");
		}
	}

	public void removerEmpregado(int cpf) throws DaoException {
		try {
			dao.removeEmpregado(cpf);
		} catch (DaoException e) {
			throw new DaoException("Não há Empregado com o código informado");
		}
	}
	
	public Collection<Empregado> buscarEmpregados() throws DaoException {
		return dao.getEmpregados();
	}
}
