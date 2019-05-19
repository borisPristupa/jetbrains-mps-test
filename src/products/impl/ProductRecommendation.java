package products.impl;

import products.AbstractAdditionalProduct;
import products.AbstractMainProduct;
import products.AbstractProductRecommendation;
import products.meta.Product;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class ProductRecommendation extends AbstractProductRecommendation {
    @Override
    public Set<AbstractAdditionalProduct> getRecommendation(Collection<Product> recommendationSource) {

        return recommendationSource.stream()
                .filter(ratedProduct -> ratedProduct instanceof AbstractMainProduct)

                .map(ratedProduct -> ((AbstractMainProduct) ratedProduct).getProducts())
                .flatMap(Collection<AbstractAdditionalProduct>::stream)

                .filter(additionalProduct -> !recommendationSource.contains(additionalProduct))
                .collect(Collectors.toSet());
    }
}
