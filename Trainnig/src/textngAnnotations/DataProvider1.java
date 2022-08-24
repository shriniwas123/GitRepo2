package textngAnnotations;

import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

public class DataProvider1 {
	
	DataProvider1(String empid, String name){
		System.out.println("empname:"+name);
		System.out.println("empid:"+empid);
		
	}
	
	@DataProvider (name="id_pass")
	public Object [][] testData(){
		 Object [][] data= new Object [3][2];
		 data [0][0]="S305399";
		 data[0][1]= "Boi@1997";
		 
		 data [1][0]="diyd42817";
		 data [1][1]="Mr.harry";
		 
		 data [2][0]="diyd42817";
		 data [2][1]="1222";
		 

		 
		 
		return  data;
	}
  @Test(dataProvider="id_pass")
  public void f(String id , String pass) {
	  System.out.println(id);
	  System.out.println(pass);
  }
  
  public static void main(String[] args) {
	  DataProvider1 em1= new DataProvider1("1203","shriniwas");
	  DataProvider1 em2= new DataProvider1("1204","rohit");
}
}
