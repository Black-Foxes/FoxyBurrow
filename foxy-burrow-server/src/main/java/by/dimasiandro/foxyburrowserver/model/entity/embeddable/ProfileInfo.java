package by.dimasiandro.foxyburrowserver.model.entity.embeddable;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Embeddable
public class ProfileInfo {

    @Size(min = 2, max = 40)
    private String firstName;

    @Size(min = 2, max = 40)
    private String lastName;

    @Size(max = 255)
    private String avatarPath;

    @Size(max = 255)
    private String status;

    private Date birthday;

    @Size(max = 40)
    private String city;

    @Size(max = 40)
    private String country;

    @Size(max = 40)
    private String placeOfStudy;

    @Size(max = 40)
    private String placeOLfWork;
}
