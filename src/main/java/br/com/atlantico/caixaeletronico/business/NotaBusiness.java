/**
 * 
 */
package br.com.atlantico.caixaeletronico.business;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.atlantico.caixaeletronico.entity.Nota;
import br.com.atlantico.caixaeletronico.repository.NotaRepository;
import br.com.atlantico.caixaeletronico.to.QuantidadeTO;

/**
 * @author Jessica
 *
 */
@Service
public class NotaBusiness {

	@Autowired
	private NotaRepository notaRepository;
	
	private Double restante;
	
	private String resposta;
	
	public Boolean inserirNota(QuantidadeTO qtdeTO) {
		Nota nota = notaRepository.findByValor(qtdeTO.getValor());
		if(nota == null || qtdeTO.getQtde() <= 0 ) {
			return false;
		}
		nota.setQuantidade(qtdeTO.getQtde()+nota.getQuantidade());
		notaRepository.save(nota);
		
		return true;
	}

	public Nota findByValor(Double valor) {
		Nota nota = notaRepository.findByValor(valor);
		return nota;
	}

	public Iterable<Nota> findAll() {
		return notaRepository.findAll();
	}

	public String sacar(Double valor) {
		if(!(valor > 0 && valor <= 10000)) {
			return "Valor deve ser maior que 0 e menor ou igual a 10000";
		}
		List<Nota> notas = notaRepository.findAll();
		Collections.sort(notas, new Comparator<Nota>() {

			@Override
			public int compare(Nota o1, Nota o2) {
				
				return -o1.getValor().compareTo(o2.getValor());
			}
		});
		restante = new Double(valor);
		resposta = "";
		notas.forEach(nota -> {
			int qtdeSacadaDaNota = (int)(restante / nota.getValor());
			if(qtdeSacadaDaNota == 0 || qtdeSacadaDaNota > nota.getQuantidade()) {
				return;
			}
			restante = restante % nota.getValor(); 
			resposta += "\r\n" + qtdeSacadaDaNota + (qtdeSacadaDaNota == 1 ? " nota de " : " notas de ")+ nota.getValor() + (qtdeSacadaDaNota == 1 ? " reais foi sacada." : " reais foram sacadas."); 
			nota.setQuantidade(nota.getQuantidade() - qtdeSacadaDaNota);
		});
		
		if(restante != 0.0) {
			return "Valor nao pode ser sacado. Notas disponiveis: 2, 5, 10, 20 e 50.";
		}
		notaRepository.saveAll(notas);
		return resposta;
	}

}
