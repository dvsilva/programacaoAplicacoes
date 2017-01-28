package regra3;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Janela extends Frame implements ActionListener {
	// Atributos da Classe
	private Button btOk;
	private Button btCancela;
	private Button btAjuda;

	// Construtor
	public Janela(String titulo) {
		// Chamada ao construtor de Frame
		super(titulo);
		// Instancio um objeto da classe Font, declaro a variável
		// local fontePadrão e faço com que esta variável aponte
		// para o novo objeto Font criado
				
		Font fontePadrao = new Font("TimesRoman", Font.BOLD, 14);
		// determino o padrão de fonte para a janela
		this.setFont(fontePadrao);
		// Determino a cor de fundo da janela
		this.setBackground(Color.WHITE);
		// Instancio um novo objeto Button e faço com que o atributo Ok
		// da janela aponte para este novo Button
		this.btOk = new Button("Ok");
		// Instancio um novo objeto Button e faço com que o atributo
		// Cancela da janela aponte para este novo Button
		this.btCancela = new Button("Cancela");
		// Instancio um novo objeto Button e faço com que o atributo
		// Ajuda da janela aponte para este novo Button
		this.btAjuda = new Button("Ajuda");
		// Adiciono o bot‹o Ok ˆ Janela na regi‹o OESTE
		this.add(this.btOk, BorderLayout.WEST);
		// Adiciono o bot‹o Cancela ˆ Janela na regi‹o CENTRO
		this.add(this.btCancela, BorderLayout.CENTER);
		// Adiciono o bot‹o Ajuda ˆ Janela na regi‹o LESTE
		this.add(this.btAjuda, BorderLayout.EAST);

		this.btOk.addActionListener(this);
		this.btCancela.addActionListener(this);
		this.btAjuda.addActionListener(this);

		// Redimensiono o tamanho da Janela
		this.setSize(400, 200);
		// Torno a janela Visível
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource() == this.btOk) {
			System.out.println("Bot‹o OK pressionado");
		}
		if (evento.getSource() == this.btCancela) {
			System.out.println("Bot‹o CANCELA pressionado");
			System.exit(0);
		}
		if (evento.getSource() == this.btAjuda) {
			System.out.println("Bot‹o AJUDA pressionado");
		}
	}
}
