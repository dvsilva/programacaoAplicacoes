package service;

import java.util.Collection;

import dao.EmpresaDAO;
import dto.DepartamentoDTO;
import entity.Departamento;
import exception.DaoException;
import exception.ServiceException;
import exception.ServiceExceptionEnum;

public class DepartamentoService {
	private EmpresaDAO dao;

	public DepartamentoService() {
		this.dao = EmpresaDAO.getInstance();
	}

	public DepartamentoDTO buscarDepartamento(int codigo) throws DaoException {
		try {
			DepartamentoDTO DepartamentoDTO = new DepartamentoDTO(
					dao.getDepartamento(codigo).getCodigo(), dao.getDepartamento(codigo).getSigla(),
					dao.getDepartamento(codigo).getNome());
			return DepartamentoDTO;
		} catch (DaoException e) {
			throw new DaoException("Não há Departamento com o código informado");
		}
	}

	public void cadastrarDepartamento(DepartamentoDTO DepartamentoDTO)
			throws ServiceException, DaoException {
		if (DepartamentoDTO.getCodigo() < 1) {
			throw new ServiceException(
					ServiceExceptionEnum.DEPARTAMENTO_CODIGO_INVALIDO);
		}
		if ((DepartamentoDTO.getNome().length() < 1)
				|| (DepartamentoDTO.getNome().length() > 20)) {
			throw new ServiceException(
					ServiceExceptionEnum.DEPARTAMENTO_NOME_INVALIDO);
		}

		Departamento Departamento = new Departamento(DepartamentoDTO.getCodigo(),DepartamentoDTO.getSigla(), DepartamentoDTO.getNome());

		try {
			dao.addDepartamento(Departamento);
		} catch (DaoException e) {
			throw new DaoException("Erro no banco de dados");
		}
	}

	public void alterarDepartamento(DepartamentoDTO DepartamentoDTO) throws ServiceException,
			DaoException {
		if (DepartamentoDTO.getCodigo()< 1){
			throw new ServiceException(
					ServiceExceptionEnum.DEPARTAMENTO_CODIGO_INVALIDO);
		}
		if ((DepartamentoDTO.getNome().length() < 1)
				|| (DepartamentoDTO.getNome().length() > 20)) {
			throw new ServiceException(
					ServiceExceptionEnum.DEPARTAMENTO_NOME_INVALIDO);
		}

		Departamento Departamento = new Departamento(DepartamentoDTO.getCodigo(),DepartamentoDTO.getSigla(), DepartamentoDTO.getNome());

		try {
			dao.updateDepartamento(Departamento);
		} catch (DaoException e) {
			throw new DaoException("Erro no banco de dados");
		}
	}

	public void removerDepartamento(int codigo) throws DaoException {
		try {
			dao.removeDepartamento(codigo);
		} catch (DaoException e) {
			throw new DaoException("Não há Departamento com o código informado");
		}
	}
	
	public Collection<Departamento> buscarDepartamentos() throws DaoException {
		return dao.getDepartamentos();
	}
}
