package br.com.apihospital.api_h.repository;

import br.com.apihospital.api_h.model.Doutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoutorRepository extends JpaRepository<Doutor, Long> {
}
