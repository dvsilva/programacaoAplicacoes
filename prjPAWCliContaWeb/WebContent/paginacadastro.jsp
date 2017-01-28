<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Cliente</title>
</head>
<body style= "background: url(imagens/BackgroundPILARES.jpg) no-repeat;" >
	<form action="cadastro"></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br>
		CPF : <input type="text" name="cpf"/><br>
		</br>
		Nome : <input type="text" name="nome"/><br>
		</br>
		Sobrenome : <input type="text" name="sobrenome"/><br>
		</br>
		
		Estado Civil : <select type="text" name="estadocivil"> 
	      	<option value="1">Solteiro</option>
	      	<option value="2">Casado</option>
	      	<option value="3">Divorciado</option>
	      	<option value="4">Outros</option> 
      	</select><br>
		Sexo : <select type="text" name="sexo"> 
	      	<option value="1">Masculino</option>
	      	<option value="2">Feminino</option>
	      	
      	</select><br>
		CEP : <input type="text" name="cep"/><br>
		</br>
		Endereço : <input type="text" name="endereco"/><br>
		</br>
		
		Vincular Conta : <select type="text" name="conta"> 
	      	<option value="1">Conta Corrente</option>
	      	<option value="2">Conta Poupança</option>
		<br>
		</br>
		<input type="submit" value="Salvar"/>
	</form>
</body>
</html>