package tw.luna.javaee;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Luna17")
public class Luna17 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String source = "C:\\Users\\USER\\eclipse-workspace\\LunaWeb\\src\\main\\webapp\\upload\\PC_5.jpg";
		
		BufferedImage img = ImageIO.read(new File(source));
		Graphics2D g2d = img.createGraphics();
		
		Font font1=new Font(null, Font.BOLD, 72);
		AffineTransform af = new AffineTransform();
		af.rotate(Math.toRadians(30));
		Font font2=font1.deriveFont(af);
		
		g2d.setColor(Color.white);
		g2d.setFont(font2);
		
		g2d.drawString("©️wishyougoolight", 200, 200);
		
		response.setContentType("image/jpeg");
		ImageIO.write(img,"JPEG",response.getOutputStream());
		response.flushBuffer();
		ImageIO.write(img, "JPEG", new File("d:Luna/Luna.jpg"));
	}

}
