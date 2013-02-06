package th.co.samsung.scloud;

public class Document {
	private String titel;
	private String modified;

	public Document(String titel, String modified) {
		this.titel = titel;
		this.modified = modified;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getModified() {
		return modified;
	}

	public void setModified(String modified) {
		this.modified = modified;
	}

}
