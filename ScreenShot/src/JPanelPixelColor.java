import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JPanelPixelColor extends JPanel {
	
	ImageIcon backImage;
	
	public JPanelPixelColor(String screenDir) {
		backImage = new ImageIcon(screenDir);
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
	    BufferedImage scaledImage = getScaledImage();
	    super.paintComponent(g);
	    g.drawImage(scaledImage, 0, 0, null);
	}
	private BufferedImage getScaledImage(){
	    BufferedImage image = new BufferedImage(getWidth(),getHeight(), BufferedImage.TYPE_INT_RGB);
	    Graphics2D g2d = (Graphics2D) image.createGraphics();
	    g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY));
	    g2d.drawImage(backImage.getImage(), 0, 0,getWidth(),getHeight(), null);

	    return image;
	}

}
