package uz.pdp.apprestjwtmoneytransfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.apprestjwtmoneytransfer.entity.Income;

import java.util.List;

public interface IncomeRepository extends JpaRepository<Income,Integer> {

    List<Income> findAllById(Integer id);
}
