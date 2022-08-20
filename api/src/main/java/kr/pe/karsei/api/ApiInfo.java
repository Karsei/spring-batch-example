package kr.pe.karsei.api;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class ApiInfo {
    private String url;
    private List<? extends ApiRequestVO> apiRequestList;
}
