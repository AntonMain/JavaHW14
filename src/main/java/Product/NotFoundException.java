package Product;

public class NotFoundException extends RuntimeException {

    public NotFoundException(int id) {
        super("Product with this ID" + id + "was not found");
    }
}
