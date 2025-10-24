package kr.ai.kjun.api.product.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.ai.kjun.api.common.domain.Messenger;
import kr.ai.kjun.api.product.domain.ProductDto;

@Repository
public class ProductRepository {

    
    public Messenger save(ProductDto product) {
        Messenger messenger = new Messenger();
        messenger.setCode(200);
        messenger.setMessage("Product saved successfully");
        return messenger;
    }

    
    public Messenger saveAll(List<ProductDto> products) {
        Messenger messenger = new Messenger();
        messenger.setCode(200);
        messenger.setMessage("Products saved successfully");
        return messenger;
    }

    
    public Messenger update(ProductDto product) {
        Messenger messenger = new Messenger();
        messenger.setCode(200);
        messenger.setMessage("Product updated successfully");
        return messenger;
    }

    
    public Messenger delete(String id) {
        Messenger messenger = new Messenger();
        messenger.setCode(200);
        messenger.setMessage("Product deleted successfully");
        return messenger;
    }

    
    public Messenger findById(String id) {
        Messenger messenger = new Messenger();
        messenger.setCode(200);
        messenger.setMessage("Product found successfully");
        return messenger;
    }

    
    public Messenger findAll() {
        Messenger messenger = new Messenger();
        messenger.setCode(200);
        messenger.setMessage("Products found successfully");
        return messenger;
    }
    
}
