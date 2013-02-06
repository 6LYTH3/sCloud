package th.co.samsung.scloud;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

abstract public class DocumentListAdapter extends BaseAdapter implements
		ListAdapter {

	private static final class ViewHolder {
		ImageView imgView;
		TextView txtTitle;
		TextView txtModified;
	}

	private Context mContext;

	public DocumentListAdapter(Context context) {
		mContext = context;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder;
		if (convertView == null) {
			viewHolder = new ViewHolder();
			convertView = LayoutInflater.from(mContext).inflate(
					R.layout.document_row, parent, false);
			viewHolder.imgView = (ImageView) convertView
					.findViewById(R.id.imgView);
			viewHolder.txtTitle = (TextView) convertView
					.findViewById(R.id.txtTitle);
			viewHolder.txtModified = (TextView) convertView
					.findViewById(R.id.txtModified);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}

		// update
		Document document = (Document) getItem(position);
		viewHolder.txtTitle.setText(String.valueOf(document.getTitel()));
		viewHolder.txtModified.setText(String.valueOf(document.getModified()));
		return convertView;
	}

}
