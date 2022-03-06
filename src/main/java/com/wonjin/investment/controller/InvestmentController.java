package com.wonjin.investment.controller;

import com.wonjin.investment.domain.Product;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@Log
@RestController
@RequestMapping("/investment")
public class InvestmentController {

    @GetMapping("/product/list")
    public List<Product> getInvestmentProductList() {
        log.info("Call Investment Product List Inquiry API !!!");

        return Arrays.asList(
                new Product(),
                new Product()
        );
    }
}
