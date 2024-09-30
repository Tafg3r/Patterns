package Assigment1.Assigment2;

import java.util.HashMap;
import java.util.Map;

// Step 2: Factory Method Pattern
interface Notification {
    void notifyUser();
}

class EmailNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Отправка уведомления по электронной почте.");
    }
}

class SMSNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Отправка SMS-уведомления.");
    }
}

class NotificationFactory {
    public Notification createNotification(String type) {
        if (type.equalsIgnoreCase("EMAIL")) {
            return new EmailNotification();
        } else if (type.equalsIgnoreCase("SMS")) {
            return new SMSNotification();
        }
        return null;
    }
}

// Step 3: Abstract Factory Pattern
interface Smartphone {
    void getDetails();
}

interface Laptop {
    void getDetails();
}

class AppleSmartphone implements Smartphone {
    @Override
    public void getDetails() {
        System.out.println("Apple Smartphone.");
    }
}

class AppleLaptop implements Laptop {
    @Override
    public void getDetails() {
        System.out.println("Apple Laptop.");
    }
}

class SamsungSmartphone implements Smartphone {
    @Override
    public void getDetails() {
        System.out.println("Samsung Smartphone.");
    }
}

class SamsungLaptop implements Laptop {
    @Override
    public void getDetails() {
        System.out.println("Samsung Laptop.");
    }
}

interface DeviceFactory {
    Smartphone createSmartphone();
    Laptop createLaptop();
}

class AppleFactory implements DeviceFactory {
    @Override
    public Smartphone createSmartphone() {
        return new AppleSmartphone();
    }

    @Override
    public Laptop createLaptop() {
        return new AppleLaptop();
    }
}

class SamsungFactory implements DeviceFactory {
    @Override
    public Smartphone createSmartphone() {
        return new SamsungSmartphone();
    }

    @Override
    public Laptop createLaptop() {
        return new SamsungLaptop();
    }
}

// Step 4: Builder Pattern
class House {
    private String foundation;
    private String structure;
    private String roof;
    private boolean hasGarage;
    private boolean hasPool;

    private House(HouseBuilder builder) {
        this.foundation = builder.foundation;
        this.structure = builder.structure;
        this.roof = builder.roof;
        this.hasGarage = builder.hasGarage;
        this.hasPool = builder.hasPool;
    }

    public static class HouseBuilder {
        private String foundation;
        private String structure;
        private String roof;
        private boolean hasGarage;
        private boolean hasPool;

        public HouseBuilder(String foundation, String structure) {
            this.foundation = foundation;
            this.structure = structure;
        }

        public HouseBuilder withRoof(String roof) {
            this.roof = roof;
            return this;
        }

        public HouseBuilder withGarage(boolean hasGarage) {
            this.hasGarage = hasGarage;
            return this;
        }

        public HouseBuilder withPool(boolean hasPool) {
            this.hasPool = hasPool;
            return this;
        }

        public House build() {
            return new House(this);
        }
    }

    @Override
    public String toString() {
        return "House [foundation=" + foundation + ", structure=" + structure + ", roof=" + roof +
                ", hasGarage=" + hasGarage + ", hasPool=" + hasPool + "]";
    }
}

// Step 5: Prototype Pattern
abstract class Shape implements Cloneable {
    private String id;
    protected String type;

    abstract void draw();

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Circle extends Shape {
    public Circle() {
        type = "Circle";
    }

    @Override
    void draw() {
        System.out.println("Рисование круга.");
    }
}

class Rectangle extends Shape {
    public Rectangle() {
        type = "Rectangle";
    }

    @Override
    void draw() {
        System.out.println("Рисование прямоугольника.");
    }
}

class ShapeCache {
    private static Map<String, Shape> shapeMap = new HashMap<>();

    public static Shape getShape(String shapeId) {
        Shape cachedShape = shapeMap.get(shapeId);
        try {
            return (Shape) cachedShape.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void loadCache() {
        Circle circle = new Circle();
        circle.setId("1");
        shapeMap.put(circle.getId(), circle);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("2");
        shapeMap.put(rectangle.getId(), rectangle);
    }
}

// Main Class to demonstrate all patterns
public class Main {
    public static void main(String[] args) {
        // Singleton Pattern Example
        System.out.println("Singleton Pattern:");
        DatabaseConnection connection1 = DatabaseConnection.getInstance();
        DatabaseConnection connection2 = DatabaseConnection.getInstance();
        System.out.println(connection1 == connection2); // true, same instance
        System.out.println();

        // Factory Method Pattern Example
        System.out.println("Factory Method Pattern:");
        NotificationFactory notificationFactory = new NotificationFactory();
        Notification emailNotification = notificationFactory.createNotification("EMAIL");
        Notification smsNotification = notificationFactory.createNotification("SMS");
        emailNotification.notifyUser();
        smsNotification.notifyUser();
        System.out.println();

        // Abstract Factory Pattern Example
        System.out.println("Abstract Factory Pattern:");
        DeviceFactory appleFactory = new AppleFactory();
        Smartphone applePhone = appleFactory.createSmartphone();
        Laptop appleLaptop = appleFactory.createLaptop();
        applePhone.getDetails();
        appleLaptop.getDetails();

        DeviceFactory samsungFactory = new SamsungFactory();
        Smartphone samsungPhone = samsungFactory.createSmartphone();
        Laptop samsungLaptop = samsungFactory.createLaptop();
        samsungPhone.getDetails();
        samsungLaptop.getDetails();
        System.out.println();

        // Builder Pattern Example
        System.out.println("Builder Pattern:");
        House house = new House.HouseBuilder("Concrete", "Wood")
                .withRoof("Shingle")
                .withGarage(true)
                .withPool(false)
                .build();
        System.out.println(house);
        System.out.println();

        // Prototype Pattern Example
        System.out.println("Prototype Pattern:");
        ShapeCache.loadCache();
        Shape clonedShape1 = ShapeCache.getShape("1");
        System.out.println("Shape : " + clonedShape1.getType());
        clonedShape1.draw();

        Shape clonedShape2 = ShapeCache.getShape("2");
        System.out.println("Shape : " + clonedShape2.getType());
        clonedShape2.draw();
    }
}