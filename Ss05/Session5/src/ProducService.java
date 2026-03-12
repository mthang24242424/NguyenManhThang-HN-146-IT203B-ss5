import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProducService {
   static List<Product> products=new ArrayList<>();
   public void addProduct(Product p){
         for(Product e:products){
            if(e.getId()==p.getId()){
               throw  new InvalidProductException("Thêm trùng ID");
            }
         }
         products.add(p);
   }
   public void display(){
       products.forEach(System.out::println);
   }
   public Optional findbyid(int id){
      Optional<Product> f= products.stream().filter(e->e.getId()==id).findFirst();
      if(f.isEmpty()){
          throw new InvalidProductException("Khong tim thay");
      }
      return f;
   }
   public void delete(int id){
       Optional<Product> f=findbyid(id);
       if(f.isPresent()){
           products.remove(id);
       }
   }
}
