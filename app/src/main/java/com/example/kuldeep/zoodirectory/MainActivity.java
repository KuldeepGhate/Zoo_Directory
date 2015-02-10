package com.example.kuldeep.zoodirectory;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    private List<Animal> myAnimals = new ArrayList<Animal>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateAnimalList();
        populateListView();
        registerClick();

    }
    private void registerClick(){


        ListView listView = (ListView) findViewById(R.id.animalsList);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                Animal clickedAnimal = myAnimals.get(position);
                final Intent intent = new Intent(MainActivity.this, AnimalInformation.class);
                intent.putExtra("animal", clickedAnimal);

                //set alert dialogue at the last position

                if(position == 6) {
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                    // set title
                    alertDialogBuilder.setTitle("Warning");

                    // set dialog message'
                    alertDialogBuilder
                            .setMessage("The selected animal is dangerous! Do you want to proceed")
                            .setCancelable(false)
                            .setPositiveButton("Yes",new DialogInterface.OnClickListener(){
                                public void onClick(DialogInterface dialog,int id){
                                    startActivity(intent);
                                }

                            })
                            .setNegativeButton("No",new DialogInterface.OnClickListener(){
                                public void onClick(DialogInterface dialog, int id){
                                    // if this button is clicked, just close
                                    // the dialog box and do nothing
                                    dialog.cancel();
                                }

                            });
                    // create alert dialog
                    AlertDialog alertDialog = alertDialogBuilder.create();

                    // show it
                    alertDialog.show();

                }
                else {
                    startActivity(intent);
                }
            }
        });
    }
    /**
     * Populate animal arraylist with the use of constructor*/
      private void populateAnimalList(){
          myAnimals.add(new Animal(R.drawable.anaconda,"Anaconda","He is anaconda!"));
          myAnimals.add(new Animal(R.drawable.ant,"Ant","He is an ant!"));
          myAnimals.add(new Animal(R.drawable.antelope,"Anatelope","He is a antelope!"));
          myAnimals.add(new Animal(R.drawable.bat,"Bat","He is a bat!"));
          myAnimals.add(new Animal(R.drawable.blad_eagle,"Bald Eagle","Here is an eagle!"));
          myAnimals.add(new Animal(R.drawable.camel,"Camel","He is a camel!"));
          myAnimals.add(new Animal(R.drawable.cobra,"Cobra","He is a cobra!"));

      }

    private void populateListView(){
        ArrayAdapter<Animal> adapter = new MyListAdapter();
        ListView list = (ListView) findViewById(R.id.animalsList);
        list.setAdapter(adapter);
    }

    private class MyListAdapter extends ArrayAdapter<Animal>{
        public MyListAdapter(){
            super(MainActivity.this,R.layout.list_animals,myAnimals);
        }
        @Override
        public View getView(int postion,View convertView, ViewGroup parent){
            View itemView = convertView;

            if(itemView == null){
                itemView = getLayoutInflater().inflate(R.layout.list_animals,parent,false);
            }

            //find the animal to work with
            Animal currentAnimal = myAnimals.get(postion);

            //fill the view
            ImageView imageView = (ImageView) itemView.findViewById(R.id.imgIcon);
            imageView.setImageResource(currentAnimal.getIcon());

            //make
            TextView txtTitle = (TextView) itemView.findViewById(R.id.txtTitle);
            txtTitle.setText(currentAnimal.getTitle());
            return itemView;


        }//function getView


    }//class MyListAdapter

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
               final Intent intent = new Intent(MainActivity.this, ZooInformation.class);
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
