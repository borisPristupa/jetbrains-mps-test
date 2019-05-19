package products;

/**
 * This class provides <b>rating</b> parameter for products.Product
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
