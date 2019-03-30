package homework11;


public class MainClass {
    public static void main(String[] args) throws Exception{
        System.out.println("start");
        FruitShop shop = new FruitShop();
        shop.load("F:\\Slava\\homework10\\src\\main\\java\\homework11\\delivery");
        shop.save("F:\\Slava\\homework10\\src\\main\\java\\homework11\\storage");
    }

}
