package adapters;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@Data
@ToString
public class QaseResponse<T> {

    boolean status;
    T result;

}
