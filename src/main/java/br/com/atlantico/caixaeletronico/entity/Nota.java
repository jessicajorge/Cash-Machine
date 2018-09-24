/**
 * 
 */
package br.com.atlantico.caixaeletronico.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Jessica
 *
 */
@Entity
public class Nota {	
		
	@Id
	@Column(nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	
	
	@Column(name = "valor", unique = true, nullable = false)
	private Double valor;	
	
	@Column
	private Integer quantidade;
	
    public Nota() {}
	
	public Nota(Double valor, Integer quantidade) {
		this.valor = valor;
		this.quantidade = quantidade;
	}
	
		
	/**
	 * @return the valor
	 */
	public Double getValor() {
		return valor;
	}
	/**
	 * @param valor the valor to set
	 */
	public void setValor(Double valor) {
		this.valor = valor;
	}
	/**
	 * @return the quantidade
	 */
	public Integer getQuantidade() {
		return quantidade;
	}
	/**
	 * @param quantidade the quantidade to set
	 */
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	
}
