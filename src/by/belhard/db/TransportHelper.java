package by.belhard.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class TransportHelper extends SQLiteOpenHelper implements BaseColumns{

	// Constants for table BUS
	public static final String BUS_TABLE = "bus";
    public static final String NUMBER_OF_BUS = "number_bus";
    public static final String NAME_ROUTE = "name_route";
    public static final String TYPE_TRANSPORT_ID = "type_transport_id";
    
    // Constanst for table Type Transport
    public static final String TYPE_TRANSPORT = "type_transport";
    public static final String TYPE = "type";
    
    // Constanst for table Station
    public static final String STATION_TABLE = "station";
    public static final String NAME_OF_STATION = "name_of_station";
    
    // Contants for table Time
    public static final String TIME_TABLE = "time";
    public static final String TIME_DEPARTURE = "time_departure";
    public static final String DAY_OF_WEEK = "day_of_week_id";
    public static final String ROUTE_ID = "route_id";
    
    // Constanst for table Route
    public static final String ROUTE_TABLE = "route";
    public static final String ROUTE_NAME = "name";
    
    // Constanst for table Timetable
    public static final String BUS_ID = "bus_id";
    public static final String STATION_ID = "station_id";
    public static final String TIME_ID = "time_id";
    		
	public TransportHelper(Context context) {
		super(context, TransportContactProvider.DB_TRANSPORT, null, 1);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		// setting data for table with name Bus
		db.execSQL("CREATE TABLE "+BUS_TABLE+
				" (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+ NUMBER_OF_BUS+" VARCHAR(5) NOT NULL,"+
				NAME_ROUTE+" TEXT NOT NULL,"+TYPE_TRANSPORT_ID+" INTEGER NOT NULL);");
		
		ContentValues busValues = new ContentValues();
		
		busValues.put(NUMBER_OF_BUS, "16");
		busValues.put(NAME_ROUTE, "Чижовка-Ангарская");
		busValues.put(TYPE_TRANSPORT_ID, "1");
		db.insert(BUS_TABLE, NUMBER_OF_BUS, busValues);
		
		busValues.put(NUMBER_OF_BUS, "102");
		busValues.put(NAME_ROUTE, "Чижовка-Вокзал");
		busValues.put(TYPE_TRANSPORT_ID, "1");
		db.insert(BUS_TABLE, NUMBER_OF_BUS, busValues);
		
		busValues.put(NUMBER_OF_BUS, "16");
		busValues.put(NAME_ROUTE, "Чижовка1-Вокзал");
		busValues.put(TYPE_TRANSPORT_ID, "2");
		db.insert(BUS_TABLE, NUMBER_OF_BUS, busValues);
		
		// setting data for table with name Type Transport
		db.execSQL("CREATE TABLE "+TYPE_TRANSPORT+" (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " + 
					TYPE+" TEXT NOT NULL);");
		
		ContentValues typesValues = new ContentValues();
		
		typesValues.put(TYPE, "Автобус");
		db.insert(TYPE_TRANSPORT, TYPE, typesValues);
		
		typesValues.put(TYPE, "Троллейбус");
		db.insert(TYPE_TRANSPORT, TYPE, typesValues);
		
		typesValues.put(TYPE, "Трамвай");
		db.insert(TYPE_TRANSPORT, TYPE, typesValues);
		
		// setting data for table with name Station
		db.execSQL("CREATE TABLE "+STATION_TABLE+" (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " + 
					NAME_OF_STATION + " TEXT NOT NULL);");
		
		ContentValues stationsValues = new ContentValues();
		
		stationsValues.put(NAME_OF_STATION, "Лошица");
		db.insert(STATION_TABLE, NAME_OF_STATION, stationsValues);
		
		stationsValues.put(NAME_OF_STATION, "Кирова");
		db.insert(STATION_TABLE, NAME_OF_STATION, stationsValues);
		
		stationsValues.put(NAME_OF_STATION, "Голодеда");
		db.insert(STATION_TABLE, NAME_OF_STATION, stationsValues);
		
		stationsValues.put(NAME_OF_STATION, "10-я больница");
		db.insert(STATION_TABLE, NAME_OF_STATION, stationsValues);
		
		stationsValues.put(NAME_OF_STATION, "Вокзал");
		db.insert(STATION_TABLE, NAME_OF_STATION, stationsValues);
		
		stationsValues.put(NAME_OF_STATION, "Чижовка");
		db.insert(STATION_TABLE, NAME_OF_STATION, stationsValues);
		
		// setting data for table with name Time
		db.execSQL("CREATE TABLE "+TIME_TABLE+" (_id INTEGER PRIMARY KEY  AUTOINCREMENT NOT NULL, "+
					TIME_DEPARTURE+" VARCHAR(5) NOT NULL, "+DAY_OF_WEEK+" BOOLEAN NOT NULL, "
					+ROUTE_ID+" INTEGER NOT NULL);");
		
		ContentValues timeValues = new ContentValues();
		
		timeValues.put(TIME_DEPARTURE, "19.04");
		timeValues.put(DAY_OF_WEEK, "true");
		timeValues.put(ROUTE_ID, "1");
		db.insert(TIME_TABLE, TIME_DEPARTURE, timeValues);
		
		timeValues.put(TIME_DEPARTURE, "19.07");
		timeValues.put(DAY_OF_WEEK, "true");
		timeValues.put(ROUTE_ID, "1");
		db.insert(TIME_TABLE, TIME_DEPARTURE, timeValues);
		
		timeValues.put(TIME_DEPARTURE, "10.24");
		timeValues.put(DAY_OF_WEEK, "true");
		timeValues.put(ROUTE_ID, "2");
		db.insert(TIME_TABLE, TIME_DEPARTURE, timeValues);
		
		timeValues.put(TIME_DEPARTURE, "13.47");
		timeValues.put(DAY_OF_WEEK, "true");
		timeValues.put(ROUTE_ID, "2");
		db.insert(TIME_TABLE, TIME_DEPARTURE, timeValues);
		
		timeValues.put(TIME_DEPARTURE, "19.01");
		timeValues.put(DAY_OF_WEEK, "true");
		timeValues.put(ROUTE_ID, "2");
		db.insert(TIME_TABLE, TIME_DEPARTURE, timeValues);
		
		// setting data for table with name Route
		db.execSQL("CREATE TABLE "+ROUTE_TABLE+" (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " + 
					ROUTE_NAME+" TEXT NOT NULL);");
		
		ContentValues routeValues = new ContentValues();
		
		routeValues.put(ROUTE_NAME, "прямо");
		db.insert(ROUTE_TABLE, ROUTE_NAME, routeValues);
		
		routeValues.put(ROUTE_NAME, "обратно");
		db.insert(ROUTE_TABLE, ROUTE_NAME, routeValues);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF NOT EXISTS " + BUS_TABLE);
		onCreate(db);
	}

}
