package gadgetarium.services.impl;

import gadgetarium.dto.request.ProductRequest;
import gadgetarium.dto.response.ProductDto;
import gadgetarium.dto.response.Response;
import gadgetarium.enums.InputType;
import gadgetarium.exceptions.NotFoundException;
import gadgetarium.models.Character;
import gadgetarium.models.Product;
import gadgetarium.models.SubCatalog;
import gadgetarium.repositories.ProductRepository;
import gadgetarium.repositories.SubCatalogRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
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

        SubCatalog subCatalog = subCatalogRepository.findById(subCatalogId).orElseThrow(()->
                new NotFoundException(
                "subCatalogId with id " + subCatalogId + " not found "
        ));

        Product product = new Product();

        product.setSubCatalog(subCatalog);

        product.setName(productRequest.getProductName());

        product.setBrandImage(productRequest.getBrandImage());

        product.setGuarantee(productRequest.getGuarantee());

        product.setArticle(productRequest.getArticle());

        product.setPrice(productRequest.getPrice());

        product.setCount(productRequest.getCount());

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
        return productRepository.findById(productId).orElseThrow(()->new NotFoundException(
                "product with id " + productId + " not found "
        ));
    }

    private BigDecimal currentPrice(int percent, BigDecimal oldPrice){
        int newPrice;
        newPrice = oldPrice.intValue() - (oldPrice.intValue() * percent / 100);
        return BigDecimal.valueOf(newPrice);
    }

    private String image (Product product){
        Product product1 = productRepository.findById(product.getId()).get();
        String image = new String();
        List<Character> characters = product1.getCharacters();
        for (Character ch: characters){
            for (String s: ch.getImages()) {
                image=s;
                break;
            }
        }
        return image;
    }

    private LocalDate date (Product product){
        Product product1 = productRepository.findById(product.getId()).get();
        LocalDate date = null;
        for (Character character: product1.getCharacters()) {
            date = character.getDate();
        }
        return date;
    }

    public List<ProductDto> findAll() {
        List<Product> products = productRepository.findAll();
        List<ProductDto> productDtos = new ArrayList<>();

        for (Product p: products) {
            ProductDto productDto = new ProductDto(
                    p.getId(),
                    image(p),
                    p.getName(),
                    p.getArticle(),
                    date(p),
                    p.getPrice(),
                    p.getDiscount(),
                    currentPrice(p.getDiscount(),p.getPrice()),
                    p.getCount()
            );
            productDtos.add(productDto);
        }
        return  productDtos;
    }

    public Response deleteById(Long productId) {
        boolean exists = productRepository.existsById(productId);

        if(!exists){
            throw new NotFoundException(
                    "product with id " + productId + " not found!"
            );
        }
        productRepository.deleteById(productId);

        return new Response(
                HttpStatus.OK,
                "Successfully deleted product"
        );
    }


    @Transactional
    public Response update(Long productId, ProductRequest productRequest) {
        Product product = productRepository.findById(productId).orElseThrow(() ->
                new NotFoundException(
                        "product with id " + productId + " not found!"
                ));


        if (productRequest.getProductName() !=null ){
            product.setName(productRequest.getProductName());
        }

        if (productRequest.getBrandImage() != null){
            product.setBrandImage(product.getBrandImage());
        }

        if (productRequest.getGuarantee()!= 0){
            product.setGuarantee(product.getGuarantee());
        }
        if (productRequest.getArticle()!=0){
            product.setArticle(productRequest.getArticle());
        }

        List<Character> characterList = product.getCharacters();
        List<Character> characters = new ArrayList<>();

        productRequest.getTextCharacterRequests().stream()
                .map(tcr -> {
                    if(characterList !=null) {
                        for (Character c : characterList) {
                            if (c != null) {
                                c.setType(InputType.TEXT_VALUE);
                                c.setTextValue(tcr.getValue());
                                characters.add(c);
                            }
                        }
                    }
                    return characters;
                });

        productRequest.getIntegerCharacterRequests().stream()
                        .map( tcr -> {
                            if(characterList !=null) {
                                for (Character c : characterList) {
                                    if (c != null) {
                                        c.setType(InputType.INT_VALUE);
                                        c.setIntValue(tcr.getValue());
                                        characters.add(c);
                                    }
                                }
                            }
                            return characters;
                        });

        productRequest.getIntDropDownCharacterRequests().stream()
                .map( tcr -> {
                    if(characterList !=null) {
                        for (Character c : characterList) {
                            if (c != null) {
                                c.setType(InputType.INT_DROP_DOWN);
                                c.setIntValues(tcr.getValues());
                                characters.add(c);
                            }
                        }
                    }
                    return characters;
                });
        productRequest.getTextDropDownCharacterRequests().stream()
                .map( tcr -> {
                    if(characterList !=null) {
                        for (Character c : characterList) {
                            if (c != null) {
                                c.setType(InputType.TEXT_DROP_DOWN);
                                c.setTextValues(tcr.getValues());
                                characters.add(c);
                            }
                        }
                    }
                    return characters;
                });
        productRequest.getImagesCharacterRequests().stream()
                .map( tcr -> {
                    if(characterList !=null) {
                        for (Character c : characterList) {
                            if (c != null) {
                                c.setType(InputType.IMAGES);
                                c.setImages(tcr.getImages());
                                characters.add(c);
                            }
                        }
                    }
                    return characters;
                });

        productRequest.getDateCharacterRequests().stream()
                .map( tcr -> {
                    if(characterList !=null) {
                        for (Character c : characterList) {
                            if (c != null) {
                                c.setType(InputType.DATE);
                                c.setDate(tcr.getDate());
                                characters.add(c);
                            }
                        }
                    }
                    return characters;
                });

        productRequest.getFileCharacterRequests().stream()
                .map( tcr -> {
                    if(characterList !=null) {
                        for (Character c : characterList) {
                            if (c != null) {
                                c.setType(InputType.FILE);
                                c.setFile(tcr.getFile());
                                characters.add(c);
                            }
                        }
                    }
                    return characters;
                });

        product.setCharacters(characters);

        return new Response(
                HttpStatus.OK,
                "Successfully updated product"
        );
    }
}
