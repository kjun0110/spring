package kr.ai.kjun.api.product.controller;

import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ai.kjun.api.common.domain.Messenger;
import kr.ai.kjun.api.product.domain.ProductDto;
import kr.ai.kjun.api.product.service.ProductService;
import kr.ai.kjun.api.user.domain.UserDTO;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @PostMapping("")
    public String save(ProductDto product, Model model) {
        Messenger messenger = productService.save(product);
        model.addAttribute("messenger", messenger);
        return "Product/save";
    }

    @PostMapping("/all")
    public String saveAll(List<ProductDto> products, Model model) {
        Messenger messenger = productService.saveAll(products);
        model.addAttribute("messenger", messenger);
        return "Product/list";
    }

    @PutMapping("/{id}")
    public String update(Model model) {
        ProductDto product = new ProductDto();
        Messenger messenger = productService.update(product);
        model.addAttribute("messenger", messenger);
        return "Product/detail";
    }

    @DeleteMapping("/{id}")
    public String delete(String id, Model model) {
        Messenger messenger = productService.delete(id);
        model.addAttribute("messenger", messenger);
        return "Product/list";
    }

    @GetMapping("/id/{id}")
    public String findById(String id, Model model) {
        Messenger messenger = productService.findById(id);
        model.addAttribute("messenger", messenger);
        return "Product/detail";
    }

    @GetMapping("/all")
    public String findAll(Model model) {
        Messenger messenger = productService.findAll();
        model.addAttribute("messenger", messenger);
        return "Product/list";
    }
}