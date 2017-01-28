package exception;

public enum ServiceExceptionEnum {

	PAIS_CODIGO_INVALIDO("Código de Pais inválido"), 
	PAIS_NOME_INVALIDO("Nome de Pais inválido"), 
	PAIS_CONTINENTE_INVALIDO("Nome de Pais inválido"), 
	PAIS_CAPITAL_INVALIDO("Capital de Pais inválido"), 
	PAIS_IDIOMA_INVALIDO("idioma de Pais inválido"), 
	PAIS_MOEDA_INVALIDO("Moeda de Pais inválido"),
	ESTADO_CODIGO_INVALIDO("Código do Estado inválido"), 
	ESTADO_NOME_INVALIDO("Nome do Estado inválido"),
	ESTADO_SIGLA_INVALIDO("Sigla do Estado inválido"), 
	ESTADO_CAPITAL_INVALIDO("Capital do Estado inválido"), 
	ESTADO_IDIOMA_INVALIDO("Idioma do Estado inválido");

	private ServiceExceptionEnum() {
		// TODO Auto-generated constructor stub
	}

	private ServiceExceptionEnum(String valor) {
		// TODO Auto-generated constructor stub
	}

}

