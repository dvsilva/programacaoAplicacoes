package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import service.EstadoService;
import dto.EstadoDTO;
import exception.DaoException;
import exception.ServiceException;

public class JanelaEstado  extends JFrame implements ActionListener{
	
	private static EstadoService estadoService = new EstadoService();
	
	private JPanel contentPane;
	private JLabel lblCodigo,lblNome, lblSigla, lblCapital, lblRegiao;
	private JTextField tfCodigo;
	private JTextField tfNome;
	private JTextField tfSigla;
	private JTextField tfCapital;
	private JTextField tfIdioma;
	private JTextField tfRegiao;
	private JButton btnOk;
	private JButton btnCancelar;
	private JLabel lbFundo;

	

	
	public JanelaEstado(){
		super();
		
		
		
		this.lbFundo = new JLabel(new ImageIcon("image/mundo.png"));
		this.lbFundo.setBounds(0, 0, 500,342);
		this.add(lbFundo);
		
		setTitle("Estados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200,200,500,342);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		
		lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(24, 17, 127, 14);
		lblCodigo.setForeground(Color.white);
		lblCodigo.setFont(new Font("Arial Black",Font.PLAIN, 12));
		this.lbFundo.add(lblCodigo);

		lblNome = new JLabel("Nome:");
		lblNome.setBounds(24, 42, 72, 14);
		lblNome.setForeground(Color.white);
		lblNome.setFont(new Font("Arial Black",Font.PLAIN, 12));
		this.lbFundo.add(lblNome);
		
		lblSigla = new JLabel("Sigla:");
		lblSigla .setBounds(24, 67, 122, 14);
		lblSigla .setForeground(Color.white);
		lblSigla .setFont(new Font("Arial Black",Font.PLAIN, 12));
		this.lbFundo.add(lblSigla );
		
		lblCapital = new JLabel("Capital:");
		lblCapital.setBounds(24, 94, 72, 14);
		lblCapital.setForeground(Color.white);
		lblCapital.setFont(new Font("Arial Black",Font.PLAIN, 12));
		this.lbFundo.add(lblCapital);
		
		lblRegiao = new JLabel("Região:");
		lblRegiao.setBounds(24, 123, 72, 14);
		lblRegiao.setForeground(Color.white);
		lblRegiao.setFont(new Font("Arial Black",Font.PLAIN, 12));
		this.lbFundo.add(lblRegiao);
		
			
		
		tfCodigo = new JTextField();
		tfCodigo.setBounds(165, 17, 20, 20);
		this.lbFundo.add(tfCodigo);
		tfCodigo.setColumns(10);
		
		tfNome = new JTextField();
		tfNome.setBounds(165, 42, 244, 20);
		this.lbFundo.add(tfNome);
		tfNome.setColumns(10);
		
		tfSigla= new JTextField();
		tfSigla.setBounds(165, 67, 244, 20);
		this.lbFundo.add(tfSigla);
		tfSigla.setColumns(10);
		
		tfCapital = new JTextField();
		tfCapital.setColumns(10);
		this.lbFundo.add(tfCapital);
		tfCapital.setBounds(165, 94, 244, 20);
				
		tfRegiao = new JTextField();
		tfRegiao.setColumns(10);
		this.lbFundo.add(tfRegiao);
		tfRegiao.setBounds(165,123, 244, 20);
		
		
		
		btnOk = new JButton("Ok");
		btnOk.setBounds(34, 250, 143, 23);
		this.lbFundo.add(btnOk);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(197, 250, 143, 23);
		this.lbFundo.add(btnCancelar);



		this.btnOk.addActionListener(this);
		this.btnCancelar.addActionListener(this);
		
		this.setVisible(true);
		
	}

    public static void criarEstado(int codigo, String nome, String sigla, String capital, String regiao ){
    	EstadoDTO estadoDTO = new EstadoDTO(codigo, nome, sigla, capital, regiao);
    	 	
    }
    

	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
				
		EventObject evento = null;
		if(e.getSource() == this.btnOk)
		{
			criarEstado(Integer.parseInt(tfCodigo.getText()), tfNome.getText(), tfSigla.getText(), tfCapital.getText(),tfRegiao.getText() );
			JOptionPane.showMessageDialog(null, "Estado" + tfNome.getText() + tfSigla.getText() + tfCapital.getText() + tfRegiao.getText() +" cadastrado com sucesso!");
			dispose();
		}
		
		if(e.getSource() == this.btnCancelar)
		{
			dispose();
		}
}
}
