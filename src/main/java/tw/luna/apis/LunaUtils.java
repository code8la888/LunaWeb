package tw.luna.apis;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;


public class LunaUtils {

	public static String loadView(String view) throws Exception {
		String source= String.format(
				"C:\\Users\\USER\\eclipse-workspace\\LunaWeb\\src\\main\\webapp\\views\\view1.html");
		File viewFile = new File(source);
		int len =(int)viewFile.length();
		byte[] buf =new byte[len];
		BufferedInputStream bin=new BufferedInputStream(new FileInputStream(viewFile));
		bin.read(buf);
		bin.close();
		
		return new String(buf);
	}
	public static String calc(String x, String y,String op) {
		try {
			int intX=Integer.parseInt(x);
			int intY=Integer.parseInt(y);
			StringBuffer sb=new StringBuffer();
			switch (op) {
			case "1": sb.append(intX+intY);break;
			case "2": sb.append(intX-intY);break;
			case "3": sb.append(intX*intY);break;
			case "4": 
				sb.append(intX/intY).append(".....").append(intX%intY);
				break;
	
			}
			return sb.toString();
		} catch (Exception e) {
			return"";
		}
	
		
	}
}
