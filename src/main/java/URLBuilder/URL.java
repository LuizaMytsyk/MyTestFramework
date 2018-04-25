package URLBuilder;

import java.util.HashMap;
import java.util.Map;

public class URL {

    private String serverName;

    private String http;

    private String url ="";

    private String resource;

    private String isQa="";

    private HashMap <String, String> param;

  /*  private ArrayList <String> param;*/

    private URL (){

    }

    private URL(URLBuilder urlBuilder) {
        this.serverName = urlBuilder.serverName;
        this.http = urlBuilder.http;
        this.resource = urlBuilder.resource;
        this.isQa = urlBuilder.isQa;
        this.param = urlBuilder.param;



    }
/*
    private String params() {
        String params = "";
        String separator = "?";

        if (param.size() > 0) {
            Iterator<String> it = param.iterator();
            while (it.hasNext()) {

                params = params + separator + it.next();
                if (separator == "?") {
                    separator = "&";
                }
            }
        }
        params = params + "&" + isQa;

        return params;

    }*/

    private String params(){

        String params = "";
        for (Map.Entry<String,String> entry : param.entrySet()){
            params = params +"&"+ entry.getKey()+"=" + entry.getValue();
        }

                params = params +"&" + isQa;
            return "?" + params.substring(1);
    }



    public String getUrl() {
        this.url = http + "://" + "www." + serverName + "/" + resource + params();
        return this.url;
    }

    public static class URLBuilder {

        private String serverName;
        private String http = "http";
        private String resource="";
        private String isQa="";
        private HashMap <String, String> param = new HashMap<>();
        /*private ArrayList <String> param = new ArrayList<>();*/



        public URLBuilder (String serverName){

            this.serverName = serverName;



        }

        public URLBuilder withHttps (boolean isHttps){

            http = isHttps ? "https" : "http";
            return this;
        }

        public URLBuilder withResource (String resource){
            this.resource = resource;
            return this;
        }

        public URLBuilder withIsQa (boolean isQa) {
            String partQa = "isQa=";
            this.isQa = partQa+isQa;
            return this;
        }

        public URLBuilder withParam (String key, String value){

            this.param.put(key, value);
            return this;
        }

        public URLBuilder.URL build () {

            return new URLBuilder.URL(this);
        }

    }
}
