package kr.pe.karsei.springbatchexample.batch.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ApiRequestVO {
    private long id;
    private ProductVO productVO;
}
