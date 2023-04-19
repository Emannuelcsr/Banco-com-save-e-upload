package Tela;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Classes.CarteiraDeClientes;
import Classes.Clientes;


public class CriandoATela extends JDialog{
    private CarteiraDeClientes carteiraDeClientes;
	List<Clientes>carteira = carteiraDeClientes.getCarteira();

    public CriandoATela(CarteiraDeClientes carteiraDeClientes) {
        this.carteiraDeClientes = carteiraDeClientes;
    }
	    	
	CarteiraDeClientes clientela = new CarteiraDeClientes();
	
	JPanel tela = new JPanel(new GridBagLayout());

	
	public void atualizarComboBoxClientes() {
	    comboBoxClientes.setModel(new DefaultComboBoxModel<String>(clientela.obterNomesClientes().toArray(new String[0])));
	}
	
	
	public Clientes obterClientePorNome(String nome) {
	    for (Clientes cliente : carteira) {
	        if (cliente.getNome().equals(nome)) {
	            return cliente;
	        }
	    }
	    return null;
	}
	
	JComboBox<String> comboBoxClientes = new JComboBox<String>(clientela.obterNomesClientes().toArray(new String[0]));
	
	JLabel labelClienteSelecionado = new JLabel();			
	JTextField mostraCliente = new JTextField();
	JLabel nomeCliente = new JLabel("Cliente: ");
	JLabel nomeOperacao = new JLabel("Operação: ");
	
	String[] opcoes = {"Ver Saldo","Depositar","Sacar","Transferir","Sair"};
    JComboBox<String> comboBox = new JComboBox<>(opcoes);

    JButton confirma = new JButton("Confirma");
	
	JLabel saldo = new JLabel("Valor : ");
    JTextField mostraResultadoOperacao = new JTextField();

 	
 	public CriandoATela() {
    clientela.adicionarClientes();
	atualizarComboBoxClientes();
	GridBagConstraints gridBagConstraints = new GridBagConstraints();
	gridBagConstraints.gridx=0;
	gridBagConstraints.gridy=0;
	gridBagConstraints.anchor=gridBagConstraints.WEST;
	gridBagConstraints.insets=new Insets(5,10 ,5,10);
	
	setTitle("Banco Dos Clientes");
	setResizable(false);	
	setSize(new Dimension(400,400));
	setLocationRelativeTo(null);
	

	nomeCliente.setPreferredSize(new Dimension(80,30));
	tela.add(nomeCliente,gridBagConstraints);	
	
	gridBagConstraints.gridx++;	
	
	comboBoxClientes.setPreferredSize(new Dimension(200, 30));
	tela.add(comboBoxClientes, gridBagConstraints);

	gridBagConstraints.gridy++;	
	gridBagConstraints.gridx=0;	
	
	nomeOperacao.setPreferredSize(new Dimension(90,30));
	tela.add(nomeOperacao,gridBagConstraints);
	
	gridBagConstraints.gridx++;

	confirma.addActionListener(new ActionListener(){
		
		@Override
		public void actionPerformed(ActionEvent e) {
		String escolhaOperacao = (String)comboBox.getSelectedItem();
		String nomeClienteSelecionado = (String) comboBoxClientes.getSelectedItem();
		Clientes clienteSelecionado = ((CriandoATela) carteira).obterClientePorNome(nomeClienteSelecionado);

		
		if(escolhaOperacao.equals("Ver saldo")) {			
		    double saldoCliente = clienteSelecionado.getSaldo();
		    mostraResultadoOperacao.setText(String.valueOf(saldoCliente));
		}			
		}
	});
		
	tela.add(comboBox,gridBagConstraints);
	
	gridBagConstraints.gridy++;	
	gridBagConstraints.gridx=0;	
	
	saldo.setPreferredSize(new Dimension(120,30)); 
	tela.add(saldo,gridBagConstraints);

	gridBagConstraints.gridx++;	
	
	mostraResultadoOperacao.setPreferredSize(new Dimension(100,30));
	tela.add(mostraResultadoOperacao,gridBagConstraints);
	
	gridBagConstraints.gridy++;	
	
	confirma.setPreferredSize(new Dimension(120,30));
	tela.add(confirma,gridBagConstraints);

		
	add(tela,BorderLayout.WEST);
	setVisible(true);	
	}
}
