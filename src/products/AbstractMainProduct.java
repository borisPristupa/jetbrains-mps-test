package products;

import java.util.Collection;

/**
 * This class is a prototype of a main product, that refers to several additional products
 * @param <T> the type of collection to be used for referring the related additional products
 */
public abstract class AbstractMainProduct<T extends Collection> extends RatedProduct
        implements AdditionalProductContainer<T, AbstractAdditionalProduct> {
}
