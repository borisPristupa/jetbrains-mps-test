package products.test;

import org.junit.jupiter.api.Test;
import products.AbstractProductRecommendation;
import products.Product;
import products.impl.AdditionalProduct;
import products.impl.MainProduct;
import products.impl.ProductRecommendation;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

class TestRecommendation {

    private AbstractProductRecommendation recommendation = new ProductRecommendation();

    @Test
    void testTotalCorrectness() {
        AdditionalProduct a1 = new AdditionalProduct(1),
                b1 = new AdditionalProduct(1),
                a2 = new AdditionalProduct(2),
                a3 = new AdditionalProduct(3);

        List<Product> ratedProducts = Arrays.asList(
                new MainProduct(4) {{
                    addProduct(a1);
                    addProduct(a2);
                }},
                new MainProduct(5) {{
                    addProduct(b1);
                }},
                a3,
                new MainProduct(6) {{
                    addProduct(a3);
                    addProduct(a1);
                }},
                new MainProduct(7)
        );

        assert recommendation.getRecommendation(ratedProducts)
                .equals(new HashSet<>(Arrays.asList(a1, a2, b1)));
    }

    @Test
    void testContains() {
        AdditionalProduct a = new AdditionalProduct(1);

        assert recommendation.getRecommendation(Collections.singletonList(
                new MainProduct(1) {{
                    addProduct(a);
                }}
        )).contains(a);
    }

    @Test
    void testNotContainsAlreadyInCart() {
        AdditionalProduct a = new AdditionalProduct(1);

        assert !recommendation.getRecommendation(Arrays.asList(
                new MainProduct(1) {{
                    addProduct(a);
                }},
                a
        )).contains(a);
    }
}
