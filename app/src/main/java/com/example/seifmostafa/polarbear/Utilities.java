package com.example.seifmostafa.polarbear;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.media.MediaPlayer;
import android.os.Vibrator;

/**
 * Created by seifmostafa on 4/23/16.
 */
public class Utilities {
   void  MakeViberate(Activity activity)
    {
        Vibrator v = (Vibrator) activity.getSystemService(Context.VIBRATOR_SERVICE);
        // Vibrate for 500 milliseconds
        v.vibrate(10000);
    }
   void MakeSound(MediaPlayer mp)
    {
        mp.start();
    }
   /* MediaPlayer CapAudio()
    {

    }
    MediaPlayer CapPhoto()
    {

    }*/
   Location getMylocation(Activity activity)
    {
        return new GPSTracker(activity).getLocation();
    }
    Location[] getAroundLocation(double lat1, double lon1){

    Location[] locations = new Location[(int)(1000*4)];
      double   R = 6378.1  ;     //Radius of the Earth
      double   brng = 1.57;     //Bearing is 90 degrees converted to radians.
      double   d = 0.001;       // scanning 1 km
       int k=0;
    for(int i=0;i<1000;i++)
    {
        for(int j=0;j<4;j++)
        {
           double lat=Math.toRadians(lat1), lon=Math.toRadians(lon1);
    double newLat = Math.asin(Math.sin(lat) * Math.cos(d / R) + Math.cos(lat) * Math.sin(d / R) * Math.cos(brng));
    double newlan =  lon + Math.atan2(Math.sin(brng)*Math.sin(d/R)*Math.cos(lat1),
            Math.cos(d/R)-Math.sin(lat1)*Math.sin(lat));
            Location targetLocation = new Location("");//provider name is unecessary
            targetLocation.setLatitude(newLat);//your coords of course
            targetLocation.setLongitude(newlan);
           locations[k+j]=targetLocation;
        }
        k+=4;
    }
        return locations;
    }

}
