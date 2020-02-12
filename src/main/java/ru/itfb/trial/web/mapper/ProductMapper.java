package ru.itfb.trial.web.mapper;

import ru.itfb.trial.model.Product;
import org.mapstruct.Mapper;
import ru.itfb.trial.web.dto.ProductInDto;
import ru.itfb.trial.web.dto.ProductOutDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product dtoToProduct (ProductInDto productDTO);
    ProductOutDto productToDto (Product product);
    List<ProductOutDto> productToDto (List<Product> products);
}
