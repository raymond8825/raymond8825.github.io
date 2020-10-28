public class DELLFactory extends ComputerFactory{
    @Override
    public Laptop createLaptop() {
        return new DELLLaptop();
    }

    @Override
    public PC createPC() {
        return new DELLPC();
    }
}