package entity;


public class Estado {

	private int codigo;
	private String nome;
	private String sigla;
	private String capital;
	private String regiao;
	
	
	private Pais pais;

	public Estado(int codigo, String nome, String sigla, String capital, String regiao) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.sigla = sigla;
		this.capital = capital;
		this.regiao = regiao;
		
		this.setPais(pais);
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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	
	
	public boolean setPais(Pais p){
		if(this.pais == p)
			return false;
		if(p == null){
			Pais anterior = this.pais;
			this.pais = null;
			anterior.remEstado(this);
			return true;
			}
		if(this.pais != null){
			this.pais.remEstado(this);
			}
		this.pais = p;
		p.addEstado(this);
		return true;
	}


	}
	
	
