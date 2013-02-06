package th.co.samsung.scloud;

import th.co.samsung.scloud.Documents.OnDocumentsChangeListener;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends Activity implements OnDocumentsChangeListener {

	private static final int MENU_SETTING_ITEM = 1005;
	private static final int MENU_HELP_ITEM = 1004;
	private static final int MENU_REFRESH_ITEM = 1003;
	private static final int MENU_NEW_FOLDER_ITEM = 1002;
	private static final int MENU_UPLOAD_ITEM = 1001;
	private Documents mDocuments;
	private Document mDocument;
	private ListView mListView;
	private DocumentListAdapter mDocumentAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mDocuments = new Documents();

		// bootstrap
		mDocument = new Document("Title1", "Modify1");
		mDocuments.insert(mDocument);
		mDocument = new Document("Title2", "Modify2");
		mDocuments.insert(mDocument);

		mListView = (ListView) findViewById(R.id.listView);
		mDocumentAdapter = new DocumentListAdapter(this) {

			@Override
			public Object getItem(int position) {
				return mDocuments.get(position);
			}

			@Override
			public int getCount() {
				return mDocuments.size();
			}
		};
		mListView.setAdapter(mDocumentAdapter);
		mDocuments.setOnDocumentsChangeListener(this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(Menu.NONE, MENU_UPLOAD_ITEM, Menu.NONE,
				getString(R.string.upload));
		menu.add(Menu.NONE, MENU_NEW_FOLDER_ITEM, Menu.NONE,
				getString(R.string.new_folder));
		menu.add(Menu.NONE, MENU_REFRESH_ITEM, Menu.NONE,
				getString(R.string.refresh));
		menu.add(Menu.NONE, MENU_HELP_ITEM, Menu.NONE, getString(R.string.help));
		menu.add(Menu.NONE, MENU_SETTING_ITEM, Menu.NONE,
				getString(R.string.setting));

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case MENU_UPLOAD_ITEM:
			break;
		case MENU_NEW_FOLDER_ITEM:
			break;
		case MENU_REFRESH_ITEM:
			break;
		case MENU_HELP_ITEM:
			break;
		case MENU_SETTING_ITEM:
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onDucumentChange(Documents documents) {
		mDocumentAdapter.notifyDataSetChanged();
	}

}
