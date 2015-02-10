package com.example.kuldeep.zoodirectory;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Kuldeep on 1/20/2015.
 */
public class AnimalInformation extends Activity{

    ImageView imgView;
    TextView animalName;
    TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animal_info);

        //1.Get passed intent
        Intent intent = getIntent();

        //2. Get animal object from intent
        Animal animal = (Animal) intent.getSerializableExtra("animal");

        //3. Get references
        imgView = (ImageView) findViewById(R.id.imageView);
        animalName = (TextView) findViewById(R.id.animal_name);
        description = (TextView) findViewById(R.id.description);

        //4. Display objects
        imgView.setImageResource(animal.getIcon());
        animalName.setText(animal.getTitle().toString());
        description.setText(animal.getDescription().toString());
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
                final Intent intent = new Intent(AnimalInformation.this, ZooInformation.class);
                startActivity(intent);

                Toast.makeText(getBaseContext(), "You selected Zoo Information", Toast.LENGTH_SHORT).show();
                break;

            case R.id.uninstall:
                Intent uninstall = new Intent(Intent.ACTION_DELETE);
                uninstall.setData(Uri.parse("package:" + "com.example.kuldeep.zoodirectory"));
                startActivity(uninstall);

                break;


        }
        return true;

    }

}
