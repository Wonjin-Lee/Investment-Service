package com.wonjin.investment.repository;

import com.wonjin.investment.domain.Product;
import lombok.extern.java.Log;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;

import java.time.LocalDateTime;

@Log
@Commit
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    @DisplayName("투자 상품 데이터 생성 테스트")
    void saveProduct() {
        // given
        Product product = new Product();
        product.setTitle("원자재 ETF");
        product.setTargetTotalAmount(10000000L);
        product.setCurrentTotalAmount(0L);
        product.setInvestorCount(0);
        product.setStatusFlag(true);
        product.setStartAt(LocalDateTime.of(2022, 3, 1, 0, 0, 0, 0));
        product.setFinishAt(LocalDateTime.of(2022, 5, 31, 11, 59, 59, 59));

        // when
        Product saveProduct = productRepository.save(product);

        // then
        Assertions.assertThat(product).isSameAs(saveProduct);
        Assertions.assertThat(saveProduct.getProduct_id()).isNotNull();
        Assertions.assertThat(productRepository.count()).isEqualTo(1);
    }
}