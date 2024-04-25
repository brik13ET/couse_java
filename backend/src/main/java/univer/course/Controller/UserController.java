package univer.course.Controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import univer.course.Service.UserService;

@Controller
@RequestMapping("/user")
@AllArgsConstructor
public class UserController
{
    private UserService service;

    @PostMapping("/login")
    ResponseEntity<?> login()
    {
        return ResponseEntity.ok().build();
    }
}
