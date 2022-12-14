package kr.pe.karsei.springbatchexample.batch.chunk.processor;

import kr.pe.karsei.springbatchexample.batch.domain.ApiRequestVO;
import kr.pe.karsei.springbatchexample.batch.domain.ProductVO;
import org.springframework.batch.item.ItemProcessor;

public class ApiItemProcessor2 implements ItemProcessor<ProductVO, ApiRequestVO> {
    @Override
    public ApiRequestVO process(ProductVO item) throws Exception {
        return ApiRequestVO.builder()
                .id(item.getId())
                .productVO(item)
                .build();
    }
}
