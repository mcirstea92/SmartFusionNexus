package ro.builditsmart.solutions.smartqhub.models.lighting;

import lombok.Getter;
import ro.builditsmart.solutions.smartqhub.models.exception.InvalidEnumValueRequested;

@Getter
public enum LightState {

    OFF(false), ON(true);

    private final boolean state;

    public static LightState from(boolean s) {
        for (LightState state : values()) {
            if (s == state.isState()) {
                return state;
            }
        }
        throw new InvalidEnumValueRequested(s, LightState.class);
    }

    LightState(boolean s){
        this.state = s;
    }
}
