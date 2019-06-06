package com.cambeeler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main
{

    public static void main(String[] args)
    {
        try
        {

            URL           url           = new URL("http://example.org");
            HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
            httpConnection.setRequestMethod("GET");
            /*  GET, POST, HEAD, OPTIONS, PUT, DELETE and TRACE */
            httpConnection.setRequestProperty("User-Agent", "Chrome");
            httpConnection.setReadTimeout(30000);
            int ResponseCode = httpConnection.getResponseCode();
            System.out.println("Response Code: " + ResponseCode);
            if (ResponseCode != 200)
            {
                System.out.println("Error reading web page");
                return;
            }

            BufferedReader inputReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));

            String line ;
            while((line = inputReader.readLine()) != null)
            {
                System.out.println(line);
            }
            inputReader.close();

/*            URLConnection urlConnection = url.openConnection();
            urlConnection.setDoOutput(true); // do all connection configs BEFORE you connect()
            urlConnection.connect();  // By default you can only read from a connection

            BufferedReader inputStream = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            Map<String, List<String>> headerFields = urlConnection.getHeaderFields();
            for(Map.Entry<String, List<String>> entry : headerFields.entrySet())
            {
                String key = entry.getKey();
                List<String> values = entry.getValue();

                System.out.println("---key " + key);
                for (String value : values)
                {
                    System.out.println(value);
                }
            }
            String line = "";
            while(line != null)
            {
                line = inputStream.readLine();
                System.out.println(line);
            }
*/
        }
        catch (MalformedURLException u)
        {
            System.out.println("URL is malformed: " + u.getMessage());
        }
        catch (IOException e)
        {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}

/*            URI uri = new URI("http://username:password@myserver.com:5000/catalogue/phones?os=android#samsung");
            URI baseURI = new URI("http://username:password@myserver.com:5000"); // can be managed in 1 place and
            // all relative uri's can be handled separately
            URI uri1 = new URI("/catalogue/phones?os=android#samsung");
            URI uri2 = new URI("/catalogue/TVs?manufacturing=samsung");
            URI uri3 = new URI("/catalogue/locations?zip=12345");
            URI resolvedURI = baseURI.resolve(uri1);
            URL url1 = resolvedURI.toURL();  // then all combined into a single complete URI to be converted into URL's as needed.
            resolvedURI = baseURI.resolve(uri2);
            URL url2 = resolvedURI.toURL();  // then all combined into a single complete URI to be converted into URL's as needed.
            resolvedURI = baseURI.resolve(uri3);
            URL url3 = resolvedURI.toURL();  // then all combined into a single complete URI to be converted into URL's as needed.
            System.out.println("URL: " + url1);
            System.out.println("URL: " + url2);
            System.out.println("URL: " + url3);

            URI relativizedURI = baseURI.relativize(url3.toURI());
            System.out.println(relativizedURI);


            System.out.println("scheme: " + uri.getScheme());
            System.out.println("scheme-specific-part: " + uri.getSchemeSpecificPart());
            System.out.println("authority: " + uri.getAuthority());
            System.out.println("user-info: " + uri.getUserInfo());
            System.out.println("host: " + uri.getHost());
            System.out.println("port: " + uri.getPort());
            System.out.println("path: " + uri.getPath());
            System.out.println("query: " + uri.getQuery());
            System.out.println("fragment: " + uri.getFragment());
 */
//        catch (URISyntaxException u)
//        {
//            System.out.println("URI bad syntax exception: " + u.getMessage());
//        }
