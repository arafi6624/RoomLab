package Items;

public class Wood implements Materials {

    @Override
    public void type() {
        System.out.println("Wood");
    }

    @Override
    public void quantity() {
        System.out.println(10);
    }
}
