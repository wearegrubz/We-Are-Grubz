import {useMemo, useState} from 'react';
import {GoogleMap, useLoadScript, Marker } from '@react-google-maps/api';
import React from 'react';

function Map(props) {

    const coordinates = props.coordinates

    const center = useMemo(() => ({ lat: coordinates.latitude, lng: coordinates.longitude }), []);

    const { isLoaded } = useLoadScript({
        googleMapsApiKey: 'AIzaSyDpmYDB5DFib42nQx1-__65N5RpouBqSdY'
    });

    const style = {
        backgroundColor: "#ECD6AB"

    }

    return (
        <>
            {isLoaded ? <GoogleMap zoom={15} center={center} style={style} mapContainerStyle={{height: "100%", width: "100%"}}>
                    <Marker position={center} />
                </GoogleMap>:
                <h1>Loading...</h1>
            }
        </>
    );
}

export default Map;