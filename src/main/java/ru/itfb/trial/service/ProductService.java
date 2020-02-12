package ru.itfb.trial.service;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import ru.itfb.trial.model.Client;
import ru.itfb.trial.model.Product;
import ru.itfb.trial.repository.ClientRepository;
import ru.itfb.trial.repository.ProductRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ClientRepository clientRepository;

    public Product getById(Long id) {
        return productRepository.findById(id).orElseThrow(IllegalAccessError::new);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> findAllForClient() {
        return productRepository.findAllByClientId(Long.parseLong(RequestContextHolder.currentRequestAttributes().getSessionId()));
    }

    public Product getByName(String name){
        return productRepository.findByName(name).orElseThrow(IllegalAccessError::new);
    }

    public Product update(Product product) {
        if (productRepository.existsById(product.getId())) {
            productRepository.save(product);
        } else {
            throw new IllegalArgumentException("No such client found");
        }
        return product;
    }

    public void delete(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("No such client found");
        }
    }

    public Product create(Product product) {
        productRepository.save(product);
        return product;
    }
}
