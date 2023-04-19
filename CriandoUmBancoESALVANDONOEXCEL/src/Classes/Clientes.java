package Classes;

public class Clientes {
	
	private String nome;
	private String cpf;
	private int idade;
	private double saldo;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public String toString() {
		return "Clientes [nome=" + nome + ", cpf=" + cpf + ", idade=" + idade + ", saldo=" + saldo + "]";
	}

	
	
	
	

}
