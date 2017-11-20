import java.sql.Connection;
import java.util.ArrayList;

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
}
