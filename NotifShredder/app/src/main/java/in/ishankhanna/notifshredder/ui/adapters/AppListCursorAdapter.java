package in.ishankhanna.notifshredder.ui.adapters;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import in.ishankhanna.notifshredder.R;

/**
 * Created by ishan on 11/02/16.
 */
public class AppListCursorAdapter extends CursorAdapter {


    public AppListCursorAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {

        View mItem = LayoutInflater.from(context).inflate(R.layout.snippet_list_row, parent, false);
        ViewHolder mHolder = new ViewHolder(mItem);
        mItem.setTag(mHolder);

        return mItem;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        View v = view;
        if (null == v) {
            LayoutInflater layoutInflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = layoutInflater.inflate(R.layout.snippet_list_row, null);
        }
        final ViewHolder mHolder = (ViewHolder) view.getTag();
        mHolder.appName.setText(cursor.getString(1));
        mHolder.packageName.setText(cursor.getString(2));
    }

    static class ViewHolder
    {
        public TextView appName;
        public TextView packageName;
        public ViewHolder(View view)
        {
            appName = (TextView) view.findViewById(R.id.app_name);
            packageName = (TextView) view.findViewById(R.id.app_package);
        }
    }

}
