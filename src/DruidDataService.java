

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;



/**
 * Created by inocer on 11/20/17.
 *
 *
 *
 * curl -L -H'Content-Type: application/json' -XPOST
 * -d '{"queryType":"topN","dataSource":"wikiticker","intervals":["2015-09-12/2015-09-13"],
 * "granularity":"all","dimension":"page","metric":"edits","threshold":25,
 * "aggregations":[{"type":"longSum","name":"edits","fieldName":"count"}]}'
 * http://localhost:8082/druid/v2/?pretty
 *
 */
public class DruidDataService extends DataService {
    @Override
    public int getAttributeCardinality(String attribute, String table) {
        return 0;
    }

    @Override
    public int getAttributeValueCount(String value, String attribute, String table) {
        return 0;
    }

    @Override
    public int getTwoAttributesUnionCount(String valueOne, String attributeOne, String valueTwo, String attributeTwo, String table) {
        return 0;
    }

    @Override
    public int getAttributeCardinality(String attribute, String table, Connection connection) {
        return 0;
    }

    @Override
    public int getAttributeValueCount(String value, String attribute, String table, Connection connection) {
        return 0;
    }

    @Override
    public int getTwoAttributesUnionCount(String valueOne, String attributeOne, String valueTwo, String attributeTwo, String table, Connection connection) {
        return 0;
    }

    @Override
    public String[] getDistinctValues(String attribute, String table) {
        return new String[0];
    }

    @Override
    public String[] getDistinctValues(String attribute, String table, Connection connection) {
        return new String[0];
    }

    @Override
    public ArrayList<Integer> getIntegerValuesForClassValue(String attribute, String classValue, String classAttribute, String table) {
        return null;
    }

    @Override
    public ArrayList<Integer> getIntegerValuesForClassValue(String attribute, String classValue, String classAttribute, String table, Connection connection) {
        return null;
    }

    @Override
    public double[] getIntegerValuesForClassValuesArray(String attribute, String classValue, String classAttribute, int count, String table, Connection connection) {
        return new double[0];
    }

    public void whenPostJsonUsingHttpClient_thenCorrect()
            throws ClientProtocolException, IOException {

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://localhost:8082/druid/v2/?pretty");

//        HttpClient client = new DefaultHttpClient();
//        HttpPost httpPost = new HttpPost(
//                " http://localhost:8082/druid/v2/?pretty");
        String json = "{\n" +
                "  \"queryType\" : \"topN\",\n" +
                "  \"dataSource\" : \"wikiticker\",\n" +
                "  \"intervals\" : [\"2015-09-12/2015-09-13\"],\n" +
                "  \"granularity\" : \"all\",\n" +
                "  \"dimension\" : \"page\",\n" +
                "  \"metric\" : \"edits\",\n" +
                "  \"threshold\" : 25,\n" +
                "  \"aggregations\" : [\n" +
                "    {\n" +
                "      \"type\" : \"longSum\",\n" +
                "      \"name\" : \"edits\",\n" +
                "      \"fieldName\" : \"count\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        StringEntity entity = new StringEntity(json);
        httpPost.setEntity(entity);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");

        CloseableHttpResponse response =  client.execute(httpPost);

        String json_string = EntityUtils.toString(response.getEntity());
        System.out.printf(json_string);

    }

}


