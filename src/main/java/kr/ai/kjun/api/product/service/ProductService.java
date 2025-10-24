package kr.ai.kjun.api.product.service;

import java.util.List;

import kr.ai.kjun.api.common.domain.Messenger;
import kr.ai.kjun.api.product.domain.ProductDto;

public interface ProductService {
    
    Messenger save(ProductDto product);
    Messenger saveAll(List<ProductDto> products);
    Messenger update(ProductDto product);
    Messenger delete(String id);
    Messenger findById(String id);
    Messenger findAll();

    
}
