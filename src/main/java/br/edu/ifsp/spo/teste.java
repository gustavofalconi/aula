package br.edu.ifsp.spo;

import java.time.LocalDate;

public class teste {
	public static void main(String[] args) {
		Contato contato = new Contato("wesley", "rua sei la", "wesley123@", LocalDate.of(1990, 12, 10) );
		
		ContatoDao dao = new ContatoDao();
		
		dao.add(contato);		
	}
}
