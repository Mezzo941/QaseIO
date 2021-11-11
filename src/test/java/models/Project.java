package models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder()
public class Project {

    @SerializedName("title") private String projectCode;
    private String code;

}
