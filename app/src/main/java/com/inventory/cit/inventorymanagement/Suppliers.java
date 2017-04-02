package com.inventory.cit.inventorymanagement;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class Suppliers extends AppCompatActivity implements View.OnClickListener {

    EditText supplier_id;
    EditText supplier_name;
    EditText supplier_phone;
    EditText supplier_email;
    EditText supplier_city;
    EditText supplier_pin;
    EditText supplier_status;

    String str_supplier_id = "";
    String str_supplier_name = "";
    String str_supplier_phone = "";
    String str_supplier_email = "";
    String str_supplier_city = "";
    String str_supplier_pin = "";
    String str_supplier_status = "";

    Button btsuppliersave;
    ContentValues cv_supplier;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suppliers);


        supplier_id = (EditText) findViewById(R.id.etsupplierid);
        supplier_name = (EditText) findViewById(R.id.etsuppliername);
        supplier_phone = (EditText) findViewById(R.id.etsupplierphone);
        supplier_email = (EditText) findViewById(R.id.etsupplieremail);
        supplier_city = (EditText) findViewById(R.id.etsuppliercity);
        supplier_pin = (EditText) findViewById(R.id.etsupplierpincode);
        supplier_status = (EditText) findViewById(R.id.etsupplierstatus);

        btsuppliersave = (Button) findViewById(R.id.btsuppliersave);

        btsuppliersave.setOnClickListener(this);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    @Override
    public void onClick(View v) {

        getdata();

        insertsupplier();


    }

    public void getdata() {


        str_supplier_id = supplier_id.getText().toString();
        str_supplier_name = supplier_name.getText().toString();
        str_supplier_phone = supplier_phone.getText().toString();
        str_supplier_email = supplier_email.getText().toString();
        str_supplier_city = supplier_city.getText().toString();
        str_supplier_pin = supplier_pin.getText().toString();
        str_supplier_status = supplier_status.getText().toString();


        cv_supplier = new ContentValues();
        cv_supplier.put("SUPPLIER_ID", Integer.valueOf(str_supplier_id));
        cv_supplier.put("SUPPLIER_NAME", str_supplier_name);
        cv_supplier.put("SUPPLIER_PHONE", str_supplier_phone);
        cv_supplier.put("SUPPLIER_EMMAIL", str_supplier_email);
        cv_supplier.put("SUPPLIER_CITY", str_supplier_city);
        cv_supplier.put("SUPPLIER_PIN", str_supplier_pin);
        cv_supplier.put("SUPPLIER_STATUS", str_supplier_status);


    }

    public void insertsupplier() {
        getdata();

        String tablename = "INVENTORY_SUPPLIER";

        BaseClass bcsupplier = new BaseClass(this);
        try {

            bcsupplier.open();

            Long lng_insertsupplier = bcsupplier.insertrows_db(tablename, cv_supplier);


            Toast newtoast = Toast.makeText(this, "Supplier Id updated ", Toast.LENGTH_LONG);
            newtoast.show();


            bcsupplier.close();

        } catch (Exception e) {


        }


    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Suppliers Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
