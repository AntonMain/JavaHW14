package Product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductTest {

    @Test
    public void checkRemoveProduct() {

        Repo repo = new Repo();
        ProductManager manager = new ProductManager(repo);

        Book book1 = new Book(76, "Хранители Кольца", 250, "Джон Роналд Руэл Толкин");
        Book book2 = new Book(77, "Две твердыни", 300, "Джон Роналд Руэл Толкин");
        Book book3 = new Book(78, "Возвращение короля", 500, "Джон Роналд Руэл Толкин");
        Book book4 = new Book(79, "Гарри Поттер и узник Азкабана", 300, "Джоан Кэтлин Роулинг");
        SmartPhone phone = new SmartPhone(5, "Phone 14", 110_000, "Samsung");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.add(book4);
        repo.add(phone);

        repo.removeById(78);

        Product[] expected = {book1, book2, book4, phone};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void checkWhatDoesNotBe() {

        Repo repo = new Repo();
        ProductManager manager = new ProductManager(repo);

        Book book1 = new Book(76, "Хранители Кольца", 250, "Джон Роналд Руэл Толкин");
        Book book2 = new Book(77, "Две твердыни", 300, "Джон Роналд Руэл Толкин");
        Book book3 = new Book(78, "Возвращение короля", 500, "Джон Роналд Руэл Толкин");
        SmartPhone phone = new SmartPhone(5, "Phone 14", 110_000, "Samsung");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.add(phone);

        Assertions.assertThrows(NotFoundException.class, () -> repo.removeById(-100));
    }

    @Test
    public void searchIfProductsFound() {

        Repo repo = new Repo();
        ProductManager manager = new ProductManager(repo);

        Book book1 = new Book(76, "Гарри Поттер и философский камень", 250, "Джоан Кэтлин Роулинг");
        Book book2 = new Book(77, "Гарри Поттер и Тайная комната", 300, "Джоан Кэтлин Роулинг");
        Book book3 = new Book(78, "Возвращение короля", 500, "Джон Роналд Руэл Толкин");
        Book book4 = new Book(79, "Гарри Поттер и узник Азкабана", 300, "Джоан Кэтлин Роулинг");
        SmartPhone phone = new SmartPhone(5, "Phone 14", 110_000, "Samsung");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(phone);

        Product[] expected = {book1, book2, book4};
        Product[] actual = manager.searchBy("Гарри");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void checkIfZeroProducts() {
        Repo repo = new Repo();
        ProductManager manager = new ProductManager(repo);

        Book book1 = new Book(76, "Гарри Поттер и философский камень", 250, "Джоан Кэтлин Роулинг");
        Book book2 = new Book(77, "Гарри Поттер и Тайная комната", 300, "Джоан Кэтлин Роулинг");
        Book book3 = new Book(78, "Возвращение короля", 500, "Джон Роналд Руэл Толкин");
        SmartPhone phone = new SmartPhone(5, "Phone 14", 110_000, "Samsung");

        Product[] expected = {};
        Product[] actual = manager.searchBy("Гарри Поттер и узник Азкабана");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void producerTest() {
        SmartPhone phone = new SmartPhone(5, "Phone 14", 110_000, "Samsung");
        ;

        String expected = "Samsung";
        String actual = phone.getProducer();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void priceTest() {

        SmartPhone phone = new SmartPhone(5, "Phone 14", 110_000, "Samsung");

        int expected = 110_000;
        int actual = phone.getPrice();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void authorTest() {
        Book book = new Book(76, "Хранители Кольца", 250, "Джон Роналд Руэл Толкин");

        String expected = "Джон Роналд Руэл Толкин";
        String actual = book.getAuthor();

        Assertions.assertEquals(expected, actual);
    }
}