package ir.hajk1.model;

import static ir.hajk1.model.EventType.FIELD;
import static ir.hajk1.model.EventType.TRACK;
import static ir.hajk1.model.Unit.CENTIMETER;
import static ir.hajk1.model.Unit.METER;
import static ir.hajk1.model.Unit.SECONDS;

/**
 * Author: <a href="mailto:k1.tehrani@gmail.com">Kayvan Tehrani</a>
 *
 * Description: <This enum is used for holding Decathlon events scoring table>
 */
public enum Event {
    TRACK_100M(25.4347d, 18d, 1.81d, TRACK, SECONDS),
    FIELD_LONG_JUMP(0.14354d, 220d, 1.4d, FIELD, CENTIMETER),
    FIELD_SHOT_PUT(51.39d, 1.5d, 1.05d, FIELD, METER),
    FIELD_HIGH_JUMP(0.8465d, 75d, 1.42d, FIELD, CENTIMETER),
    TRACK_400_M(1.53775d, 82d, 1.81d, TRACK, SECONDS),
    TRACK_110_M_HURDLES(5.74352d, 28.5d, 1.92d, TRACK, SECONDS),
    FIELD_DISCUS_THROW(12.91d, 4d, 1.1d, FIELD, METER),
    FIELD_POLE_VAULT(0.2797d, 100d, 1.35d, FIELD, CENTIMETER),
    FIELD_JAVELIN_THROW(10.14d, 7d, 1.08d, FIELD, METER),
    TRACK_1500_M(0.03768d, 480d, 1.85d, TRACK, SECONDS);


    private final double a;
    private final double b;
    private final double c;
    private final EventType eventType;
    private final Unit unit;

    Event(double a, double b, double c, EventType eventType, Unit unit) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.eventType = eventType;
        this.unit = unit;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public EventType getEventType() {
        return eventType;
    }

    public Unit getUnit() {
        return unit;
    }

    public int calculatePoint(Double p) {
        if (FIELD.equals(eventType)) {
//            INT(A(P — B)C)
            return (int) (a * Math.pow((p - b), c));
        } else {
//            INT(A(B — P)C)
            return (int) (a * Math.pow((b - p), c));
        }

    }
}
