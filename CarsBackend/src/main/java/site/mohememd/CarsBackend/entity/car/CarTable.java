package site.mohememd.CarsBackend.entity.car;

import org.jooq.Field;
import org.jooq.impl.DSL;

public class CarTable {
    public static final String TABLE = "car";
    public static final Field<Integer> CAR_ID = DSL.field("carID",Integer.class);
    public static final Field<String> REG = DSL.field("reg", String.class);
    public static final Field<String> VIN = DSL.field("vin", String.class);
    public static final Field<String> COLOR = DSL.field("color", String.class);
    public static final Field<Integer> TOTAL_DOORS = DSL.field("totalDoors", Integer.class);
    public static final Field<Integer> TOTAL_SEATS = DSL.field("totalSeats", Integer.class);
    public static final Field<Integer> AXLES_IN_USE = DSL.field("axlesInUse", Integer.class);
    public static final Field<Integer> TOTAL_ENGINES = DSL.field("totalEngines", Integer.class);
    public static final Field<Float> LENGTH = DSL.field("length", Float.class);
    public static final Field<Float> WIDTH = DSL.field("width", Float.class);
    public static final Field<String> REGISTERED_FIRST = DSL.field("registeredFirst", String.class);
    public static final Field<String> REGISTERED_NORWAY = DSL.field("registeredNorway", String.class);
    public static final Field<String> NEXT_EU_CONTROL = DSL.field("nextEUControl", String.class);
    public static final Field<String> NOTE = DSL.field("note", String.class);
    public static final Field<String> FOLLOW_UP = DSL.field("followUp", String.class);
    public static final Field<Integer> TRANSMISSION_ID = DSL.field("transmissionID", Integer.class);
    public static final Field<Integer> STATUS_ID = DSL.field("statusID", Integer.class);
    public static final Field<Integer> CAR_TYPE_ID = DSL.field("carTypeID", Integer.class);
    public static final Field<Integer> FUEL_ID = DSL.field("fuelID", Integer.class);
    public static final Field<Integer> HANDLE_STATUS_ID = DSL.field("handleStatusID", Integer.class);

}
