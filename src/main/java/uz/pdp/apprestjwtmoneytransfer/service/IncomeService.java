package uz.pdp.apprestjwtmoneytransfer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.pdp.apprestjwtmoneytransfer.entity.Card;
import uz.pdp.apprestjwtmoneytransfer.entity.Income;
import uz.pdp.apprestjwtmoneytransfer.repository.CardRepository;
import uz.pdp.apprestjwtmoneytransfer.repository.IncomeRepository;
import uz.pdp.apprestjwtmoneytransfer.security.JwtProvider;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Service
public class IncomeService {
    @Autowired
    IncomeRepository incomeRepository;

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    CardRepository cardRepository;

    public HttpEntity<?> get(HttpServletRequest request){

        String username = getUsername(request);
        Optional<Card> optionalCard = cardRepository.findByUsernameAndActiveTrue(username);
        if (!optionalCard.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        Card card = optionalCard.get();
        Integer id = card.getId();

        List<Income> allIncome = incomeRepository.findAllById(id);
        return ResponseEntity.ok(allIncome);
    }
    public  String getUsername(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        token = token.substring(7);
        return jwtProvider.getUsernameFromToken(token);
    }
}
