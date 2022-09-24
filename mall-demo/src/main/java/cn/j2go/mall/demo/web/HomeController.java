package cn.j2go.mall.demo.web;

import cn.j2go.mall.demo.domain.Product;
import cn.j2go.mall.demo.domain.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class HomeController {

    final ProductRepo productRepo;

    @ResponseBody
    @GetMapping("/api/products")
    public Iterable<Product> getProducts() {
        return productRepo.findAll();
    }
}
