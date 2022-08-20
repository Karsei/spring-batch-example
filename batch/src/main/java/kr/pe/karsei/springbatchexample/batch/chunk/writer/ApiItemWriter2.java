package kr.pe.karsei.springbatchexample.batch.chunk.writer;

import kr.pe.karsei.springbatchexample.batch.domain.ApiRequestVO;
import kr.pe.karsei.springbatchexample.batch.domain.ApiResponseVO;
import kr.pe.karsei.springbatchexample.service.AbstractApiService;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.core.io.FileSystemResource;

import java.util.List;

public class ApiItemWriter2 extends FlatFileItemWriter<ApiRequestVO> {
    private final AbstractApiService apiService;

    public ApiItemWriter2(AbstractApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void write(List<? extends ApiRequestVO> items) throws Exception {
        ApiResponseVO responseVO = apiService.service(items);
        System.out.println("responseVO = " + responseVO);

        items.forEach(item -> item.setApiResponseVO(responseVO));

        super.setResource(new FileSystemResource("W:\\Application\\spring-batch-example\\batch\\src\\main\\resources\\product2.txt"));
        super.open(new ExecutionContext());
        super.setLineAggregator(new DelimitedLineAggregator<>());
        super.setAppendAllowed(true);
        super.write(items);
    }
}
