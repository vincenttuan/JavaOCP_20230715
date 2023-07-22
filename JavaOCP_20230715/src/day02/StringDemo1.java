package day02;

public class StringDemo1 {

	public static void main(String[] args) {
		String data = "1120505880006667920050  000000102500000000000000000000001025000";
		final String CB_ACNO = data.substring(0, 0+7);
		final String CB_BROKER_ID = data.substring(7, 7+4);
		System.out.println(CB_ACNO);
		System.out.println(CB_BROKER_ID);
		

	}

}
