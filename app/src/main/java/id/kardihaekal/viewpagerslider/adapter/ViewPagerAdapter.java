package id.kardihaekal.viewpagerslider.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import id.kardihaekal.viewpagerslider.R;
import id.kardihaekal.viewpagerslider.model.ItemObj;
import id.kardihaekal.viewpagerslider.viewholder.ItemView;
import java.util.ArrayList;

public class ViewPagerAdapter extends PagerAdapter {

    private ArrayList<ItemObj> arrayList;
    private Context context;
    private ItemView.ItemArrowInterface itemArrowInterface;

    public ViewPagerAdapter(Context context, ArrayList<ItemObj> arrayList, ItemView.ItemArrowInterface itemArrowInterface) {
        this.arrayList = arrayList;
        this.context = context;
        this.itemArrowInterface = itemArrowInterface;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.view_pager_item, container, false);
        container.addView(view);

        Log.d("Dlog", "" + position);

        new ItemView(context, view, position, arrayList, itemArrowInterface);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
