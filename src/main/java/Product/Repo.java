package Product;

public class Repo {
    private Product[] products = new Product[0];

    public void add(Product product) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[products.length] = product;
        products = tmp;
    }

    public void removeById(int idRemove) {
        if (findById(idRemove) == null) {
            throw new NotFoundException(idRemove);
        }
        Product[] tmp = new Product[products.length - 1];
        int indexInsert = 0;
        for (Product product : products) {
            if (product.getId() != idRemove) {
                tmp[indexInsert] = product;
                indexInsert++;
            }
        }
        products = tmp;
    }

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public Product[] findAll() {
        return products;
    }
}