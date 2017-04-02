package com.inventory.cit.inventorymanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Gunaseelan on 30-08-2016.
 */
public class BaseClass {

    // Declaring the Database name and Table names
    private static final String DATABASE_NAME = "inventory_database";
    private static final String INVENTORY_MAIN = "inventory_main";
    private static final String INVENTORY_PRODUCT = "inventory_product";
    private static final String INVENTORY_SUPPLIER ="inventory_supplier";
    private static final int DATABASE_VERSION = 1;

    // Declaring the field names for inventory_main
   // public static final String PRODUCT_ID = "product_id";
   // public static final String PRODUCT_NAME = "product_name";
    public static final String PRODUCT_QUANTITY = "product_quantity";
  //  public static final String SUPPLIER_ID = "supplier_id";
    public static final String BATCH_NO = "batch_no";
    public static final String BATCH_DATE = "batch_date";
    public static final String REORDER_LEVEL = "reorder_level";


    // Declaring the field names for inventory_product

    public static final String PRODUCT_ID = "product_id";
    public static final String PRODUCT_NAME = "product_name";
    public static final String PRODUCT_SERIAL ="product_serial";
    public static final String PRODUCT_COLOUR ="product_colour";
    public static final String PRODUCT_TYPE="product_type";
    public static final String PRODUCT_ACTIVE="product_active";
    public static final String PRODUCT_CATEGORY1="product_category1";


    // Declaring the field names for inventory_supplier

    public static final String SUPPLIER_ID = "supplier_id";
    public static final String SUPPLIER_NAME = "supplier_name";
    public static final String SUPPLIER_PHONE = "supplier_phone";
    public static final String SUPPLIER_EMAIL = "supplier_email";
    public static final String SUPPLIER_CITY = "supplier_city";
    public static final String SUPPLIER_PIN = "supplier_pin";
    public static final String SUPPLIER_STATUS = "supplier_status";




    private SQLiteDatabase InvDB;
    private dbhelper getdbhelper;
    private Context cont;

    public BaseClass(Context c) {

         cont = c;




    }


    public BaseClass open() throws SQLiteException

    {

        getdbhelper = new dbhelper(cont);
        InvDB = getdbhelper.getWritableDatabase();
        return this;

    }





    public void close()

    {

        InvDB.close();


    }
        private class dbhelper extends SQLiteOpenHelper {

            public dbhelper(Context c) {
                super(c, DATABASE_NAME, null, DATABASE_VERSION);


            }


            @Override
            public void onCreate(SQLiteDatabase InvDB) {


                String query1 = "CREATE TABLE " +
                        INVENTORY_MAIN
                        + "("
                        + PRODUCT_ID + " TEXT,"
                        + PRODUCT_NAME + " TEXT,"
                        + PRODUCT_QUANTITY + " TEXT,"
                        + SUPPLIER_ID + " TEXT,"
                        + BATCH_NO + " TEXT,"
                        + BATCH_DATE + " TEXT,"
                        + REORDER_LEVEL + " TEXT"

                        + ")";


                InvDB.execSQL(query1);

                String query2 = "CREATE TABLE " +
                        INVENTORY_PRODUCT
                        + "("
                        + PRODUCT_ID + " INTEGER PRIMARY KEY,"
                        + PRODUCT_NAME + " TEXT,"
                        + PRODUCT_COLOUR + " TEXT,"
                        + PRODUCT_TYPE + " TEXT,"
                        + PRODUCT_ACTIVE + " TEXT,"
                        + PRODUCT_CATEGORY1 + " TEXT"

                        + ")";

                InvDB.execSQL(query2);



                String query3 = "CREATE TABLE " +
                        INVENTORY_SUPPLIER
                        + "("
                        + SUPPLIER_ID + " INTEGER PRIMARY KEY,"
                        + SUPPLIER_NAME + " TEXT,"
                        + SUPPLIER_PHONE + " TEXT,"
                        + SUPPLIER_EMAIL + " TEXT,"
                        + SUPPLIER_CITY + " TEXT,"
                        + SUPPLIER_PIN + " TEXT,"
                        + SUPPLIER_STATUS + " TEXT"

                        + ")";

                InvDB.execSQL(query3);

            }
            @Override
            public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                onUpgrade(InvDB, oldVersion, newVersion);
                String Dbqueryonupgrade1 = "DROP TABLE " + INVENTORY_MAIN + " IF EXISTS";
                String Dbqueryonupgrade2 = "DROP TABLE " + INVENTORY_PRODUCT + " IF EXISTS";
                String Dbqueryonupgrade3 = "DROP TABLE " + INVENTORY_SUPPLIER + " IF EXISTS";

                InvDB.execSQL(Dbqueryonupgrade1);
                InvDB.execSQL(Dbqueryonupgrade2);
                InvDB.execSQL(Dbqueryonupgrade3);

            }
        }




public Long insertrows_db(String table_name,ContentValues cvproduct)

{
   return  InvDB.insert( table_name,null,cvproduct);
}


public Cursor getvaluesfromdb(String table_name,String ColumnValue,String selectargs[]) {

    String sql = "SELECT ";
    String selectionArgs[] = selectargs;
    Cursor cs = InvDB.rawQuery(sql,selectionArgs);

    return cs;



}



}