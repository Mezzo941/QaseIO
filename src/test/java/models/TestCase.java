package models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@Data
@ToString
public class TestCase {

    private int id;
    @SerializedName("code") private int projectCode;
    private String description;
    private String title;
    private int severity;
    private int priority;

}
