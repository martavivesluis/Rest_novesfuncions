package edu.upc.dsa;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*

{
    "singer": "Metallica",
    "title": "Enter Sandman"
    "track1":{
                "name":"hello metal",
                "duration":293;
                },
    "track2":{
        "name":"hello metal",
        "duration":293;
    },
    "track3":{
        "name":"hello metal",
        "duration":293;
    }
}


 */



@Path("/json")
public class JSONService {

    public JSONService() {
        ArrayList tracks =  SingletonArrayList.getInstance().array;
        Track t1 = new Track();
        t1.setTitle("Enter Sandman");
        t1.setSinger("Metallica");
        tracks.add(t1);

        Track t2 = new Track();
        t2.setTitle("La Barbacoa");
        t2.setSinger("Georgie Dann");
        tracks.add(t2);
    }

    @GET
    @Path("/got/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Track getTrack(@PathParam("id") int id) {
        ArrayList<Track> tracks = SingletonArrayList.getInstance().array;;
        return tracks.get(id);
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Track> getAllTracks() {
        ArrayList<Track> tracks = SingletonArrayList.getInstance().array;
        return tracks;
    }


    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Track getTrackInJSON() {

        Track track = new Track();
        track.setTitle("Enter Sandman");
        track.setSinger("Metallica");

        return track;

    }

    @POST
    @Path("/new")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newTrack(Track track) {

        ArrayList<Track> tracks = SingletonArrayList.getInstance().array;//retornem array del singleton
        HashMap<String, Track> mapaactual =  SingletonArrayList.getInstance().map;
        mapaactual.put(track.singer + track.title,track);//hashmap amb clau unica
        tracks.add(track);
        // Atencion: siempre añade en la misma posicion por el scope de tracks
        return Response.status(201).entity("Track added in position "+tracks.size()).build();
    }


}