// Code reviewed by @professorgordon.
//Saule Buhler

public class PurchaseReport 
{
	public static void main(String[] args) 
	{
		String item1 = "Shirt";
		String item2 = "Pants";
		String item3 = "Shoes";
		String item4 = "Belt";
		String item5 = "Coat";
		String total = "Total";
		
		System.out.println("=======================");
		System.out.println("Purchase Report");
		System.out.println("=======================");
		System.out.printf("%s \t\t $%,.2f\n", item1,21.99);
		System.out.printf("%s \t\t $%,.2f\n", item2,49.97);
		System.out.printf("%s \t\t $%,.2f\n", item3,89.50);
		System.out.printf("%s \t\t $%,.2f\n", item4,19.99);
		System.out.printf("%s \t        $%,.2f\n", item5,129.95);
		System.out.println("=======================");
		System.out.printf("%s \t        $%,.2f\n", total,311.40);
	}
}
