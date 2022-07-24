package gadgetarium.api;

import gadgetarium.dto.request.ProductRequest;
import gadgetarium.dto.response.ProductDto;
import gadgetarium.dto.response.Response;
import gadgetarium.models.Product;
import gadgetarium.services.impl.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductApi {

    private final ProductService productService;

    public ProductApi(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/{subCategory}/save")
    public Response save(@RequestBody ProductRequest productRequest,
                         @PathVariable Long subCategory) {
        return productService.save(subCategory, productRequest);
    }

    @GetMapping("/find/{productId}")
    public Product findById(@PathVariable Long productId) {
        Product byId = productService.findById(productId);
        return byId;
    }

    @GetMapping("/findAll")
    public List<ProductDto> findAll(){
        return productService.findAll();
    }

    @DeleteMapping("/{productId}/delete")
    public Response deleteById(@PathVariable Long productId){
        return productService.deleteById(productId);
    }

    @PutMapping("/{productId}/update")
    public Response update(@PathVariable Long productId,@RequestBody ProductRequest productRequest){
        return productService.update(productId,productRequest);
    }
}
