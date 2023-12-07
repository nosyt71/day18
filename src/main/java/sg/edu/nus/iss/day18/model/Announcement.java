package sg.edu.nus.iss.day18.model;

import java.util.Date;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class Announcement {
    
    //required
    //only digits
    @NotBlank(message = "Required field")
    @Pattern(regexp = "[0-9]", message = "ID must contain only numbers 0-9")
    private Integer annId;

    // only contains letters [a-zA-Z]
    @Pattern(regexp = "[a-zA-Z]")
    private String code;

    // required
    // min 10 characters, max 50 characters
    @NotBlank(message = "Required field")
    @Min(value = 10, message = "At least 10 characters required")
    @Max(value = 50, message = "At most 50 characters required")
    private String title;

    // required
    @NotBlank(message = "Required field")
    private String message;

    // date greater than today
    @Future(message = "Past date not accepted")
    private Date startDate;

    
}
