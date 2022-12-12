package fudan.pm.fudanCompass.dto.request;

import lombok.Data;

@Data
public class RegisterRequest {

    private String username;
    private String password;
    private String major;

}
