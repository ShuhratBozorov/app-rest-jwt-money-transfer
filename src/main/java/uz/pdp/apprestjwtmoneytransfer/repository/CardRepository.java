package uz.pdp.apprestjwtmoneytransfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.apprestjwtmoneytransfer.entity.Card;

import java.util.Optional;

public interface CardRepository extends JpaRepository<Card,Integer> {

    Boolean existsByNumberAndUsername(String number, String username);

    Optional<Card> findByUsername(String username);

    Card findByUsernameAndId(String username, Integer id);

    Optional<Card> findByUsernameAndIdAndActiveTrue(String username, Integer id);

    Optional<Card> findByIdAndActiveTrue(Integer id);

    Optional<Card> findByUsernameAndActiveTrue(String username);
}
