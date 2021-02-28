package com.geekbrains.geek.market.controllers;

import com.geekbrains.geek.market.entities.Product;
import com.geekbrains.geek.market.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/edit/{id}")
@AllArgsConstructor
public class EditController {
    private ProductService productService;

    @GetMapping()
    public String showAllProducts(Model model,
                                  @RequestParam(defaultValue = "1", name = "p") Integer page,
                                  @RequestParam(name = "id", required = false) Long id,
                                  @RequestParam(name = "title", required = false) String title,
                                  @RequestParam(name = "price", required = false) Integer price
    ) {


//        product.setId(id);
//        product.setPrice(price);
//        product.setTitle(title);
        if (page < 1){
            page = 1;
        }
        Page<Product> products = productService.edit(id, title, price, 0, 5);
        model.addAttribute("products", products);
        return "edit";
    }
}