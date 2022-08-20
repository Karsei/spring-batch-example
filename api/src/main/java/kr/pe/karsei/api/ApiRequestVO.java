package kr.pe.karsei.api;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ApiRequestVO {
    private long id;
    private ProductVO productVO;
}
