package th.co.samsung.scloud;

import java.util.ArrayList;

public class Documents {
	private ArrayList<Document> documents = new ArrayList<Document>();

	public interface OnDocumentsChangeListener {
		void onDucumentChange(Documents documents);
	}

	private OnDocumentsChangeListener onDocumentsChangeListener;

	public void setOnDocumentsChangeListener(
			OnDocumentsChangeListener onDocumentsChangeListener) {
		this.onDocumentsChangeListener = onDocumentsChangeListener;
	}

	public void insert(Document document) {
		this.documents.add(document);
		notifyDocumentsChange();
	}

	public void clear() {
		this.documents.clear();
		notifyDocumentsChange();
	}

	public int size() {
		return this.documents.size();
	}

	public Document get(int position) {
		return this.documents.get(position);
	}

	private void notifyDocumentsChange() {
		if (this.onDocumentsChangeListener != null) {
			this.onDocumentsChangeListener.onDucumentChange(this);

		}
	}
}
