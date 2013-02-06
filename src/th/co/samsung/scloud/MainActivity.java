package th.co.samsung.scloud;

import th.co.samsung.scloud.Documents.OnDocumentsChangeListener;
import android.os.Bundle;
import android.app.Activity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;

public class MainActivity extends Activity implements OnDocumentsChangeListener {

	private static final int MENU_MOVE_ITEM = 2004;
	private static final int MENU_RENAME_ITEM = 2003;
	private static final int MENU_DELETE_ITEM = 2002;
	private static final int MENU_SHARE_ITEM = 2001;
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
		registerForContextMenu(mListView);

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
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		menu.add(Menu.NONE, MENU_SHARE_ITEM, Menu.NONE,
				getString(R.string.share));
		menu.add(Menu.NONE, MENU_DELETE_ITEM, Menu.NONE,
				getString(R.string.delete));
		menu.add(Menu.NONE, MENU_RENAME_ITEM, Menu.NONE,
				getString(R.string.rename));
		menu.add(Menu.NONE, MENU_MOVE_ITEM, Menu.NONE, getString(R.string.move));

		super.onCreateContextMenu(menu, v, menuInfo);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		AdapterContextMenuInfo info = (AdapterContextMenuInfo) item
				.getMenuInfo();
		switch (item.getItemId()) {
		case MENU_SHARE_ITEM:
			break;
		case MENU_DELETE_ITEM:
			break;
		case MENU_RENAME_ITEM:
			break;
		case MENU_MOVE_ITEM:
			break;
		}
		return super.onContextItemSelected(item);
	}

	@Override
	public void onDucumentChange(Documents documents) {
		mDocumentAdapter.notifyDataSetChanged();
	}

	public void showMenu(View view) {
		this.openContextMenu(view);
	}

}
