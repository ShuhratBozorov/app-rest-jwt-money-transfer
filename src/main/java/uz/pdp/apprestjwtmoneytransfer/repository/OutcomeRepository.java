package uz.pdp.apprestjwtmoneytransfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.apprestjwtmoneytransfer.entity.Outcome;

import java.util.List;

public interface OutcomeRepository extends JpaRepository<Outcome,Integer> {

    List<Outcome> findAllById(Integer id);
}
