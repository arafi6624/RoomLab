package Items;

public class Fire implements Materials{
    @Override
    public void type() {
        System.out.println("Fire");
    }

    @Override
    public void quantity() {
        System.out.println(1);
    }
}
