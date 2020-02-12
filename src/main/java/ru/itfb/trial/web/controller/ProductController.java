package ru.itfb.trial.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itfb.trial.model.Product;
import ru.itfb.trial.service.ProductService;
import ru.itfb.trial.web.dto.ProductInDto;
import ru.itfb.trial.web.dto.ProductOutDto;
import ru.itfb.trial.web.mapper.ProductMapper;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductMapper productMapper;
    private final ProductService productService;

//    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    ProductOutDto getById(@PathVariable Long id) {
//        return productMapper.productToDto(productService.getById(id));
//    }

    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
    public String findAll(Model model) {
        model.addAttribute("products", productMapper.productToDto(productService.findAll()));
        return "product/products";
    }

    @GetMapping(value = "/client", produces = MediaType.TEXT_HTML_VALUE)
    public String findAllForClient(Model model) {
        model.addAttribute("products", productMapper.productToDto(productService.findAllForClient()));
        return "product/products";
    }



//    @GetMapping(value = "/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
//    ProductOutDto getByName(@PathVariable String name) {
//        return productMapper.productToDto(productService.getByName(name));
//    }
//
//    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
//    ProductOutDto update(@PathVariable Long id, @ModelAttribute("ProductInDto") ProductInDto productInDto) {
//        Product product = productMapper.dtoToProduct(productInDto);
//        product.setId(id);
//        return (productMapper.productToDto(productService.update(product)));
//    }

    @GetMapping(value = "/add")
    public String showAddProducts(Model model){
        ProductInDto productInDto = new ProductInDto();
        model.addAttribute("ProductInDto", productInDto);
        return "product/addProduct";
    }

    @PostMapping(value = "/add")
    public String addProduct(Model model, @ModelAttribute("ProductInDto") ProductInDto productInDto) {
        productMapper.productToDto(productService.create(productMapper.dtoToProduct(productInDto)));
        return "redirect:/product";
    }

//    @DeleteMapping(value = "/{id}")
//    void delete(@PathVariable Long id) {
//        productService.delete(id);
//    }
}
