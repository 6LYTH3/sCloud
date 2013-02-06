package th.co.samsung.scloud;

import th.co.samsung.scloud.Documents.OnDocumentsChangeListener;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;

public class MainActivity extends Activity implements OnDocumentsChangeListener {

	private Documents mDocuments;
	private Document mDocument;
	private ListView mListView;
	private DocumentListAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mDocuments = new Documents();

		// bootstrap
		mDocument = new Document("Title", "Modify");

		mDocuments.insert(mDocument);
		mListView = (ListView) findViewById(R.id.listView);
		mAdapter = new DocumentListAdapter(this) {

			@Override
			public Object getItem(int position) {
				return mDocuments.get(position);
			}

			@Override
			public int getCount() {
				return mDocuments.size();
			}
		};
		mListView.setAdapter(mAdapter);
		mDocuments.setOnDocumentsChangeListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public void onDucumentChange(Documents documents) {
		mAdapter.notifyDataSetChanged();
	}

}
