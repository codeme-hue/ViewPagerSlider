package id.kardihaekal.viewpagerslider;

import android.graphics.Color;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;
import id.kardihaekal.viewpagerslider.adapter.ViewPagerAdapter;
import id.kardihaekal.viewpagerslider.model.ItemObj;
import id.kardihaekal.viewpagerslider.transformer.SwipeTransform;
import id.kardihaekal.viewpagerslider.viewholder.ItemView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemView.ItemArrowInterface {
  private ViewPager viewPager;
  private ViewPagerAdapter adapter;
  private ArrayList<ItemObj> arrayList;
  private RelativeLayout parent;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    viewPager = findViewById(R.id.viewPager);
    parent = findViewById(R.id.parent);
    initData();
    changeBackground(arrayList.get(0).getAccentColor());

    adapter = new ViewPagerAdapter(this, arrayList, MainActivity.this);
    viewPager.setPageTransformer(true, new SwipeTransform());
    viewPager.setAdapter(adapter);
    viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
      @Override
      public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
      }

      @Override
      public void onPageSelected(int position) {
        changeBackground(arrayList.get(position).getAccentColor());
      }

      @Override
      public void onPageScrollStateChanged(int state) {

      }
    });
  }

  private void initData() {
    arrayList = new ArrayList<>();

    arrayList.add(new ItemObj("https://u01.appmifile.com/images/2018/07/23/361da602-8ef6-4c45-afe5-081dfb5f48b7.png", "#4D0AF5", "Panorama"));
    arrayList.add(new ItemObj("https://u01.appmifile.com/images/2018/07/23/54ef7693-ef8f-4783-bb72-f1b8335f47b3.png", "#A1379D", "Abstract"));
    arrayList.add(new ItemObj("https://u01.appmifile.com/images/2018/07/23/9442191e-31c6-4206-82cb-a6be159dad69.png", "#0ABF53", "Beautiful like you"));
    arrayList.add(new ItemObj("https://u01.appmifile.com/images/2018/07/23/8da13ba4-0b18-46e8-8b5f-9f6e9e42c4b7.png", "#FFD000", "Come back"));
  }

  private void changeBackground(String color) {
    parent.setBackgroundColor(Color.parseColor(color));
    changeStatusBarColor(color);
  }

  private void changeStatusBarColor(String color) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      Window window = getWindow();
      window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
      window.setStatusBarColor(Color.parseColor(color));
    }
  }

  @Override
  public void scrollNextPosition(int position) {
    viewPager.setCurrentItem(position, true);
  }
}
