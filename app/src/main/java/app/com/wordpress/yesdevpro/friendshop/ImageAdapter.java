package app.com.wordpress.yesdevpro.friendshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;
import java.util.zip.Inflater;

/**
 * Created by mayacarmi.
 */
public class ImageAdapter extends BaseAdapter{
    private Context mContext;
    private final String[] storeName;

    public ImageAdapter(Context context, String[] storeName){
        this.mContext = context;
        this.storeName = storeName;
    }

    public View getView(int position, View convertView, ViewGroup parent){

        LayoutInflater inflater = (LayoutInflater)mContext.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if(convertView == null){
            gridView = new View(mContext);

            // get layout from content_stores.xml
            gridView = inflater.inflate(R.layout.content_stores,null);

            // set value into textview
            TextView textView = (TextView)gridView.findViewById(R.id.store_name);
            textView.setText(storeName[position]);

            // set image based on selected text
            ImageView imageView = (ImageView)gridView.findViewById(R.id.store_image);

            String store = storeName[position];

            if (store.equals("Asos")) {
                imageView.setImageResource(R.drawable);
            }

            else {
                gridView = (View)convertView;
            }

            return gridView;
        }
    }

    @Override
    public int getCount(){
        return storeName.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}
