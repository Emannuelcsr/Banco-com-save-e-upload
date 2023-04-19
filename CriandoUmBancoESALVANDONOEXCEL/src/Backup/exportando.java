package Backup;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import Classes.CarteiraDeClientes;
import Classes.Clientes;

public class exportando {
	
    private CarteiraDeClientes carteiraDeClientes;
    private List<Clientes> carteira; 
	
	public exportando(CarteiraDeClientes carteiraDeClientes, List<Clientes> carteira) {
        this.carteiraDeClientes = carteiraDeClientes;
        this.carteira = carteira;
    } 
	
	public void salvando() throws IOException{
	
	File arquivo = new File("C:\\workspace\\CriandoUmBancoESALVANDONOEXCEL\\src\\arquivo.xls");
	
	if(!arquivo.exists()) {
		arquivo.createNewFile();		
	}	
	
	HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
	HSSFSheet planilha = hssfWorkbook.createSheet("O banco");
	
	int numeroLinha =0;
	int celula = 0;
	
	Row linha = planilha.createRow(numeroLinha++);//criando a linha na planilha.
	
	Cell cellCelulaUm = linha.createCell(celula++);
	cellCelulaUm.setCellValue("Nome");
	
	Cell cellCelulaDois = linha.createCell(celula++);
	cellCelulaDois.setCellValue("Cpf");
	
	Cell cellCelulaTres = linha.createCell(celula++);
	cellCelulaTres.setCellValue("Idade");
	
	Cell cellCelulaQuatro = linha.createCell(celula++);
	cellCelulaQuatro.setCellValue("Saldo");
	
	for (Clientes p : carteira) {		
		
		celula =0;
		
		linha = planilha.createRow(numeroLinha++);//criando a linha na planilha.
		
		Cell cellNome = linha.createCell(celula++);
		cellNome.setCellValue(p.getNome());
		
		Cell cellCpf = linha.createCell(celula++);
		cellCpf.setCellValue(p.getCpf());
		
		Cell cellIdade = linha.createCell(celula++);
		cellIdade.setCellValue(p.getIdade());
		
		Cell cellSaldo = linha.createCell(celula++);
		cellSaldo.setCellValue(p.getSaldo());		
	}
	
	FileOutputStream saida = new FileOutputStream(arquivo);
	
	hssfWorkbook.write(saida);
	
	saida.flush();
	saida.close();
	
	System.out.println("Planilha criada!");
	
	}
}
