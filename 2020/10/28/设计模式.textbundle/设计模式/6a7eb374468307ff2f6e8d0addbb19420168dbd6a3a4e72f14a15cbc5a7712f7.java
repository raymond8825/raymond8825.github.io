public class Main {
    public static void main(String[] args) {
        //1. 生产一只猫
        AnimalFactory animalFactory=new CatFactory();
        Animal a = animalFactory.createAnimal();
        a.eat();
    }
}
