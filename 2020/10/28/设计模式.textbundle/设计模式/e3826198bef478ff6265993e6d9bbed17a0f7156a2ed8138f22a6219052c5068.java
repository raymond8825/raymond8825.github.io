public class AnimalFactory {
    public static Animal createAnimal(String type){
        if(type.equals("cat")){
            return new Cat();
        }else if (type.equals("dog")){
            return new Dog();
        }else {
            return null;
        }
    }

}
