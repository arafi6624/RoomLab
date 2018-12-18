package Items;

public class Sticks implements Materials{

    @Override
    public void type() {
        System.out.println("Sticks");
    }

    @Override
    public void quantity() {
        System.out.println(10);
    }
}
