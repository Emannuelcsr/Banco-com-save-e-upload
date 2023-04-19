package Classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarteiraDeClientes {
	
	List<Clientes> carteira = new ArrayList<Clientes>();
	String[]nomes = {"João Lucas", "Maria Aparecida", "José Afonso", "Ana Beatriz", "Pedro Albuquerque", "Mariana Louise", "Lucas Fernando", "Juliana Castro", "Rafael Gastillo", "Carla Perez"};

	List<String> nomesSelecionados = new ArrayList<String>();

	
	public void adicionarClientes() {	
	
	    for(int i=0;i<10;i++) {

        Clientes cliente = new Clientes();
        String nomeSelecionado;
		
		Random rand = new Random();
			
        do {
            nomeSelecionado = nomes[rand.nextInt(nomes.length)];
        } while (nomesSelecionados.contains(nomeSelecionado));
        	nomesSelecionados.add(nomeSelecionado);
            cliente.setNome(nomeSelecionado); 
			cliente.setCpf(gerarCpfAleatorio(rand));
			cliente.setIdade(geraIdadeAleatorio(rand));
			cliente.setSaldo(geraSaldo(rand));		
			
			carteira.add(cliente);			
			
	}		
	}	
	
	private String gerarCpfAleatorio(Random rand) {
		int num1 = rand.nextInt(10);
		int num2 = rand.nextInt(10);
		int num3 = rand.nextInt(10);
		int num4 = rand.nextInt(10);
		int num5 = rand.nextInt(10);
		int num6 = rand.nextInt(10);
		int num7 = rand.nextInt(10);
		int num8 = rand.nextInt(10);
		int num9 = rand.nextInt(10);
		
		int soma1 = num1 * 10 + num2 * 9 + num3 * 8 + num4 * 7 + num5 * 6 + num6 * 5 + num7 * 4 + num8 * 3 + num9 * 2;
		int resto1 = soma1 % 11;
		int digito1 = resto1 < 2 ? 0 : 11 - resto1;
		
		int soma2 = num1 * 11 + num2 * 10 + num3 * 9 + num4 * 8 + num5 * 7 + num6 * 6 + num7 * 5 + num8 * 4 + num9 * 3 + digito1 * 2;
		int resto2 = soma2 % 11;
		int digito2 = resto2 < 2 ? 0 : 11 - resto2;
		
		return String.format("%d%d%d.%d%d%d.%d%d%d-%d%d", num1, num2, num3, num4, num5, num6, num7, num8, num9, digito1, digito2);
	}
	
	private int geraIdadeAleatorio(Random rand) {
		
		int idade = 18 + rand.nextInt(100-18);
		return idade;		
	}
	
	private double geraSaldo(Random rand) {
		double maiorSaldo = 8000.00;
		double menorSaldo = 1400.00;
		
		double saldo = menorSaldo + rand.nextDouble(maiorSaldo-menorSaldo);
				
	    return Double.parseDouble(String.format("%.2f", saldo).replace(",", "."));
	}
	
	public void imprimir() {
		for (Clientes clientes : carteira) {
	        System.out.println("Nome: " + clientes.getNome());
	        System.out.println("CPF: " + clientes.getCpf());
	        System.out.println("Idade: " + clientes.getIdade());
	        System.out.println("Saldo: R$" + clientes.getSaldo());
	        System.out.println();
		}
		
		
	}
	
	public List<Clientes> getCarteira() {
	    return carteira;
	}
	
	public List<String> obterNomesClientes() {
	    List<String> nomes = new ArrayList<String>();
	    for (Clientes cliente: carteira) {
	        nomes.add(cliente.getNome());
	}
	    return nomes;
	}
	
	public double getSaldo(String nomeCliente) {
	    for (Clientes cliente : carteira) {
	        if (cliente.getNome().equals(nomeCliente)) {
	            return cliente.getSaldo();
	        }
	    }
	    throw new RuntimeException("Cliente não encontrado: " + nomeCliente);
	}



	public void atualizaSaldo(String nomeClienteSelecionado, double novoSaldo) {
		for (Clientes cliente : carteira) {
	        if (cliente.getNome().equals(nomeClienteSelecionado)) {
	            cliente.setSaldo(novoSaldo);
	            break;		
	}
	
}
}
}
