package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import service.PaisService;
import dto.PaisDTO;
import exception.DaoException;
import exception.ServiceException;

public class JanelaPais extends JFrame implements ActionListener{
	
	private static PaisService paisService = new PaisService();
	
	private JPanel contentPane;
	private JLabel lblCodigo,lblNome,lblContinente, lblCapital, lblArea , lblIdioma, lblMoeda;
	private JTextField tfCodigo;
	private JTextField tfNome;
	private JTextField tfContinente;
	private JTextField tfCapital;
	private JTextField tfIdioma;
	private JTextField tfArea;
	private JTextField tfMoeda;
	private JButton btnOk;
	private JButton btnCancelar;
	private JLabel lbFundo;

	private Object btOk; 

	
	JanelaPais(){
		super();
		
		
		this.lbFundo = new JLabel(new ImageIcon("image/mundo.png"));
		this.lbFundo.setBounds(0, 0, 500,342);
		this.add(lbFundo);
		
		setTitle("Pais");
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
		
		lblContinente = new JLabel("Localização:");
		lblContinente.setBounds(24, 67, 122, 14);
		lblContinente.setForeground(Color.white);
		lblContinente.setFont(new Font("Arial Black",Font.PLAIN, 12));
		this.lbFundo.add(lblContinente);
		
		lblCapital = new JLabel("Capital:");
		lblCapital.setBounds(24, 94, 72, 14);
		lblCapital.setForeground(Color.white);
		lblCapital.setFont(new Font("Arial Black",Font.PLAIN, 12));
		this.lbFundo.add(lblCapital);
		
		lblIdioma = new JLabel("Idioma:");
		lblIdioma.setBounds(24, 159, 72, 14);
		lblIdioma.setForeground(Color.white);
		lblIdioma.setFont(new Font("Arial Black",Font.PLAIN, 12));
		this.lbFundo.add(lblIdioma);
		
		lblArea = new JLabel("Extensão Territorial:");
		lblArea.setBounds(24, 123, 142, 14);
		lblArea.setForeground(Color.white);
		lblArea.setFont(new Font("Arial Black",Font.PLAIN, 12));
		this.lbFundo.add(lblArea);
		
		lblMoeda = new JLabel("Moeda:");
		lblMoeda.setBounds(24, 181, 72, 14);
		lblMoeda.setForeground(Color.white);
		lblMoeda.setFont(new Font("Arial Black",Font.PLAIN, 12));
		this.lbFundo.add(lblMoeda);
		
		
		tfCodigo = new JTextField();
		tfCodigo.setBounds(165, 17, 20, 20);
		this.lbFundo.add(tfCodigo);
		tfCodigo.setColumns(10);
		
		tfNome = new JTextField();
		tfNome.setBounds(165, 42, 244, 20);
		this.lbFundo.add(tfNome);
		tfNome.setColumns(10);
		
		tfContinente= new JTextField();
		tfContinente.setBounds(165, 67, 244, 20);
		this.lbFundo.add(tfContinente);
		tfContinente.setColumns(10);
		
		tfCapital = new JTextField();
		tfCapital.setColumns(10);
		this.lbFundo.add(tfCapital);
		tfCapital.setBounds(165, 94, 244, 20);
				
		tfIdioma = new JTextField();
		tfIdioma.setColumns(10);
		this.lbFundo.add(tfIdioma);
		tfIdioma.setBounds(165,159, 244, 20);
		
		tfArea = new JTextField();
		tfArea.setColumns(10);
		this.lbFundo.add(tfArea);
		tfArea.setBounds(165, 123, 244, 20);
		
		tfMoeda = new JTextField();
		tfMoeda.setColumns(10);
		this.lbFundo.add(tfMoeda);
		tfMoeda.setBounds(165, 181, 244, 20);
		
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

    public static void criarPais(int codigo, String nome, String Continente, String capital, String idioma, String moeda,double area){
    	PaisDTO paisDTO = new PaisDTO();
    	
    	try{ 
    		paisService.cadastrarPais(paisDTO);
    		
    	}catch(ServiceException e){
    		System.out.println(e.getTipo());
    	}catch (DaoException e){
    		System.out.println(e.getMessage());
    	}
    	
    }
    

	public void actionPerformed(ActionEvent e) {
		
		EventObject evento = null;
		if(e.getSource() == this.btnOk)
		{
			criarPais(Integer.parseInt(tfCodigo.getText()), tfNome.getText(), tfContinente.getText(), tfCapital.getText(),tfIdioma.getText(), tfMoeda.getText(), Double.parseDouble(tfArea.getText()) );
			JOptionPane.showMessageDialog(null, "Estado" + tfNome.getText() +  tfContinente.getText() + tfCapital.getText() + tfIdioma.getText() + tfMoeda.getText() + tfArea.getText() + " cadastrado com sucesso!");
		}
		if(e.getSource() == this.btnCancelar)
		{
			dispose();
		}
		}
}

