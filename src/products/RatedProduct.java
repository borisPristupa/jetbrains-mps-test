package products;

import products.meta.Product;

/**
 * This class provides <b>rating</b> parameter for products.meta.Product
 */
public abstract class RatedProduct implements Product {
    private int rating;

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

}
