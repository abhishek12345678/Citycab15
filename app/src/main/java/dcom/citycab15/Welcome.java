package dcom.citycab15;

public class Welcome {

    AutocompleteFilter typerFilter;

    typeFilter = new  AutocompleteFilter.Builder()
                 .setTypeFilter(AutocompleteFilter.TYPE_Add)
                  .serTypeFilter(3)
                  .build();

    places = (PlaceAutocompleteFragments)getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);

    places.setOnPlaceSelectedListener(new  PlaceSelectionListener());

    private void displayLocation()
    {
        LatLng center = new LatLng(latitude,longitude);
        LatLng northside = SphericalUtil.computerOffset(center,100000,0);
        LatLng southSide = SphericalUtil.computerOffset(center,100000,0);

        LatLngBounds bounds = LatLngBounds.builder()
                .include(northside)
                .include(southSide)
                .build();

        places.setBounds(bounds);
        places.setFilter(typerFilter);





    }

}
