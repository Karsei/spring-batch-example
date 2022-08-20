package kr.pe.karsei.springbatchexample.batch.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ApiResponseVO {
    private int status;
    private String msg;
}
