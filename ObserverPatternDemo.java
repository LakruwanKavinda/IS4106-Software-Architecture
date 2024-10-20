import java.util.ArrayList;
import java.util.List;
class NewsAgency {
    private List<NewsChannel> channels = new ArrayList<>();
    private String news;
    public String getNews() {
        return news;}
    public void setNews(String news) {
        this.news = news;
        notifyAllChannels();
    }
    public void registerChannel(NewsChannel channel) {
        channels.add(channel);
    }
    public void notifyAllChannels() {
        for (NewsChannel channel : channels)
        {
            channel.update();
        }
    }
}
abstract class NewsChannel {
    protected NewsAgency newsAgency;
    public abstract void update();
}
class ChannelA extends NewsChannel {
    public ChannelA(NewsAgency newsAgency) {
        this.newsAgency = newsAgency;
        this.newsAgency.registerChannel(this);
    }
    @Override
    public void update() {
        System.out.println("Channel A received news: " + newsAgency.getNews());
    }
}
class ChannelB extends NewsChannel {
    public ChannelB(NewsAgency newsAgency) {
        this.newsAgency = newsAgency;
        this.newsAgency.registerChannel(this);
    }
    @Override
    public void update() {
        System.out.println("Channel B received news: " + newsAgency.getNews());
    }
}
public class ObserverPatternDemo {
    public static void main(String[] args) {
        NewsAgency newsAgency = new NewsAgency();
        new ChannelA(newsAgency);
        new ChannelB(newsAgency);
        System.out.println("First news update: Breaking news - Market hits new high!");
        newsAgency.setNews("Breaking news - Market hits new high!");
        System.out.println("Second news update: Breaking news - Market crashes!");
        newsAgency.setNews("Breaking news - Market crashes!");
    }
}
