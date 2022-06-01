package uz.pdp.apprestjwtmoneytransfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.apprestjwtmoneytransfer.service.OutcomeService;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/api/outcome")
public class OutcomeController {

    @Autowired
    OutcomeService outcomeService;

    @GetMapping("/get")
    public HttpEntity<?> get(HttpServletRequest request){
        return outcomeService.get(request);
    }
}
