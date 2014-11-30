package client;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

public class Client1 {

  public static void main(String[] args) {

    
/*** * Old API * * ClientConfig config = new DefaultClientConfig(); * * Client client = Client.create(config); * * WebResource service = client.resource(getBaseURI()); * * // Fluent interfaces * * System.out.println(service.path("rest").path("hello").accept(* MediaType.TEXT_PLAIN).get(ClientResponse.class).toString()); * * // Get plain text * * System.out.println(service.path("rest").path("hello").accept(* MediaType.TEXT_PLAIN).get(String.class)); * * // Get XML * * System.out.println(service.path("rest").path("hello").accept(* MediaType.TEXT_XML).get(String.class)); * * // The HTML * * System.out.println(service.path("rest").path("hello").accept(* MediaType.TEXT_HTML).get(String.class)); ***/


    ClientConfig config = new ClientConfig();

    Client client = ClientBuilder.newClient(config);

    WebTarget target = client.target(getBaseURI());
 // Get JSON for application
    System.out.println(target.path("rest").path("queryapi").queryParam("submitquery", "select `Email`,`Full Address`,`Phone`,`States Name` from cloud.agriculture_krishi_vigyan where `States Name` like 'Assam';").request().accept(MediaType.APPLICATION_JSON).get(String.class));
 

  }

  private static URI getBaseURI() {

    return UriBuilder.fromUri("http://10.1.98.196:8080/CloudMajor").build();

  }
} 