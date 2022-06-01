package uz.pdp.apprestjwtmoneytransfer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.pdp.apprestjwtmoneytransfer.entity.Card;
import uz.pdp.apprestjwtmoneytransfer.entity.Outcome;
import uz.pdp.apprestjwtmoneytransfer.repository.CardRepository;
import uz.pdp.apprestjwtmoneytransfer.repository.OutcomeRepository;
import uz.pdp.apprestjwtmoneytransfer.security.JwtProvider;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Service
public class OutcomeService {
    @Autowired
    OutcomeRepository outcomeRepository;

    @Autowired
    CardRepository cardRepository;

    @Autowired
    JwtProvider jwtProvider;

    public HttpEntity<?> get(HttpServletRequest request){
        String username = getUsername(request);
        Optional<Card> optionalCard = cardRepository.findByUsernameAndActiveTrue(username);
        if (!optionalCard.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        Card card = optionalCard.get();
        Integer id = card.getId();
        List<Outcome> optionalOutcome = outcomeRepository.findAllById(id);
        return ResponseEntity.ok(optionalOutcome);

    }
    public  String getUsername(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        token = token.substring(7);
        String username = jwtProvider.getUsernameFromToken(token);
        return username;
    }
}
