package Lesson_3;

public class Product {
    private String name;
    private String productionDate;
    private String manufacturer;
    private String countryOfOrigin;
    private double price;
    private boolean isReserved;

    public Product(String name, String productionDate, String manufacturer, String countryOfOrigin, double price,
            boolean isReserved) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.isReserved = isReserved;
    }

    public void printInfo() {
        System.out.println("Информация о товаре");
        System.out.println("Название товара: " + name);
        System.out.println("Дата производства: " + productionDate);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Страна производителя: " + countryOfOrigin);
        System.out.println("Цена: " + price);
        System.out.println("Состояние бронирования: " + (isReserved ? "Забронирован" : "Свободен"));
    }

    public static void main(String[] args) {
        Product product = new Product("Refrigerator", "08.2025", "Libherr", "Germany", 70000.00, false);

        product.printInfo();

        Product[] productsArray = new Product[5];
        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025", "Samsung Corp.", "Korea", 5599, true);
        productsArray[1] = new Product("Samsung S25 Ultra", "01.02.2025", "Samsung Corp.", "Korea", 5599, true);
        productsArray[2] = new Product("Samsung S25 Ultra", "01.02.2025", "Samsung Corp.", "Korea", 5599, true);
        productsArray[3] = new Product("Samsung S25 Ultra", "01.02.2025", "Samsung Corp.", "Korea", 5599, true);
        productsArray[4] = new Product("Samsung S25 Ultra", "01.02.2025", "Samsung Corp.", "Korea", 5599, true);

        Park.Attractions attractions1 = new Park().new Attractions("FreeFall", "10:00 - 20:00", 1000);

        attractions1.printInfo();
    }
}

class Park {
    public class Attractions {
        String attractions;
        String workingHours;
        double price;

        Attractions(String attractions, String workingHours, double price) {
            this.attractions = attractions;
            this.workingHours = workingHours;
            this.price = price;
        }

        public void printInfo() {
            System.out.println("Название аттракциона: " + attractions);
            System.out.println("Время работы: " + workingHours);
            System.out.println("Цена билета: " + price);
        }
    }

}
