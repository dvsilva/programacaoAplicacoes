<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style= "background: url(imagens/BackgroundPILARES.jpg) no-repeat;" >
	<table></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br>
		<%@ page import= "java.util.Collection" %>
		<%@ page import= "service.ContaService"%>
		<%@ page import= "service.ClienteService"%>
		<%@ page import= "dto.ClienteDTO"%>
		<%@ page import= "dto.ContaDTO"%>
		<%@ page import= "entity.EstadoCivil"%>
		<%@ page import= "entity.Sexo"%>
		<%@ page import= "exception.DaoException"%>
		<%
		%>
		<tr>
			<td><%="Nome "%></td>
			<td><%="Sobrenome "%></td>
			<td><%="Sexo "%></td>
			<td><%="CPF "%></td>
			<td><%="Est. Civil "%></td>
			<td><%="Endereço "%></td>
			<td><%="CEP "%></td>
		</tr>
	<%
		ContaService contaService = new ContaService();
		ClienteService clienteService = new ClienteService(contaService);
		Collection<ClienteDTO> clientes = null;
		Collection<Integer> codContas = null;
		ContaDTO contaDTO = new ContaDTO();
		try {
			clientes = (Collection<ClienteDTO>) clienteService.buscarclientesDTO();
		} catch (DaoException e) {
			e.printStackTrace();
		}
	
		for (ClienteDTO clienteDTO : clientes) {
			String sexo = null;
			String estadoCivil = null;
			if (clienteDTO.getSexo() == Sexo.MASCULINO) {
				sexo = "MASCULINO";
				if (clienteDTO.getEstadoCivil() == EstadoCivil.SOLTEIRO) {
					estadoCivil = "SOLTEIRO";
				} else {
					if (clienteDTO.getEstadoCivil() == EstadoCivil.CASADO) {
						estadoCivil = "CASADO";
					} else {
						if (clienteDTO.getEstadoCivil() == EstadoCivil.DIVORCIADO) {
							estadoCivil = "DIVORCIADO";
						} else {
							estadoCivil = "OUTROS";
						}
					}
				}
			} else {
				if (clienteDTO.getSexo() == Sexo.FEMININO) {
					sexo = "FEMININO";
					if (clienteDTO.getEstadoCivil() == EstadoCivil.SOLTEIRO) {
						estadoCivil = "SOLTEIRA";
					} else {
						if (clienteDTO.getEstadoCivil() == EstadoCivil.CASADO) {
							estadoCivil = "CASADA";
						} else {
							if (clienteDTO.getEstadoCivil() == EstadoCivil.DIVORCIADO) {
								estadoCivil = "DIVORCIADA";
							} else {
								estadoCivil = "OUTROS";
							}
						}
					}
				}
			}

			codContas = (Collection<Integer>) clienteDTO.getCodContas();
	//criar aki os nomes dos campos da grid
	
			for (int i : codContas) {
				try {
					contaDTO = contaService.buscarConta(i);
					%>
					<tr>
						<td><%=clienteDTO.getNome()%></td>
						<td><%=clienteDTO.getSobrenome()%></td>
						<td><%=sexo%></td>
						<td><%=String.valueOf(clienteDTO.getCpf())%></td>
						<td><%=estadoCivil%></td>
						<td><%=clienteDTO.getEndereco()%></td>
						<td><%=clienteDTO.getCep()%></td>
						<td><%=String.valueOf(String.format("%05d", contaDTO.getCodigo()))%></td>
						<td><%=String.valueOf(contaDTO.getSaldo())%></td>
					</tr>
				<%} catch (DaoException e) {
					e.printStackTrace();
				}
			}
		}	
		%>
	</table>		

</body>
</html>