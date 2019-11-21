package id.kardihaekal.viewpagerslider.viewholder;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;
import id.kardihaekal.viewpagerslider.R;
import id.kardihaekal.viewpagerslider.model.ItemObj;
import java.util.ArrayList;
import jp.wasabeef.picasso.transformations.BlurTransformation;

public class ItemView {
    private Context context;
    private int position;
    private ArrayList<ItemObj> arrayList;
    private ImageView backgrounImage;
    private ImageView foregroundImage;
    private TextView item_title;
    private RelativeLayout item_parent;
    private FloatingActionButton arrow;
    private ItemArrowInterface itemArrowInterface;

    public ItemView(Context context, View view, int position, ArrayList<ItemObj> arrayList, ItemArrowInterface itemArrowInterface) {
        this.context = context;
        this.position = position;
        this.arrayList = arrayList;
        this.itemArrowInterface = itemArrowInterface;
        setType(view);
        apply();
    }

    private void apply() {
        arrowShow();
        loadBackgroundImage();
        loadForegroundImage();
        loadTitle();
        itemOnClick();
        changeArrowColor();
        arrowOnClick();
    }

    private void setType(View view) {
        backgrounImage = view.findViewById(R.id.backgrounImage);
        foregroundImage = view.findViewById(R.id.foregroundImage);
        item_title = view.findViewById(R.id.item_title);
        item_parent = view.findViewById(R.id.item_parent);
        arrow = view.findViewById(R.id.arrow);
    }

    private void arrowShow() {
        if (position != arrayList.size() - 1) {
            arrow.show();
        } else {
            arrow.hide();
        }
    }

    private void changeArrowColor() {
        arrow.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(arrayList.get(position).getAccentColor())));
    }

    private void itemOnClick() {
        item_parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Click: " + position, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void loadTitle() {
        item_title.setText(arrayList.get(position).getTitle());
    }

    private void loadForegroundImage() {
        Picasso.get()
                .load(arrayList.get(position).getImageURL())
                .fit().centerCrop().into(foregroundImage);
    }

    private void loadBackgroundImage() {
        Picasso.get()
                .load(arrayList.get(position).getImageURL())
                .transform(new BlurTransformation(context, 30, 1))
                .fit().centerCrop().into(backgrounImage);
    }

    private void arrowOnClick(){
        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemArrowInterface.scrollNextPosition(position+1);
            }
        });
    }

    public interface ItemArrowInterface{
        void scrollNextPosition(int position);
    }
}
