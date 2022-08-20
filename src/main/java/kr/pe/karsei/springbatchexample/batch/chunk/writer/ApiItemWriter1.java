package kr.pe.karsei.springbatchexample.batch.chunk.writer;

import kr.pe.karsei.springbatchexample.batch.domain.ApiRequestVO;
import kr.pe.karsei.springbatchexample.batch.domain.ApiResponseVO;
import kr.pe.karsei.springbatchexample.service.AbstractApiService;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class ApiItemWriter1 implements ItemWriter<ApiRequestVO> {
    private final AbstractApiService apiService;

    public ApiItemWriter1(AbstractApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void write(List<? extends ApiRequestVO> items) throws Exception {
        ApiResponseVO responseVO = apiService.service(items);
        System.out.println("responseVO = " + responseVO);
    }
}