package kr.pe.karsei.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ApiController {
    // 각각 API 1, 2, 3번 서버라고 가정
    //@PostMapping("/api/product/{id}")
    @PostMapping("/api/product/1")
    public String product1(@RequestBody ApiInfo apiInfo) {
        List<ProductVO> productVOList = apiInfo.getApiRequestList().stream().map(item -> item.getProductVO()).collect(Collectors.toList());
        System.out.println("productVOList = " + productVOList);

        return "product1 was successfully processed";
    }

    @PostMapping("/api/product/2")
    public String product2(@RequestBody ApiInfo apiInfo) {
        List<ProductVO> productVOList = apiInfo.getApiRequestList().stream().map(item -> item.getProductVO()).collect(Collectors.toList());
        System.out.println("productVOList = " + productVOList);

        return "product2 was successfully processed";
    }

    @PostMapping("/api/product/3")
    public String product3(@RequestBody ApiInfo apiInfo) {
        List<ProductVO> productVOList = apiInfo.getApiRequestList().stream().map(item -> item.getProductVO()).collect(Collectors.toList());
        System.out.println("productVOList = " + productVOList);

        return "product3 was successfully processed";
    }
}
