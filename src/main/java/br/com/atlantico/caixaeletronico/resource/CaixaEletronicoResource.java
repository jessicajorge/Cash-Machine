package br.com.atlantico.caixaeletronico.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.atlantico.caixaeletronico.business.NotaBusiness;
import br.com.atlantico.caixaeletronico.entity.Nota;
import br.com.atlantico.caixaeletronico.to.QuantidadeTO;

@RestController
@RequestMapping(value = "/caixa")
public class CaixaEletronicoResource {

	@Autowired
	NotaBusiness notaBusiness;

	@RequestMapping(value = "/inserir-nota", method = RequestMethod.POST)
	public ResponseEntity<String> inserirNota(@RequestBody QuantidadeTO qtdeTO) {
		Boolean sucesso = notaBusiness.inserirNota(qtdeTO);
		if (sucesso) {
			return ResponseEntity.ok().body("Nota inserida com sucesso");
		} else {
			return ResponseEntity.badRequest().body("Ocooreu um erro ao inserir a nota");
		}

	}

	@RequestMapping(value = "/consultar-qtde-nota", method = RequestMethod.POST)
	public ResponseEntity consultarQtdeNota(@RequestBody QuantidadeTO qtdeTO) {
		Nota nota = notaBusiness.findByValor(qtdeTO.getValor());
		if (nota != null) {
			return ResponseEntity.ok().body(nota.getQuantidade());
		} else {
			return ResponseEntity.badRequest().body("Nota nao encontrada!");
		}

	}

	@RequestMapping(value = "/consultar-todas", method = RequestMethod.GET)
	public ResponseEntity consultarTodas() {
		return ResponseEntity.ok().body(notaBusiness.findAll());
	}

	@RequestMapping(value = "/sacar", method = RequestMethod.GET)
	public ResponseEntity sacar(@RequestParam("valor") Double valor) {
		return ResponseEntity.ok().body(notaBusiness.sacar(valor));
	}

}
