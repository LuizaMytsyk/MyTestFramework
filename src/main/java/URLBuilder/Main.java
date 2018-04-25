package URLBuilder;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList <String> list = new ArrayList<>();
        list.add("Ukraine");
        list.add("Kyiv");


        String urlBuilder = new URL.URLBuilder("facebook.com").withHttps(true).withResource("Luiza").build().getUrl();

        System.out.println(urlBuilder);

    }




}

        /*withIsQa(false)..withParam("login", "password")
                .withParam("saa","dsadas").withParam("Ukraine","Kyiv")*/


