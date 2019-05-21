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

        List<Product> productsInCart = Arrays.asList(
                new MainProduct(4) {{
                    addProduct(a1); // should be added to recommendation
                    addProduct(a2); // should be added to recommendation
                }},
                new MainProduct(5) {{
                    addProduct(b1); // should be added to recommendation
                }},
                a3, // should be excluded from recommendation
                new MainProduct(6) {{
                    addProduct(a3); // has been excluded
                    addProduct(a1); // should be added to recommendation
                }},
                new MainProduct(7)
        );

        assert recommendation.getRecommendation(productsInCart)
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
