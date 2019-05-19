package products;

import java.util.Collection;

/**
 * This interface represents a ProductContainer for subclasses of products.AbstractAdditionalProduct
 * @param <T> the type of used collection
 * @param <E> the type of subclasses of products.AbstractAdditionalProduct to be contained
 */
interface AdditionalProductContainer<T extends Collection, E extends AbstractAdditionalProduct>
        extends ProductContainer<T, E> {
}
