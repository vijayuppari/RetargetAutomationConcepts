package Data;

import org.testng.annotations.DataProvider;

public class Dataaproviders {

	@DataProvider(name = "DatforPost")
	public Object[][] dataforpost() {

		// Hard coded the number of data
		/*
		 * Object[][] data= new Object[2][3];
		 * 
		 * data[0][0]="Sarker"; data[0][1]="Palli"; data[0][2]="1";
		 * 
		 * data[1][0]="Paker"; data[1][1]="Tati"; data[1][2]="3";
		 * 
		 * return data;
		 */

		return new Object[][] { { "Bell", "Graham", 1 }, { "Thomas", "Alwa", 3 } };
	}

	@DataProvider(name = "DeleteData")
	public Object[] deletedata() {
		return new Object[] { 7,8 };
	}

}
