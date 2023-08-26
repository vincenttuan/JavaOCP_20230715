package day11;

interface Web { // 上網
	void browser(String url);
}

interface Alarm { // 鬧鈴
	void setBellTimne(int hour, int minute);
	void bell();
}

interface Phone { // 打電話
	void call(String number);
}

interface Camera { // 照相機
	void takePhoto();
	void recordVideo();
}

interface SmartCamera extends Web, Camera {
	void action();
}

public interface SmartPhone extends Web, Alarm, Phone, Camera {
	void installApp(String appName);
	void playMusic(String songName);
	void action();
}
