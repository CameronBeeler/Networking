package com.cambeeler;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Main {

    public static void main(String[] args) {
        try
        {
//            URI uri = new URI("http://username:password@myserver.com:5000/catalogue/phones?os=android#samsung");
            URI baseURI = new URI("http://username:password@myserver.com:5000"); // can be managed in 1 place and
            // all relative uri's can be handled separately
            URI uri = new URI("/catalogue/phones?os=android#samsung");
            URI resolvedURI = baseURI.resolve(uri);
            URL url = resolvedURI.toURL();  // then all combined into a single complete URI to be converted into URL's as needed.
            System.out.println("URL: " + url);

            System.out.println("scheme: " + uri.getScheme());
            System.out.println("scheme-specific-part: " + uri.getSchemeSpecificPart());
            System.out.println("authority: " + uri.getAuthority());
            System.out.println("user-info: " + uri.getUserInfo());
            System.out.println("host: " + uri.getHost());
            System.out.println("port: " + uri.getPort());
            System.out.println("path: " + uri.getPath());
            System.out.println("query: " + uri.getQuery());
            System.out.println("fragment: " + uri.getFragment());

        }
        catch (URISyntaxException u)
        {
            System.out.println("URI bad syntax exception: " + u.getMessage());
        }
        catch (MalformedURLException u)
        {
            System.out.println("URL is malformed: " + u.getMessage());
        }
    }
}
