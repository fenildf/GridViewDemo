package yinlei.mygridview.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import yinlei.mygridview.bean.BookSelefBean;
import yinlei.mygridview.R;

/**
 * Created by Administrator on 2016/7/20.
 */
public class BookSelefAdapter extends MyBaseAdapter<BookSelefBean> {

    private boolean isShowDelete = false;

    public List<ImageView> isSelected;
    public Map<Integer, ImageView> map = new HashMap<Integer, ImageView>();

    private ViewHolder viewHolder;

    BookSelefBean bean;

    private Context mContext;


    public BookSelefAdapter(Context context, List<BookSelefBean> list) {
        super(context, list);
        isSelected = new ArrayList<>();
        mContext = context;
    }

    public void setIsShowDelete(boolean isShowDelete) {
        this.isShowDelete = isShowDelete;
        notifyDataSetChanged();
    }

    @Override
    public View getItemView(int position, View convertView, ViewGroup parent) {
        viewHolder = new ViewHolder();
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_view_item, parent, false);
            viewHolder.tv_bookshelf_item_title = (TextView) convertView.findViewById(R.id.tv_bookshelf_item_title);
            viewHolder.img_bookitem_delete = (ImageView) convertView.findViewById(R.id.img_bookitem_delete);
            viewHolder.img_bookshelf_item = (ImageView) convertView.findViewById(R.id.img_bookshelf_item);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        bean = dataSet.get(position);
        String url = bean.getUrl();
        if (url != null || !TextUtils.isEmpty(url)) {
            Glide.with(mContext).load(url).into(viewHolder.img_bookshelf_item);
            url = null;
        } else {
            viewHolder.img_bookshelf_item.setImageResource(R.mipmap.img_backgroud_book_shelf_add);
            viewHolder.img_bookshelf_item.setBackgroundColor(mContext.getResources().getColor(R.color.gray));

        }
        viewHolder.tv_bookshelf_item_title.setText(bean.getTitle());

        return convertView;
    }

    class ViewHolder {
        TextView tv_bookshelf_item_title;
        ImageView img_bookshelf_item, img_bookitem_delete;

    }
}
