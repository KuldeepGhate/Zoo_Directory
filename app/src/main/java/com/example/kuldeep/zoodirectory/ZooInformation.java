package com.example.kuldeep.zoodirectory;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Kuldeep on 1/20/2015.
 */
public class ZooInformation extends Activity{
    Button button;
    @Override
    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.zoo_info);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:0377778888"));
                startActivity(callIntent);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem items) {

        super.onOptionsItemSelected(items);

        switch(items.getItemId()){
            case R.id.zoo_info:
                final Intent intent = new Intent(ZooInformation.this, ZooInformation.class);
                startActivity(intent);
                break;

            case R.id.uninstall:
                Intent uninstall = new Intent(Intent.ACTION_DELETE);
                uninstall.setData(Uri.parse("package:"+"com.example.kuldeep.zoodirectory"));
                startActivity(uninstall);
                break;
        }
        return true;
    }
}
