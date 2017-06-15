package yang.yang.elastic.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Mapping;

import java.util.Date;

/**
 * Created by yanyan on 2017/06/15.
 */
@Document(indexName = "gb", type = "tweet")
public class TweetMessage {
    @Id
    private String id;
    @Field(type = FieldType.Date, index = FieldIndex.not_analyzed,
           format = DateFormat.custom, pattern = "yyyy-MM-dd")
    private Date date;
    private String name;
    private String tag;
    private String tweet;
    @JsonProperty("user_id")
    private int userId;

    public TweetMessage() {
    }

    public TweetMessage(String id, Date date, String name, String tag, String tweet, int userId) {
        this.id = id;
        this.date = date;
        this.name = name;
        this.tag = tag;
        this.tweet = tweet;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "TweetMessage{" +
                "id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", name='" + name + '\'' +
                ", tag='" + tag + '\'' +
                ", tweet='" + tweet + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
