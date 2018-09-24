package br.com.atlantico.caixaeletronico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.atlantico.caixaeletronico.entity.Nota;
import br.com.atlantico.caixaeletronico.repository.NotaRepository;

@SpringBootApplication
public class CaixaeletronicoApplication implements CommandLineRunner {
	
	@Autowired
	private NotaRepository notaRepository;

	public static void main(String[] args) {
		SpringApplication.run(CaixaeletronicoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Nota nota2 = new Nota();
		nota2.setValor(2.0);
		nota2.setQuantidade(20);
		notaRepository.save(nota2);
		
		Nota nota5 = new Nota();
		nota5.setValor(5.0);
		nota5.setQuantidade(20);
		notaRepository.save(nota5);
		
		Nota nota10 = new Nota();
		nota10.setValor(10.0);
		nota10.setQuantidade(20);
		notaRepository.save(nota10);
		
		Nota nota20 = new Nota();
		nota20.setValor(20.0);
		nota20.setQuantidade(20);
		notaRepository.save(nota20);
		
		Nota nota50 = new Nota();
		nota50.setValor(50.0);
		nota50.setQuantidade(20);
		notaRepository.save(nota50);
	}
}
