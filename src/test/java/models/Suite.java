package models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@ToString
@Data
public class Suite {

    private int id;
    @SerializedName("code") private int projectCode;
    private String title;
    private String description;

}
