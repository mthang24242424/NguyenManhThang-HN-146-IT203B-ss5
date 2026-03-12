import java.lang.management.MonitorInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;


public class Main {
    static Scanner sc = new Scanner(System.in);
    static ProducService producService=new ProducService();
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("1.Add");
            System.out.println("2.display");
            System.out.println("3.Update");
            System.out.println("4.Delete");
            System.out.println("0.Exit");
            System.out.print("moi ban nhap lua chon: ");
            choice=Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    addItem();
                    break;
                case 2:
                    producService.display();
                    break;
                case 3:
                    Update();
                    break;
                case 4:
                    delete();
                    break;
                default:
                    break;
            }
        }while (choice!=0);
    }
    public static void addItem(){
        System.out.print("Moi ban nhap ten mon hang: ");
        String name=sc.nextLine();
        System.out.print("Moi ban nhap gia tien: ");
        double price=sc.nextDouble();
        System.out.print("Moi ban nhap so luong: ");
        int quantity=sc.nextInt();
        sc.nextLine();
        System.out.print("moi ban nhap the loai san pham: ");
        String category=sc.nextLine();
        producService.addProduct(new Product(category,name,price,quantity));
    }
    public static void Update(){
        System.out.print("Moi ban nhap id:");

        try{
            int id=sc.nextInt();
            sc.nextLine();
            Optional<Product>product = producService.findbyid(id);
            System.out.print("Moi ban nhap ten mon hang : ");
            String name=sc.nextLine();
            System.out.print("Moi ban nhap gia tien: ");
            double price=sc.nextDouble();
            System.out.print("Moi ban nhap so luong: ");
            int quantity=sc.nextInt();
            sc.nextLine();
            System.out.print("moi ban nhap the loai san pham: ");
            String category=sc.nextLine();
            Product item=product.get();
            item.setName(name);
            item.setCategory(category);
            item.setPrice(price);
            item.setQuantity(quantity);
        }catch (InvalidProductException e){
            System.out.println(e.getMessage());
        }
    }
     public static void delete() {
         System.out.print("Moi ban nhap id:");
         try {
             int id = sc.nextInt();
             sc.nextLine();
             producService.delete(id);
         }catch (InvalidProductException i){
             System.out.println(i.getMessage());
         }

    }
}