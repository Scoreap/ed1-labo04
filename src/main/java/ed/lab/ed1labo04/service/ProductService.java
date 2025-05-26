package ed.lab.ed1labo04.service;

import ed.lab.ed1labo04.entity.ProductEntity;
import ed.lab.ed1labo04.model.CreateProductRequest;
import ed.lab.ed1labo04.model.UpdateProductRequest;
import ed.lab.ed1labo04.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductEntity createProduct(CreateProductRequest createProductRequest){
        if(createProductRequest.getPrice() <= 0)
                throw new IllegalArgumentException("El valor debe ser mayor a 0");

        ProductEntity productEntity = new ProductEntity();

        productEntity.setName(createProductRequest.getName());
        productEntity.setPrice(createProductRequest.getPrice());
        productEntity.setQuantity(0);

        return productRepository.save(productEntity);
    }

    public ProductEntity updateProduct(long id, UpdateProductRequest updateProductRequest){
        if(updateProductRequest.getPrice() <= 0)
            throw new IllegalArgumentException("El valor debe ser mayor a 0");
        if(updateProductRequest.getQuantity() < 0)
            throw new IllegalArgumentException("El valor debe ser mayor o igual a 0");

        ProductEntity product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("El producto no existe"));

        product.setQuantity(updateProductRequest.getQuantity());
        product.setPrice(updateProductRequest.getPrice());

        return productRepository.save(product);
    }

    public List<ProductEntity> getAllProducts(){
        return productRepository.findAll();
    }

    public Optional<ProductEntity> getProductById(Long id){
        return productRepository.findById(id);
    }
}
