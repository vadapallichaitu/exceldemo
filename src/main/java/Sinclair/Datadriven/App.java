package Sinclair.Datadriven;

import java.io.IOException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	ddcexcel obj =new ddcexcel();
    	List<String> s= obj.excelmode("Sheet1", "TC5","C:\\Users\\VRK CHAITANYA\\OneDrive\\Desktop\\demodata.xlsx");
    	System.out.print(s.get(1));
    }
}
