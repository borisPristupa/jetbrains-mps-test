package products;

import java.util.Collection;

/**
 * An interface of container for products of specific type(s).
 * <br>
 * In comparison to just having a Collection< products.Product > field, this approach gives an opportunity for
 * specifying strict bounds for both contained products' type(s) and the type of used collection.
 *
 * @param <T> the type of used collection
 * @param <E> the type(s) of contained products
 */
public interface ProductContainer<T extends Collection, E extends Product> {
    T getProducts();

    boolean addProduct(E product);
    boolean removeProduct(E product);
}
