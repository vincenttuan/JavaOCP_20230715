package day02;

public class CBStock {
	//-- 原始資料 -------------------------------------
	public final String CB_TRAN_DATE;
	public final String CB_BROKER_ID;
	public final String CB_ACNO;
	public final String CB_COMPANY_NO;
	public final String CB_DEPT;
	public final String CB_UNSOLD_STOCK_NOS;
	public final String CB_UNSOLD_COST;
	public final String CB_NOCOST_STOCK_NOS;
	//-- 自訂資料 -------------------------------------
	public final String TOTAL_STOCK_NOS;
	
	public CBStock(String cB_TRAN_DATE, String cB_BROKER_ID, String cB_ACNO, String cB_COMPANY_NO, String cB_DEPT,
			String cB_UNSOLD_STOCK_NOS, String cB_UNSOLD_COST, String cB_NOCOST_STOCK_NOS) {
		CB_TRAN_DATE = cB_TRAN_DATE;
		CB_BROKER_ID = cB_BROKER_ID;
		CB_ACNO = cB_ACNO;
		CB_COMPANY_NO = cB_COMPANY_NO;
		CB_DEPT = cB_DEPT;
		CB_UNSOLD_STOCK_NOS = cB_UNSOLD_STOCK_NOS;
		CB_UNSOLD_COST = cB_UNSOLD_COST;
		CB_NOCOST_STOCK_NOS = cB_NOCOST_STOCK_NOS;
		// 計算總庫存 (CB_UNSOLD_STOCK_NOS + CB_NOCOST_STOCK_NOS)
		TOTAL_STOCK_NOS = String.valueOf(Integer.parseInt(CB_UNSOLD_STOCK_NOS) + Integer.parseInt(CB_NOCOST_STOCK_NOS));
	}

	@Override
	public String toString() {
		return "CBStock [CB_TRAN_DATE=" + CB_TRAN_DATE + ", CB_BROKER_ID=" + CB_BROKER_ID + ", CB_ACNO=" + CB_ACNO
				+ ", CB_COMPANY_NO=" + CB_COMPANY_NO + ", CB_DEPT=" + CB_DEPT + ", CB_UNSOLD_STOCK_NOS="
				+ CB_UNSOLD_STOCK_NOS + ", CB_UNSOLD_COST=" + CB_UNSOLD_COST + ", CB_NOCOST_STOCK_NOS="
				+ CB_NOCOST_STOCK_NOS + ", TOTAL_STOCK_NOS=" + TOTAL_STOCK_NOS + "]";
	}

	
}
