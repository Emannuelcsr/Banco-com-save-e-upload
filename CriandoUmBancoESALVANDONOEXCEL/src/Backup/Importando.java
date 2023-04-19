package Backup;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hpsf.Array;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import Classes.CarteiraDeClientes;
import Classes.Clientes;

public class Importando {
	

	public void upload() throws IOException {
		
		FileInputStream entrada = new FileInputStream
				(new File("C:\\workspace\\CriandoUmBancoESALVANDONOEXCEL\\src\\arquivo.xls"));
		
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada);//n pode esquecer de passar o arquivo q vai mexer.
		HSSFSheet planilha = hssfWorkbook.getSheetAt(0);// é a nossa 0, é a nossa primeira planilha.
		
		Iterator<Row> linhasIterator = planilha.iterator();
		linhasIterator.next();
		List<Clientes> pessoas = new ArrayList<Clientes>();
		
		while(linhasIterator.hasNext()) {
			Row linha = linhasIterator.next();
			
			Iterator<Cell> celula = linha.iterator();
			
			Clientes clientes = new Clientes();
			
			while (celula.hasNext()) {
				
				Cell cell = celula.next();
				
				switch (cell.getColumnIndex()) {
				
				case 0:
					clientes.setNome(cell.getStringCellValue());
					break;
				case 1:
					clientes.setCpf(cell.getStringCellValue());
					break;	
				case 2:
					clientes.setIdade(Double.valueOf(cell.getNumericCellValue()).intValue());
					break;	
				case 3:
					clientes.setSaldo(Double.valueOf(cell.getNumericCellValue()));
					break;		
				}				
			}	
			
			pessoas.add(clientes);			
		}
		
		entrada.close();// terminou de ler o arquivo excel.
		
		
		for (Clientes cliente : pessoas) {
		    System.out.println("Nome: " + cliente.getNome());
		    System.out.println("CPF: " + cliente.getCpf());
		    System.out.println("Idade: " + cliente.getIdade());
		    System.out.println("Saldo: " + cliente.getSaldo());
		    System.out.println("------------------------");
		}
		}	
		}
		
	

