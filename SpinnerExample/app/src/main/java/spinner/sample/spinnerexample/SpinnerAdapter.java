package spinner.sample.spinnerexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by praveen on 17/8/16.
 */

public class SpinnerAdapter extends BaseAdapter {

    ArrayList<Item> categories = new ArrayList<>();
    Context mContext;

    public SpinnerAdapter(ArrayList<Item> categories, Context context){
        this.categories = categories;
        mContext = context;
    }

    public void updateDate(ArrayList<Item> items){
        categories = items;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return categories.size();
    }

    @Override
    public Object getItem(int i) {
        return categories.get(i);
    }

    @Override
    public long getItemId(int i) {
        return categories.get(i).hashCode();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Item item = categories.get(i);
        ViewHolder holder = null;
        if(view == null){
            view = LayoutInflater.from(mContext).inflate(R.layout.spinner_item, null);
            holder = new ViewHolder();
            holder.name = (TextView) view.findViewById(R.id.txt_view_spinner_item);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.name.setText(item.getName());
        return view;
    }

    static class ViewHolder{
        TextView name;
    }

}
