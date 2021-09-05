package entity;

public class Pie {
	private int pieId;
	private String pieType;

	public Pie(int pieId, String pieType) {
		this.setPieId(pieId);
		this.setPieType(pieType);
	}

	public int getPieId() {
		return pieId;
	}

	public void setPieId(int pieId) {
		this.pieId = pieId;
	}

	public String getPieType() {
		return pieType;
	}

	public void setPieType(String pieType) {
		this.pieType = pieType;
	}
}
