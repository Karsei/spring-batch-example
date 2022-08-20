package kr.pe.karsei.springbatchexample.batch.chunk.processor;

import kr.pe.karsei.springbatchexample.batch.domain.Product;
import kr.pe.karsei.springbatchexample.batch.domain.ProductVO;
import org.modelmapper.ModelMapper;
import org.springframework.batch.item.ItemProcessor;

public class FileItemProcessor implements ItemProcessor<ProductVO, Product> {
    @Override
    public Product process(ProductVO item) throws Exception {
        ModelMapper modelMapper = new ModelMapper();
        Product product = modelMapper.map(item, Product.class);

        return product;
    }
}
