package yang.yang.elastic.demo.model;

/**
 * Created by yanyan on 2017/06/14.
 */
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "the-cars", type = "car")
public class Car {

    @Id
    private String id;
    private int price;
    private String color;
    private String make;
    private String sold;
    @Field(type = FieldType.String,index = FieldIndex.not_analyzed)
    private String brand;

    public Car(String id, int price, String color, String make, String sold, String brand) {
        this.id = id;
        this.price = price;
        this.color = color;
        this.make = make;
        this.sold = sold;
        this.brand = brand;
    }

    public Car() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getSold() {
        return sold;
    }

    public void setSold(String sold) {
        this.sold = sold;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
