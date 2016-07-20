package yinlei.mygridview.bean;

/**
 * Created by Administrator on 2016/7/20.
 */
public class BookSelefBean {

    private String url,title;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BookSelefBean() {
    }

    public BookSelefBean(String url, String title) {
        this.url = url;
        this.title = title;
    }
}
