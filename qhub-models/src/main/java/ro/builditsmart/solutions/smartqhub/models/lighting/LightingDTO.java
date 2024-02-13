package ro.builditsmart.solutions.smartqhub.models.lighting;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LightingDTO {

    private String name;

    private Short raspberryPin;

    private Short bcmPin;

    private Short wiringPiPin;

    private Short ranking;

    private String wireHexColor;

    private String description;

    private LightState state;

    private List<String> aliases;

    private Long lastUpdated;

    private String lastUpdatedBy;

    public void setState(boolean b) {
        this.state = LightState.from(b);
    }

}
