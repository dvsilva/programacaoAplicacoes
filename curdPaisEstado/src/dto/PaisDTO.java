package dto;


public class PaisDTO {

	private int codigo;
	private String nome;
	private String continente;
	private String capital;
	private String idioma;
	private String moeda;
	private double area;
	

	public PaisDTO() {

	}

	public PaisDTO(int codigo, String nome, String continente, String capital, String idioma,
			String moeda, double area) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.continente = continente;
		this.capital = capital;
		this.idioma = idioma;
		this.moeda = moeda;
		this.area = area;

	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getContinente() {
		return continente;
	}

	public void setContinente(String continente) {
		this.continente = continente;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getMoeda() {
		return moeda;
	}

	public void setMoeda(String moeda) {
		this.moeda = moeda;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

}
