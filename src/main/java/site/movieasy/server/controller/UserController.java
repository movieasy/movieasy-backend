package site.movieasy.server.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/user")
@RestController
public class UserController {
    @PostMapping("/register")
    public void register() {

    }
}
