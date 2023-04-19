package Executavel;

import java.io.IOException;
import java.util.List;

import Backup.exportando;
import Classes.CarteiraDeClientes;
import Classes.Clientes;
import Classes.OperacoesBancarias;
import Tela.CriandoATela;

public class Banco {
	
	public static void main(String[] args) throws IOException {
		
		CarteiraDeClientes carteiraDeClientes = new CarteiraDeClientes();
        carteiraDeClientes.adicionarClientes();
        List<Clientes> carteira = carteiraDeClientes.getCarteira();
        
        OperacoesBancarias bancarias = new OperacoesBancarias(carteiraDeClientes, carteira);		
		bancarias.interfaceGrafica();
			
	}
}

