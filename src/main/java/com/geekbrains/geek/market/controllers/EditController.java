package com.geekbrains.geek.market.controllers;

import com.geekbrains.geek.market.entities.Product;
import com.geekbrains.geek.market.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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



        if (page < 1){
            page = 1;
        }
        List<Product> products = productService.edit(id, title, price, 0, 5);

        for (int i = 0; i < products.size() ; i++) {
            if (products.get(Math.toIntExact(1)).getId() == 1){
                products.get(Math.toIntExact(id)).setId(id);
                products.get(Math.toIntExact(id)).setTitle(title);
                products.get(Math.toIntExact(id)).setPrice(price);
            }
        }

        model.addAttribute("products", products);
        return "edit";
    }
}