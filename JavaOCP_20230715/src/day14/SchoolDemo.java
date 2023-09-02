package day14;

class School { // 學校:外部類別
	
	int studentAnount = 1000; // 全校學生總數
	
	class Teacher { // 老師:內部類別
		int studentAnount = 30; // 老師負責的學生人數
		void teach() { // 進行教學
			System.out.println("教學進行中...");
			System.out.printf("全校學生總數: %d\n", School.this.studentAnount);
			System.out.printf("老師負責的學生人數: %d\n", this.studentAnount);
		}
	}
	
	static class Course { // 課程: 靜態內部類別
		static void display() { // 顯示課程大綱資訊
			System.out.println("這是一門 Java 程式設計課程 ...");
		}
	}
	
	void organizeSeminar() { // 舉辦研討會: 方法
		int amount = 200; // 參加研討會人數
		class Seminar { // 研討會: 方法內部類別
			void detail() { // 研討會細節
				System.out.println("正在舉辦學生畢業專題研討會");
				System.out.printf("參加人數: %d\n", amount);
			}
		}
		Seminar seminar = new Seminar(); // 建立研討會
		seminar.detail(); // 研討會細節
	}
	
	interface Celebration { // 慶祝活動
		void celebrate(); // 慶祝
	}
	
	void schoolAnniversary() { // 校慶
		// 利用匿名內部類別語法來實現校慶慶祝活動
		Celebration celebration = new Celebration() {
			@Override
			public void celebrate() {
				System.out.println("正在慶祝校慶...");
			}
		};
		celebration.celebrate(); // 執行慶祝活動
	}
	
	void schoolSport() { // 運動會
		// 利用 Lambda 語法來實現運動會慶祝活動
		Celebration celebration = () -> System.out.println("正在舉辦運動會...");
		celebration.celebrate(); // 執行慶祝活動
	}
	
}

public class SchoolDemo {
	
	public static void main(String[] args) {
		School school = new School();
		School.Teacher teacher = school.new Teacher();
		teacher.teach();
		//----------------------------------------------
		School.Course.display();
		//----------------------------------------------
		school.organizeSeminar();
		//----------------------------------------------
		school.schoolAnniversary();
		school.schoolSport();
	}

}




