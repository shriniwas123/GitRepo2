package textngAnnotations;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Paramaterization {
	@BeforeClass
	@Parameters({"Broweser","url"})
	public void setup (@Optional("Firefox") String broweser1, String url) {
		System.out.println("Broweser:" + broweser1);
		System.out.println("Broweser:" + url);
	}
	
	
	
  @Test
  public void f() {
	  System.out.println("test pass");
  }
}
