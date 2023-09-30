package day20.po;

public class Sales {
	private Integer id;
	private String date;
	private Integer productId;
	private Integer qty;
	private Integer branchId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	public Integer getBranchId() {
		return branchId;
	}
	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}
	
	@Override
	public String toString() {
		return "Sales [id=" + id + ", date=" + date + ", productId=" + productId + ", qty=" + qty + ", branchId="
				+ branchId + "]";
	}
	
	
	
	
}
