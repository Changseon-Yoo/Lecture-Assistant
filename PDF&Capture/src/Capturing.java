import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Capturing extends TimerTask {
	int x;
	int y;
	int width;
	int height;
	
	ArrayList<BufferedImage> captureIMG = new ArrayList<>();
	
	public Capturing(int[] information) {	// 캡쳐 범위 초기화
		this.x = information[0];
		this.y = information[1];
		this.width = information[2];
		this.height = information[3];
	}
	
	public void run() {
		Robot robot;
		try {
			robot = new Robot();
			captureIMG.add(robot.createScreenCapture(new Rectangle(x+2,y+2,width-4,height-4)));	//이 클래스의 static arrayList에 이미지 추가
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	
	public void syncPosition(int[] information) { // 캡쳐 범위 동기화
		this.x = information[0];
		this.y = information[1];
		this.width = information[2];
		this.height = information[3];
	}
	
	public BufferedImage getCaptureImg(int index) throws ArrayIndexOutOfBoundsException{
		return captureIMG.get(index);
	}
	
	public boolean endPos(int index) {
		if(index == captureIMG.size()-1) return true;
		else return false;
	}
}
