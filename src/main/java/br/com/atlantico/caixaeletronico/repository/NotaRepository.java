/**
 * 
 */
package br.com.atlantico.caixaeletronico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.atlantico.caixaeletronico.entity.Nota;

/**
 * @author Jessica
 *
 */
@Repository
public interface NotaRepository extends JpaRepository<Nota, Long>{

	Nota findByValor(Double valor);
	
	

}
