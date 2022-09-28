package cn.j2go.mall.demo.web;

import cn.j2go.mall.demo.domain.User;
import cn.j2go.mall.demo.domain.UserRepo;
import cn.j2go.mall.demo.domain.Product;
import cn.j2go.mall.demo.domain.ProductRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    final ProductRepo productRepo;
    final UserRepo userRepo;
    final PasswordEncoder passwordEncoder;

    @ResponseBody
    @GetMapping("/api/products")
    public Iterable<Product> getProducts() {
        return productRepo.findAll();
    }

    @GetMapping("/reg")
    public String reg() {
        return "/reg";
    }

//    @GetMapping("/login")
//    public String login() {
//        return "/login";
//    }

    @GetMapping("/me")
    public String me() {
        return "/me";
    }

    @PostMapping("/reg")
    public String regMember(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setStatus(1);
        User savedUser = userRepo.save(user);
        log.info("reg member save {}", savedUser);
        return "/me";
    }
}
