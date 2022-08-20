package kr.pe.karsei.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor @AllArgsConstructor
public class ProductVO {
    private long id;
    private String name;
    private int price;
    private String type;
}
