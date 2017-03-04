import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JFramePixelColor {

	JFrame theFrame;
	JPanel mainPanel;
	JPanel panel;
	ImageIcon image;
	JLabel label;
	JButton button;
	String screenDir;
	File file;

	public JFramePixelColor(String screenDir) {
		this.screenDir = screenDir;
		file = new File(screenDir);
	}

	public void makeGui() {

		JPanelPixelColor mainPanel = new JPanelPixelColor(screenDir);
		mainPanel.addMouseListener(new MouseListener());

		button = new JButton("select pixel");

		image = new ImageIcon(screenDir);
		label = new JLabel("", image, JLabel.CENTER);

		/*
		 * mainPanel = new JPanel(new BorderLayout()); Dimension prefferedSize =
		 * new Dimension(); prefferedSize.setSize(image.getIconWidth(),
		 * image.getIconHeight()); mainPanel.setPreferredSize(prefferedSize);
		 * 
		 * mainPanel.add(label, BorderLayout.CENTER); mainPanel.add(panel,
		 * BorderLayout.SOUTH);
		 */

		// System.out.println("label size is: " + mainPanel.getSize());

		theFrame = new JFrame("Traffic Alert");
		// theFrame.add(button, BorderLayout.SOUTH);
		theFrame.pack();
		Insets insets = theFrame.getInsets();
		theFrame.setSize(new Dimension(insets.left + insets.right + image.getIconWidth(),
				insets.top + insets.bottom + image.getIconHeight()));
		theFrame.setContentPane(mainPanel);

		System.out.println(image.getIconWidth());
		System.out.println(image.getIconHeight());

		theFrame.setVisible(true);

	}

	public class MouseListener extends MouseAdapter {

		int x;
		int y;

		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println("Mouse clicked");
			Point b = e.getPoint();
			int x = (int) b.getX();
			int y = (int) b.getY();
			System.out.println(y);
			System.out.println(x);
			getPixelColor(x, y);

			theFrame.dispatchEvent(new WindowEvent(theFrame, WindowEvent.WINDOW_CLOSING));
		}

		public void getPixelColor(int x, int y) {
			BufferedImage image;
			try {
				image = ImageIO.read(file);
				Color[][] colors = new Color[image.getWidth()][image.getHeight()];
				colors[x][y] = new Color(image.getRGB(x, y));
				System.out.println("Colors" + colors[x][y]);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}

		}

	}
}
