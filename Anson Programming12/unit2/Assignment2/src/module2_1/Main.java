package module2_1;

public class Main {
    public static void main(String[] args) {
        Planet a = new Planet("12345 P-L", PlanetType.DWARF);
        Planet b = new Planet("12345 P-L", PlanetType.ICE_GIANT);

        if (a.equals(b)) {
            System.out.println("same");
        }
        else {
            System.out.println("different");
        }
        System.out.println(a);
        System.out.println(b);

        System.out.println(a.hashCode());
        System.out.println(b.hashCode());

    }


}
