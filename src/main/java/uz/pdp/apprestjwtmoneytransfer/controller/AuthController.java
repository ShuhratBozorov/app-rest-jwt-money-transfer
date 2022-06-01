package uz.pdp.apprestjwtmoneytransfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.apprestjwtmoneytransfer.payload.LoginDto;
import uz.pdp.apprestjwtmoneytransfer.service.MyAuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    MyAuthService myAuthService;

    @PostMapping(value = "/login")
    public HttpEntity<?> loginToSystem(@RequestBody LoginDto loginDto) {
        return myAuthService.loginToSystem(loginDto);
    }
}
