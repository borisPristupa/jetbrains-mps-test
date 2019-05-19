package products;

import java.util.Collection;

/**
 * This class provides a mock for a system, recommending additional products for selected products
 */
public abstract class AbstractProductRecommendation {
    public abstract Collection<AbstractAdditionalProduct> getRecommendation(Collection<Product> recommendationSource);
}
