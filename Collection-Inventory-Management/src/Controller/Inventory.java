package Controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Inventory {
	
	
	String productname;
 int quantity;
 int rate;
 int total;
 
  Inventory(String productname,int quantity,int rate,int total) {
	  this.productname=productname;
	  this.quantity=quantity;
	  this.rate=rate;
	  this.total=total;
}
  
 public String getProductname(){
	 
	 return productname;
 }
 public int getQuantity(){
	 return quantity;
 }

 public int getRate(){
	 return rate;
 }
 public int getTotal(){
	 return total;
 }
	
	public String toString(){
		
		return  productname+"      "+quantity+"      "+rate+"     "+total; 
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		List<Inventory>c=new ArrayList<Inventory>();
		boolean loop=true;
		
		Scanner s=new Scanner(System.in);
		
		while(loop){
	
			System.out.println("1.add inventory");
			System.out.println("2.Show");
			System.out.println("3.Search Inventroy");
			System.out.println("4.Delete Inventory");
			System.out.println("5.update inventory");
			System.out.println("6.purchse");
			try{
			System.out.println("enter the choice");
int choice=Integer.parseInt(s.nextLine());			
			
			switch (choice){
			
			
			case 1:
				
				System.out.println("Enter Product Name");
				String productname=s.nextLine();
				System.out.println("Enter the Product Quantity");
				int quantity=Integer.parseInt(s.nextLine());
				System.out.println("Enter the product rate");
				int rate=Integer.parseInt(s.nextLine());
				System.out.println("Total :-"+quantity*rate+"$");
				int total= quantity*rate;
				c.add(new Inventory(productname, quantity, rate,total));
					
				
				break;
			
			case 2:
				
				Iterator<Inventory>i=c.iterator();
				while(i.hasNext()){
					
					Inventory inv =i.next();
					System.out.println("name   Quantity   rate  total ");
					System.out.println(inv);
					
				}
				
			
				break;
				
	case 3:
				System.out.println("Enter the product name");
				String name=s.nextLine();
				boolean found=false;

				i=c.iterator();
				Pattern pattern = Pattern.compile(".*" + name + ".*", Pattern.CASE_INSENSITIVE); 

				while(i.hasNext()){

					Inventory inv =i.next();
		            Matcher matcher = pattern.matcher(inv.productname);

					if(inv.productname.equals(name)){
						System.out.println("name   Quantity   rate  total ");

						System.out.println(inv);
					found=true;
					}
					
				}
				if(!found){
					System.out.println("Product Not Found");
				}
			
				break;
				
	case 4:
		System.out.println("Enter the product name");
	 name=s.nextLine();
		 found=false;
		i=c.iterator();
		while(i.hasNext()){
			
			Inventory inv =i.next();
			if(inv.productname.equals(name)){
			i.remove();
			found=true;
			}
			
		}
		if(!found){
			System.out.println("Product Not Found");
		}
	
		break;
		
	case 5:
		System.out.println("Enter the product name");
	 name=s.nextLine();
		 found=false;
		 ListIterator<Inventory>li=c.listIterator(); 
		
		while(li.hasNext()){
			
			Inventory inv =li.next();
			if(inv.productname.equals(name)){
				/*System.out.println("1.Quantity");
				System.out.println("2.Rate");
			System.out.println("What do you want to update");
		int	update=Integer.parseInt(s.nextLine());*/
			/*	switch(update)
				{*/
				
				//case 1:
					System.out.println("Enter product Quantity");
					int newquantity=Integer.parseInt(s.nextLine());

				//	li.set(new Inventory(productname, quantity, rate, total));

					//break;
					
				//case 2:
					
					System.out.println("Enter the rate");
					rate=Integer.parseInt(s.nextLine());
					total=newquantity*rate;
					
					
						//	break;
				li.set(new Inventory(name, newquantity, rate, total));
				
			//	}
								
				
			found=true;
			}
			
		}
		if(!found){
			System.out.println("Product Not Found");
		}
	
		break;
				
				
	case 6:
	    System.out.println("Enter the product name");
	    name = s.nextLine();
	    found = false;
	    li = c.listIterator();
	    while (li.hasNext()) {
	        Inventory inv = li.next();
	        if (inv.productname.equals(name)) {
	            System.out.println("Enter the quantity to purchase");
	            int purchaseQuantity = Integer.parseInt(s.nextLine());
	            if (purchaseQuantity > 0) {
	                inv.quantity += purchaseQuantity;
	                inv.total =inv.quantity*inv.rate;
	                System.out.println("Purchase successful!");
	            } else {
	                System.out.println("Invalid quantity entered.");
	            }
	            found = true;
	        }
	    }
	    if (!found) {
	        System.out.println("Product Not Found");
	    }
	    break;
				
			
			
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
			}
			
			
			
			
}catch(Exception e){
	System.out.println("not found"+e);
				
				
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
	}

}
