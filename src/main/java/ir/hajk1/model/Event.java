package ir.hajk1.model;

/**
 * Created by k1 on 8/25/18.
 * email:<k1.tehrani@gmail.com>
 */
public enum Event {
    TRACK_100M(25.4347d,18d,1.81d,EventType.TRACK),
    FIELD_LONG_JUMP(0.14354d,	220d,	1.4d,EventType.FIELD),
    FIELD_SHOT_PUT(51.39d,	1.5d,	1.05d,EventType.FIELD),
    FIELD_HIGH_JUMP(0.8465d,	75d,	1.42d,EventType.FIELD),
    TRACK_400_M(0.8465d,	75d,	1.42d,EventType.TRACK),
    TRACK_110_M_HURDLES(5.74352d,	28.5d,	1.92d,EventType.TRACK),
    FIELD_DISCUS_THROW(12.91d,	4d,	1.1d,EventType.FIELD),
    FIELD_POLE_VAULT(0.2797d,	100d,	1.35d,EventType.FIELD),
    FIELD_JAVELIN_THROW(10.14d,	7d,	1.08d,EventType.FIELD),
    TRACK_1500_M(0.03768d,	480d,	1.85d,EventType.FIELD);


    private final double a;
    private final double b;
    private final double c;
    private final EventType eventType;

    Event(double a, double b, double c, EventType eventType) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.eventType = eventType;
    }

}
