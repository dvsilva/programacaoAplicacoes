package exception;

public enum ServiceExceptionEnum {

	PAIS_CODIGO_INVALIDO("C�digo de Pais inv�lido"), 
	PAIS_NOME_INVALIDO("Nome de Pais inv�lido"), 
	PAIS_CONTINENTE_INVALIDO("Nome de Pais inv�lido"), 
	PAIS_CAPITAL_INVALIDO("Capital de Pais inv�lido"), 
	PAIS_IDIOMA_INVALIDO("idioma de Pais inv�lido"), 
	PAIS_MOEDA_INVALIDO("Moeda de Pais inv�lido"),
	ESTADO_CODIGO_INVALIDO("C�digo do Estado inv�lido"), 
	ESTADO_NOME_INVALIDO("Nome do Estado inv�lido"),
	ESTADO_SIGLA_INVALIDO("Sigla do Estado inv�lido"), 
	ESTADO_CAPITAL_INVALIDO("Capital do Estado inv�lido"), 
	ESTADO_IDIOMA_INVALIDO("Idioma do Estado inv�lido");

	private ServiceExceptionEnum() {
		// TODO Auto-generated constructor stub
	}

	private ServiceExceptionEnum(String valor) {
		// TODO Auto-generated constructor stub
	}

}

