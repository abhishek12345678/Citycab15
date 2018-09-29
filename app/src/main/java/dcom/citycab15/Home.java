package dcom.citycab15;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AutoCompleteTextView;

public class Home extends AppCompatActivity {


    AutoCompleteFilter typefilter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        typefilter = new AutoCompleteFilter.Builder()
                      .setTypeFilter(AutoCompleteFilter.TYPE_FILTER_ADDRESS)
                       .setTypeFilter(3)
                       .build();
    }

    private void displayLocation()
    {
        if(mLastLocation != null)
        {
            LatLng center = new LatLng(mLastLocation.getLatitude(),mLastLocation.getLongitude());

            LatLng northSide = SphericalUtil.computerOffset(center,10000,0);

            LatLng southSide = SphericalUtil.computerOffset(center,10000,180);

            LatLngBounds bounds = LatLngBounds.builder()
                    .include(northSide)
                    .include(southSide)
                    .build();

            place_location.setBoundsBais(bounds);
            place_location.setFilter(typeFilter);

            place_destination.setBoundsBais(bounds);
            place_location.setFilter(typeFilter);





        }
    }
}
