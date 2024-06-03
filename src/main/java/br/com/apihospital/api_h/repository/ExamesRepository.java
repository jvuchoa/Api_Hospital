package br.com.apihospital.api_h.repository;

import br.com.apihospital.api_h.model.Exames;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamesRepository extends JpaRepository<Exames, Long> {
    List<Exames> findByConsultaId(Long ConsultaId);
}
