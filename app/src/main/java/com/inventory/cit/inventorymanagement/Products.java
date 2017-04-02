package com.inventory.cit.inventorymanagement;

import android.content.ContentValues;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Products extends AppCompatActivity implements View.OnClickListener {

    String strproductid=null;
    String strproductname=null;
    String strproductserial=null;
    String strproductcolour=null;
    String strproducttype=null;
    String strproductactive=null;
    String strproductcategory1=null;
    ContentValues cvproduct;
    EditText etproductid,etproductname,etproductserial,etproductcolour,etproducttype,etproductactive,etproductcategory1;
    Button btsave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        etproductid =  (EditText) findViewById(R.id.etproductid);
        etproductname = (EditText) findViewById(R.id.etproductserial);
        etproductserial = (EditText) findViewById(R.id.etproductserial);
        etproductcolour = (EditText) findViewById(R.id.etproductserial);
        etproducttype = (EditText) findViewById(R.id.etproducttype);
        etproductactive = (EditText) findViewById(R.id.etproductactive);
        etproductcategory1 = (EditText) findViewById(R.id.etproductcategory1);


        btsave = (Button) findViewById(R.id.btsave);
        btsave.setOnClickListener(this);
                //etproductid,etproductname,etproductserial,etproductcolour,etproducttype,etproductactive,etproductcategory1;




    }


    @Override
    protected void onPause() {
        super.onPause();




    }

    @Override
    protected void onResume()
    {
        super.onResume();



    }


    public void insertproduct()
    {

        BaseClass bc1 = new BaseClass(this);
        String dbtablename = "INVENTORY_PRODUCT";
        bc1.open();



      Long lgresult=  bc1.insertrows_db(dbtablename,cvproduct);


        Toast newtoast =Toast.makeText(this,"Product Id updated ",Toast.LENGTH_LONG);
        newtoast.show();


        bc1.close();




    }

public void getdata()

{


      cvproduct = new ContentValues();

    strproductid=etproductid.getText().toString();
    strproductname=etproductname.getText().toString();
    strproductserial=etproductserial.getText().toString();
    strproductcolour=etproductcolour.getText().toString();
    strproducttype=etproducttype.getText().toString();
    strproductactive=etproductactive.getText().toString();
    strproductcategory1=etproductcategory1.getText().toString();


    //cvproduct.put("PRODUCT_ID",strproductid);
    cvproduct.put("PRODUCT_ID", Integer.valueOf(strproductid));
    cvproduct.put("PRODUCT_NAME",strproductname);
    cvproduct.put("PRODUCT_SERIAL",strproductserial);
    cvproduct.put("PRODUCT_COLOUR",strproductcolour);
    cvproduct.put("PRODUCT_TYPE",strproducttype);
    cvproduct.put("PRODUCT_ACTIVE",strproductactive);
    cvproduct.put("PRODUCT_CATEGORY1",strproductcategory1);




  //  etproductid,etproductname,etproductserial,etproductcolour,etproducttype,etproductactive,etproductcategory1;


}
   public void onClick(View v)


   {

getdata();
       insertproduct();

   }



}
