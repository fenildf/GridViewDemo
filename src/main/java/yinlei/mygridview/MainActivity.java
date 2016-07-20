package yinlei.mygridview;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import yinlei.mygridview.adapter.BookSelefAdapter;
import yinlei.mygridview.bean.BookSelefBean;
import yinlei.mygridview.utils.BookSelefUtils;
import yinlei.mygridview.widget.MyGridView;

public class MainActivity extends AppCompatActivity {

    private MyGridView gridView;
    private BookSelefAdapter adapter;
    private List<BookSelefBean> bookSelefBeen = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = (MyGridView) findViewById(R.id.gv_bookshelf);
        bookSelefBeen = BookSelefUtils.getBookSelefInfo();
        adapter = new BookSelefAdapter(this, bookSelefBeen);
        gridView.setAdapter(adapter);
        gridView.setSelector(new ColorDrawable(Color.TRANSPARENT));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                BookSelefBean bean = bookSelefBeen.get(i);
                if (bean.getUrl() == null || TextUtils.isEmpty(bean.getUrl())) {
                    Toast.makeText(MainActivity.this, "我是添加按钮", Toast.LENGTH_SHORT).show();
                    //如果想要通过这个，不对gridview进行逻辑判断，也就是比如我在添加一个书到书架上来说
                    //之前想到的一个解决办法是，想看下gridview是否可以进行逆序排列，但是找了些资料但是
                    //没有实现，然后想到的是用两个数组，一个数组用来是正序排列，另一个是逆序排列，这两个
                    //数组是一一对应的，只不过第二个数组是第一个数组的逆序，然后我们显示的时候是用的第二个数组的
                    //数据，不过这个需要进行逻辑判断，而且要严谨点，要不就会显示数据错乱

                    //第二种得到的资料就是，我在显示的数据最后一个位置添加一个空的数据，然后在adapter里面进行
                    //判断，如果是空的数据，那么就显示我们想要的添加的那个图片，然后我们在item的点击事件中
                    //进行判断，然后我们就可以进行我们的逻辑了，不过这个有个缺点，就是我们在更新数据的时候
                    //这个时候我们就需要在此重新获取数据，然后在此在最后的添加一个空的数据，其余逻辑是同上了
                    //缺点就是每次在此请求或者加载数据

                    //使用场景
                    //------》书架的书籍添加(后面有添加按钮)     图片选择(后面有添加按钮)

                  /*  BookSelefBean bean1 = new BookSelefBean(BookSelefUtils.url1,"我是带魔王");
                    bookSelefBeen.add(bean1);
                    adapter.notifyDataSetChanged();*/
                } else {
                    Toast.makeText(MainActivity.this, bean.getTitle(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
