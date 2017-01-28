package exception;

public enum ServiceExceptionEnum {
	CLIENTE_CPF_INVALIDO("CPF do cliente inv�lido"), CLIENTE_NOME_INVALIDO("Nome do cliente inv�lido"),
	CLIENTE_SOBRENOME_INVALIDO("Sobrenome do cliente inv�lido"), CLIENTE_ESTADOCIVIL_INVALIDO ("Estado civil do cliente inv�lido"),
	CLIENTE_SEXO_INVALIDO ("Sexo do cliente inv�lido"),CLIENTE_CEP_INVALIDO("CEP do cliente inv�lido"), 
	CLIENTE_ENDERECO_INVALIDO("Endere�o do cliente inv�lido"),
	CONTA_CODIGO_INVALIDO("C�digo da conta inv�lida"), CONTA_AGENCIA_INVALIDA("Agencia da conta inv�lida"),
	CONTA_SALDO_INVALIDO("Saldo da conta inv�lido"), CONTA_TIPO_INVALIDA("Tipo de conta inv�lida");

	private String valor;
	
	private ServiceExceptionEnum() {
		// TODO Auto-generated constructor stub
	}

	private ServiceExceptionEnum(String valor) {
		this.valor = valor;
	}
	
	public String getValor(){
		return valor;
	}

}
