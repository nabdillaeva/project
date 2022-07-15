package gadgetarium.services.impl;

import gadgetarium.dto.request.ProductRequest;
import gadgetarium.dto.response.Response;
import gadgetarium.enums.InputType;
import gadgetarium.models.Character;
import gadgetarium.models.Product;
import gadgetarium.models.SubCatalog;
import gadgetarium.repositories.ProductRepository;
import gadgetarium.repositories.SubCatalogRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final SubCatalogRepository subCatalogRepository;

    public ProductService(ProductRepository productRepository, SubCatalogRepository subCatalogRepository) {
        this.productRepository = productRepository;
        this.subCatalogRepository = subCatalogRepository;
    }

    public Response save(Long subCatalogId, ProductRequest productRequest) {

        SubCatalog subCatalog = subCatalogRepository.findById(subCatalogId).get();

        Product product = new Product();

        product.setSubCatalog(subCatalog);

        product.setName(product.getName());

        List<Character> characters = new ArrayList<>();

        // text value
        productRequest.getTextCharacterRequests().stream()
                .map(tcr -> {
                    Character character = new Character();
                    character.setType(InputType.TEXT_VALUE);
                    character.setTextValue(tcr.getValue());
                    return character;
                }).forEach(characters::add);

        // int value
        productRequest.getIntegerCharacterRequests().stream()
                .map(temp -> {
                    Character character = new Character();
                    character.setType(InputType.INT_VALUE);
                    character.setIntValue(temp.getValue());
                    return character;
                }).forEach(characters::add);

        // text drop box
        productRequest.getTextDropDownCharacterRequests().stream()
                .map(temp -> {
                    Character character = new Character();
                    character.setType(InputType.TEXT_DROP_DOWN);
                    character.setTextValues(temp.getValues());
                    return character;
                }).forEach(characters::add);

        // int drop down
        productRequest.getIntDropDownCharacterRequests().stream()
                .map(temp -> {
                    Character character = new Character();
                    character.setType(InputType.INT_DROP_DOWN);
                    character.setIntValues(temp.getValues());
                    return character;
                }).forEach(characters::add);

//               DATE
        productRequest.getDateCharacterRequests().stream()
                .map(temp -> {
                    Character character = new Character();
                    character.setType(InputType.DATE);
                    character.setDate(temp.getDate());
                    return character;
                }).forEach(characters::add);

//                FILE
        productRequest.getFileCharacterRequests().stream()
                .map(temp -> {
                    Character character = new Character();
                    character.setType(InputType.FILE);
                    character.setFile(temp.getFile());
                    return character;
                }).forEach(characters::add);

//                COLORS
        productRequest.getColorCharacterRequests().stream()
                .map(temp -> {
                    Character character = new Character();
                    character.setType(InputType.COLORS);
                    character.setColors(temp.getColors());
                    return character;
                }).forEach(characters::add);

//                IMAGES
        productRequest.getImagesCharacterRequests().stream()
                .map(temp -> {
                    Character character = new Character();
                    character.setType(InputType.IMAGES);
                    character.setImages(temp.getImages());
                    return character;
                }).forEach(characters::add);

        product.setCharacters(characters);

        productRepository.save(product);

        return new Response(
                HttpStatus.OK,
                "SAVED NEW PRODUCT"
        );
    }

    public Product findById(Long productId) {
        return productRepository.findById(productId).get();
    }
}
