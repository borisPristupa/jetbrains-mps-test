package products.impl;

import products.AbstractAdditionalProduct;
import products.AbstractMainProduct;

import java.util.HashSet;
import java.util.Set;

public class MainProduct extends AbstractMainProduct<Set<AbstractAdditionalProduct>> {
    private Set<AbstractAdditionalProduct> additionalProducts = new HashSet<>();

    @Override
    public Set<AbstractAdditionalProduct> getProducts() {
        return new HashSet<>(additionalProducts);
    }

    @Override
    public boolean addProduct(AbstractAdditionalProduct product) {
        return additionalProducts.add(product);
    }

    @Override
    public boolean removeProduct(AbstractAdditionalProduct product) {
        return additionalProducts.remove(product);
    }

    public MainProduct(int rating) {
        setRating(rating);
    }
}
