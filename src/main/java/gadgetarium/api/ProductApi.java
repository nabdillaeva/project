package gadgetarium.api;

import gadgetarium.dto.request.ProductRequest;
import gadgetarium.dto.response.Response;
import gadgetarium.models.Product;
import gadgetarium.services.impl.ProductService;
import org.springframework.web.bind.annotation.*;

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
}
