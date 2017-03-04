
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//select driver for running
		
		String url = "https://www.google.pl/maps/@52.2229326,20.9125834,13z/data=!5m1!1e1";
		String url2 = "http://stackoverflow.com/questions/8837875/setting-remote-webdriver-to-run-tests-in-a-remote-computer-using-java";

		TakeScreenShot app = new TakeScreenShot();
		app.setUrlString(url2);
		System.out.println(app.getUrlString());
		app.getWeb();

		
		//Load JFrame to select pixel/waypoints from the saved screenshot
		JFrameMain gui = new JFrameMain(app.getScreenDir());
		System.out.println(app.getScreenDir());
		gui.makeGui();

		}
}

