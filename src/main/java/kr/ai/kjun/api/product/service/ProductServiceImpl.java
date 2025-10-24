package kr.ai.kjun.api.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.ai.kjun.api.common.domain.Messenger;
import kr.ai.kjun.api.product.domain.ProductDto;
import kr.ai.kjun.api.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Override
    public Messenger save(ProductDto product) {
        return productRepository.save(product);
    }

    @Override
    public Messenger saveAll(List<ProductDto> products) {
        return productRepository.saveAll(products);
    }

    @Override
    public Messenger findById(String id) {
        return productRepository.findById(id);
    }

    @Override
    public Messenger findAll() {
        return productRepository.findAll();
    }

    @Override
    public Messenger update(ProductDto product) {
        return productRepository.update(product);
    }

    @Override
    public Messenger delete(String id) {
        return productRepository.delete(id);
    }
    
}
