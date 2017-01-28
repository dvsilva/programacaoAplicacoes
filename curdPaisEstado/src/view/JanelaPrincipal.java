package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class JanelaPrincipal  extends JFrame implements ActionListener{
	
	private JPanel contentPane;
	private JLabel lbFundo;
	private JButton btnEstado;
	private JButton btnPais;
	private JLabel titulo;
		
	
	public JanelaPrincipal() {
		
	    this.lbFundo = new JLabel(new ImageIcon("image/mundo.png"));
		this.lbFundo.setBounds(0, 0, 600, 400);
		this.add(lbFundo);
	   
		   	
	    setTitle("Map Sistem");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setBounds(200,200,600,400);
	    
	    contentPane = new JPanel();
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	   	contentPane.setLayout(null);
	  
	   	
		this.btnPais = new JButton("Paises");
		btnPais.addActionListener(this);
		btnPais.setBounds(100, 150, 144, 55);
		this.lbFundo.add(btnPais);
		
		this.btnEstado = new JButton("Estados");
		btnEstado.addActionListener(this);
		btnEstado.setBounds(300, 150, 144, 55);
		this.lbFundo.add(btnEstado);
		
		this.setVisible(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if (arg0.getSource() == this.btnEstado){
			JanelaCadastroEstado j = new JanelaCadastroEstado();
		}
		if (arg0.getSource() == this.btnPais){
			JanelaCadastrarPais jc = new JanelaCadastrarPais();
		}
	}	
	
}



