package com.example.kuldeep.zoodirectory;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Kuldeep on 1/17/2015.
 */
/*public class AnimalAdapter extends ArrayAdapter<Animal>{

    Context context;
    int layoutResourceId;
    Animal data[] = null;*/

  //  public AnimalAdapter(Context context, int layoutResourceId, Animal[] data){
  //      super(context, layoutResourceId, data); /*This constructor in the child class calls the parametrized constructor defined in the superclass viz ArrayAdapter*/
  //      this.layoutResourceId = layoutResourceId; /*Resource id of the layout file (list_animals.xml)*/
  //      this.context = context; /*Reference of the activity in which the AnimalAdapter class will be used*/
 //       this.data = data;
   // }

   /* @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View row = convertView;         /*old view to reuse*/
   //     AnimalHolder holder = null;
  //      Toast.makeText(getContext()," "+position,Toast.LENGTH_SHORT).show();
        /*For the first time*/
   /*     if(row == null){
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new AnimalHolder();
            holder.imgIcon = (ImageView)row.findViewById(R.id.imgIcon);
            holder.txtTitle = (TextView)row.findViewById(R.id.txtTitle);

            row.setTag(holder);
        }
        /*otherwise*/
   //     else{
    //        holder = (AnimalHolder)row.getTag();    /*getTag always needs to be casted*/
    //    }

/*        Animal animal = data[position];
        holder.txtTitle.setText(animal.title);
        holder.imgIcon.setImageResource(animal.icon);
        return row;
    }

    /* This class will be used to cache the ImageView and TextView so they can be reused for every row in the ListView and this
    will provide us a great performance improvement as we are recycling the same two views with different properties and we don’t need
     to find ImageView and TextView for every ListView item.*/

  /*  static class AnimalHolder
    {
        ImageView imgIcon;
        TextView txtTitle;
    }
}*/
