package coffeeMachine.stage6;

class Cat {
    // write static and instance variables
    public String name;
    public int age;
    public static int counter;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        counter++;
        if (getNumberOfCats() > 5) {
            System.out.println("You have too many cats");
        }
    }

    public static int getNumberOfCats() {
        return counter;
    }
}

class Test {
    public static void main(String[] args) {
        Cat cat = new Cat("Jula", 22);
        Cat.getNumberOfCats();
    }
}