package day02;

public class StringDemo1 {

	public static void main(String[] args) {
		String data = "1120505880006667920050  000000102500000000000000000000001025000";
		System.out.println(data.length());
		final String CB_TRAN_DATE        = data.substring(0, 0+7);
		final String CB_BROKER_ID        = data.substring(7, 7+4);
		final String CB_ACNO             = data.substring(11, 11+7);
		final String CB_COMPANY_NO       = data.substring(18, 18+6);
		final String CB_DEPT             = data.substring(24, 24+1);
		final String CB_UNSOLD_STOCK_NOS = data.substring(25, 25+12);
		final String CB_UNSOLD_COST      = data.substring(37, 37+14);
		final String CB_NOCOST_STOCK_NOS = data.substring(51, 51+12);
		
		System.out.println(CB_TRAN_DATE);
		System.out.println(CB_BROKER_ID);
		System.out.println(CB_ACNO);
		System.out.println(CB_COMPANY_NO);
		System.out.println(CB_DEPT);
		System.out.println(CB_UNSOLD_STOCK_NOS); 
		System.out.println(CB_UNSOLD_COST);
		System.out.println(CB_NOCOST_STOCK_NOS);
		
		final String TOTAL_STOCK_NOS = String.valueOf(Integer.parseInt(CB_UNSOLD_STOCK_NOS) + Integer.parseInt(CB_NOCOST_STOCK_NOS));
		
		System.out.println(TOTAL_STOCK_NOS); // 如何等於 2050000
	}

}
