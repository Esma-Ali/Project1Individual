import java.util.Iterator;

public class ClientWarehouseTest {
    public static void main(String[] args) {
        Warehouse warehouse = Warehouse.instance();

        System.out.println("===== SINGLETON TEST =====");
        Warehouse secondReference = Warehouse.instance();
        System.out.println(
                "Both references are the same: "
                        + (warehouse == secondReference));

        System.out.println("\n===== ADD CLIENT TEST =====");
        Client client1 = warehouse.addClient(
                "Esma Ali", "100 Main Street");
        Client client2 = warehouse.addClient(
                "Sara Ahmed", "200 Oak Street");
        Client client3 = warehouse.addClient(
                "Maya Johnson", "300 Lake Street");

        System.out.println(client1);
        System.out.println(client2);
        System.out.println(client3);

        System.out.println("\n===== DISPLAY ALL CLIENTS TEST =====");
        Iterator<Client> clients = warehouse.getClients();

        while (clients.hasNext()) {
            System.out.println(clients.next());
        }

        System.out.println("\n===== FIND CLIENT TEST =====");
        System.out.println(
                "Existing client: "
                        + warehouse.getClient(client2.getId()));
        System.out.println(
                "Invalid client: "
                        + warehouse.getClient("C999"));

        System.out.println("\n===== ADD PRODUCT TEST =====");
        Product product1 = warehouse.addProduct(
                "Laptop", 10, 799.99);
        Product product2 = warehouse.addProduct(
                "Headphones", 20, 49.99);
        Product product3 = warehouse.addProduct(
                "Keyboard", 30, 29.99);

        System.out.println(product1);
        System.out.println(product2);
        System.out.println(product3);

        System.out.println("\n===== DISPLAY ALL PRODUCTS TEST =====");
        Iterator<Product> products = warehouse.getProducts();

        while (products.hasNext()) {
            System.out.println(products.next());
        }

        System.out.println("\n===== FIND PRODUCT TEST =====");
        System.out.println(
                "Existing product: "
                        + warehouse.getProduct(product2.getId()));
        System.out.println(
                "Invalid product: "
                        + warehouse.getProduct("P999"));

        System.out.println("\n===== ADD TO WISHLIST TEST =====");
        System.out.println(
                "Add Laptop: "
                        + warehouse.addToWishlist(
                                client1.getId(),
                                product1.getId(),
                                5));

        System.out.println(
                "Add Headphones: "
                        + warehouse.addToWishlist(
                                client1.getId(),
                                product2.getId(),
                                2));

        System.out.println(
                "Update Laptop quantity to 8: "
                        + warehouse.addToWishlist(
                                client1.getId(),
                                product1.getId(),
                                8));

        System.out.println("\n===== DISPLAY WISHLIST TEST =====");
        Iterator<WishlistItem> wishlist =
                warehouse.getClientWishlist(client1.getId());

        while (wishlist.hasNext()) {
            System.out.println(wishlist.next());
        }

        System.out.println("\n===== ERROR TESTS =====");
        System.out.println(
                "Invalid client ID: "
                        + warehouse.addToWishlist(
                                "C999", product1.getId(), 4));

        System.out.println(
                "Invalid product ID: "
                        + warehouse.addToWishlist(
                                client1.getId(), "P999", 4));

        System.out.println(
                "Invalid quantity: "
                        + warehouse.addToWishlist(
                                client1.getId(),
                                product1.getId(),
                                0));

        System.out.println(
                "Wishlist for invalid client: "
                        + warehouse.getClientWishlist("C999"));

        System.out.println("\n===== TESTING COMPLETE =====");
    }
}
