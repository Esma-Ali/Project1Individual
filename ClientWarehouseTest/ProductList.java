import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductList implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Product> products;

    public ProductList() {
        products = new LinkedList<Product>();
    }

    public boolean insertProduct(Product product) {
        if (product == null) {
            return false;
        }

        return products.add(product);
    }

    public Iterator<Product> getProducts() {
        return products.iterator();
    }

    public Product findProduct(String productID) {
        if (productID == null) {
            return null;
        }

        for (Product product : products) {
            if (product.getId().equals(productID)) {
                return product;
            }
        }

        return null;
    }
}
