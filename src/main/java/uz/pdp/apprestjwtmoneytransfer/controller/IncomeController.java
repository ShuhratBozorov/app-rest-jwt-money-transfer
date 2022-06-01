package uz.pdp.apprestjwtmoneytransfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.apprestjwtmoneytransfer.service.IncomeService;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/api/income")
public class IncomeController {
    @Autowired
    IncomeService incomeService;

    @GetMapping("/get")
    public HttpEntity<?> getIncome(HttpServletRequest request){
        HttpEntity<?> httpEntity = incomeService.get(request);
        return httpEntity;
    }
}
