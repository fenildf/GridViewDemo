package yinlei.mygridview.utils;

import java.util.ArrayList;
import java.util.List;

import yinlei.mygridview.bean.BookSelefBean;

/**
 * Created by Administrator on 2016/7/20.
 */
public class BookSelefUtils {

    public static String url1 = "http://img0.imgtn.bdimg.com/it/u=3108557082,3790655332&fm=21&gp=0.jpg";
    private static String url2 = "http://img1.imgtn.bdimg.com/it/u=776020513,471144390&fm=21&gp=0.jpg";
    private static String url3 = "http://img0.imgtn.bdimg.com/it/u=2598250179,794609049&fm=21&gp=0.jpg";
    private static String url4 = "http://img5.imgtn.bdimg.com/it/u=2778730139,2491244884&fm=21&gp=0.jpg";

    public static List<BookSelefBean> getBookSelefInfo() {
        List<BookSelefBean> bookSelefBeen = new ArrayList<>();
        BookSelefBean bean1 = new BookSelefBean(url1, "乱世胸模");
        BookSelefBean bean2 = new BookSelefBean(url2, "明教教主");
        BookSelefBean bean3 = new BookSelefBean(url3, "优化升级");
        BookSelefBean bean4 = new BookSelefBean(url4, "你还敢来");
        bookSelefBeen.add(bean1);
        bookSelefBeen.add(bean2);
        bookSelefBeen.add(bean3);
        bookSelefBeen.add(bean4);
        BookSelefBean bean5 = new BookSelefBean();
        bookSelefBeen.add(bean5);
        return bookSelefBeen;
    }
}
