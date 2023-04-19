package Classes;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Backup.Importando;
import Backup.exportando;
import Tela.CriandoATela;

public class OperacoesBancarias extends JDialog {
	
    private CarteiraDeClientes carteiraDeClientes;
    private List<Clientes> carteira; 

    
    public OperacoesBancarias(CarteiraDeClientes carteiraDeClientes, List<Clientes> carteira) {
        this.carteiraDeClientes = carteiraDeClientes;
        this.carteira = carteira;
    } 
   	
		
    
    JPanel tela = new JPanel(new GridBagLayout());
		
    String[] opcoes = {"Depositar", "Sacar", "Transferir", "Sair"};
    JComboBox<String> comboBox = new JComboBox<>(opcoes);

    JLabel labelClienteSelecionado = new JLabel();			
    JTextField mostraCliente = new JTextField();
    JLabel nomeCliente = new JLabel("Cliente: ");
    JLabel nomeOperacao = new JLabel("Operação: ");
	
    JButton VerSaldo = new JButton("Ver Saldo");
    
    JLabel valor = new JLabel("Valor: ");
		
    JTextField mostraResultadoOperacao = new JTextField();
   
    JTextField mostraSaldo = new JTextField();
    
    JButton acao = new JButton("Confirmar");

    JLabel clienteDestino = new JLabel("Cliente Destino: ");

    JLabel branco = new JLabel();
    
    JButton salvar = new JButton("Salvar");
    
    JButton carregar = new JButton("Carregar");

    public void interfaceGrafica() {    	
    	String[] nomesClientes = new String[carteira.size()];
        for (int i = 0; i < carteira.size(); i++) {
            nomesClientes[i] = carteira.get(i).getNome();
        }
        
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>(nomesClientes);
        JComboBox<String> comboBoxClientes = new JComboBox<>(comboBoxModel);
        
        DefaultComboBoxModel<String> comboBoxModel2 = new DefaultComboBoxModel<>(nomesClientes);
        JComboBox<String> comboBoxClientesDestino = new JComboBox<>(comboBoxModel2);
        
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=0;
        gridBagConstraints.anchor=GridBagConstraints.WEST;
        gridBagConstraints.insets=new Insets(5,10,5,10);
    	
        setTitle("Banco Dos Clientes");
        setResizable(false);	
        setSize(new Dimension(400,400));
        setLocationRelativeTo(null);
    	

        nomeCliente.setPreferredSize(new Dimension(150,30));
        tela.add(nomeCliente,gridBagConstraints);	
    	
        gridBagConstraints.gridx++;	
    	
        comboBoxClientes.setPreferredSize(new Dimension(150, 30));
        tela.add(comboBoxClientes, gridBagConstraints);

        gridBagConstraints.gridy++;	
        gridBagConstraints.gridx=0;	

        nomeOperacao.setPreferredSize(new Dimension(150,30));
        tela.add(nomeOperacao,gridBagConstraints);
    	
        gridBagConstraints.gridx++;

        comboBox.setPreferredSize(new Dimension(150, 30));
        tela.add(comboBox, gridBagConstraints);
		
        gridBagConstraints.gridy++;
        gridBagConstraints.gridx=0;
        
        clienteDestino.setPreferredSize(new Dimension(150,30));
        tela.add(clienteDestino,gridBagConstraints);
          
        gridBagConstraints.gridx++;
        
        comboBoxClientesDestino.setPreferredSize(new Dimension(150, 30));
        tela.add(comboBoxClientesDestino, gridBagConstraints);       
        
        gridBagConstraints.gridy++;
        
        branco.setPreferredSize(new Dimension(150,30));
        tela.add(branco,gridBagConstraints);
        
        gridBagConstraints.gridy++;
        gridBagConstraints.gridx=0;
        
        valor.setPreferredSize(new Dimension(120,30));
        tela.add(valor,gridBagConstraints);
        
        gridBagConstraints.gridx++;
        
        mostraResultadoOperacao.setPreferredSize(new Dimension(120,30));
        tela.add(mostraResultadoOperacao,gridBagConstraints); 
        
        gridBagConstraints.gridy++;	
        
        acao.setPreferredSize(new Dimension(120,30));
        tela.add(acao,gridBagConstraints);        
        
        gridBagConstraints.gridy++;	
   	    gridBagConstraints.gridx=0;	
    	   	      	    
   	    VerSaldo.setPreferredSize(new Dimension(120,30));
        tela.add(VerSaldo,gridBagConstraints);
   	    
        gridBagConstraints.gridx++;
        
   	    mostraSaldo.setPreferredSize(new Dimension(120,30));
        mostraSaldo.setEditable(false);
   	    tela.add(mostraSaldo,gridBagConstraints); 
   	    
   	    gridBagConstraints.gridy++;	
   	 
   	    salvar.setPreferredSize(new Dimension(120,30));
   	    tela.add(salvar,gridBagConstraints);
   	    
   	    gridBagConstraints.gridy++;	

   	    carregar.setPreferredSize(new Dimension(120,30));
        tela.add(carregar,gridBagConstraints);
        
        VerSaldo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String nomeClienteSelecionado = comboBoxClientes.getSelectedItem().toString();	   
				double saldo = carteiraDeClientes.getSaldo(nomeClienteSelecionado);

			    DecimalFormat df = new DecimalFormat("#.##");
			    String saldoFormatado = df.format(saldo);
			    mostraSaldo.setText(saldoFormatado);        	
		        }			
		});
  
        acao.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String nomeClienteSelecionado = comboBoxClientes.getSelectedItem().toString();	
		        String operacaoSelecionada = comboBox.getSelectedItem().toString();
		        
		        	        		        
		        if(operacaoSelecionada.equals("Depositar")) {      	
		        	double valorDepositado = Double.parseDouble(mostraResultadoOperacao.getText());
		            double novoSaldo = carteiraDeClientes.getSaldo(nomeClienteSelecionado) + valorDepositado;
		            carteiraDeClientes.atualizaSaldo(nomeClienteSelecionado, novoSaldo);
		            mostraSaldo.setText(String.valueOf(novoSaldo));	
		    }else if(operacaoSelecionada.equals("Sacar")) {
		    	double valorSaque = Double.parseDouble(mostraResultadoOperacao.getText());
	            double novoSaldo = carteiraDeClientes.getSaldo(nomeClienteSelecionado) - valorSaque;		    	
		    	
	            if(valorSaque<=carteiraDeClientes.getSaldo(nomeClienteSelecionado)){		          
		            carteiraDeClientes.atualizaSaldo(nomeClienteSelecionado, novoSaldo);
	            	mostraSaldo.setText(String.valueOf(novoSaldo));		    			    	
	            }else {
	            	JOptionPane.showMessageDialog(null, "Saldo Insuficiente!");
	            } 			
			}else if (operacaoSelecionada.equals("Transferir")) {
				String nomeClienteDestino = comboBoxClientesDestino.getSelectedItem().toString();
				
				double valorTransferencia = Double.parseDouble(mostraResultadoOperacao.getText());
	            double novoSaldo = carteiraDeClientes.getSaldo(nomeClienteSelecionado) - valorTransferencia;
	            double novoSaldoClienteDestino = carteiraDeClientes.getSaldo(nomeClienteDestino) + valorTransferencia;
	            
	            if(valorTransferencia<=carteiraDeClientes.getSaldo(nomeClienteSelecionado) 
	            		&&nomeClienteDestino!=nomeClienteSelecionado){
		            carteiraDeClientes.atualizaSaldo(nomeClienteSelecionado, novoSaldo);
		            carteiraDeClientes.atualizaSaldo(nomeClienteDestino, novoSaldoClienteDestino);
	            	mostraSaldo.setText(String.valueOf(novoSaldo));
	            	}else {
	            		JOptionPane.showMessageDialog(null, "Não foi possivel realizar a transferencia!");
	            	}
			}else if(operacaoSelecionada.equals("Sair")){
	            JOptionPane.showMessageDialog(null, "Programa finalizado!");
	            try {
					Thread.sleep(200);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.exit(0);
			
			}	        
			}
        
		});
        
        salvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
		        exportando export = new exportando(carteiraDeClientes, carteira);

				try {
					export.salvando();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
        
        carregar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
		        Importando carregando = new Importando();        

				try {
					carregando.upload();
				} catch (IOException e1) {
					e1.printStackTrace();
				}				
			}
		});
        
        add(tela, BorderLayout.CENTER);
    	
        setVisible(true);
    }
}
        
        



        
        