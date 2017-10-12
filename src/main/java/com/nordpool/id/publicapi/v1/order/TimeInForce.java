
package com.nordpool.id.publicapi.v1.order;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TimeInForce {

    IOC("IOC"),
    FOK("FOK"),
    NON("NON"),
    GTD("GTD"),
    GFS("GFS");
    private final String value;
    private final static Map<String, TimeInForce> CONSTANTS = new HashMap<String, TimeInForce>();

    static {
        for (TimeInForce c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    private TimeInForce(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    @JsonValue
    public String value() {
        return this.value;
    }

    @JsonCreator
    public static TimeInForce fromValue(String value) {
        TimeInForce constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
