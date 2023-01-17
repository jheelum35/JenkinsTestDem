package base;
import org.slf4j.LoggerFactory;
import java.util.Iterator;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.Reader;
import java.io.FileReader;
import org.json.simple.parser.JSONParser;
import java.util.concurrent.locks.ReentrantLock;
import java.util.ArrayList;
import java.util.HashMap;
import org.slf4j.Logger;

public class JsonParser
{
    private static final Logger log;
    private static JsonParser INSTANCE;
    private static HashMap<String, ArrayList<HashMap<String, Object>>> hmapAllDataMap;
    private static ArrayList<String> lstFile;
    private static ReentrantLock rLock;
    
    private JsonParser() {
    }
    
    public static JsonParser getJsonParser(final String strFilePath) throws Exception {
        try {
            synchronized (JsonParser.rLock) {
                JsonParser.rLock.lock();
                if (JsonParser.INSTANCE == null) {
                    JsonParser.INSTANCE = new JsonParser();
                }
            }
            if (!JsonParser.lstFile.contains(strFilePath)) {
                JsonParser.lstFile.add(strFilePath);
                parseJsonFile(strFilePath);
            }
        }
        finally {
            JsonParser.rLock.unlock();
        }
        return JsonParser.INSTANCE;
    }
    
    public static ArrayList<HashMap<String, Object>> getTestData(final String strMethodName) {
        final ArrayList<HashMap<String, Object>> lstTestData = JsonParser.hmapAllDataMap.get(strMethodName);
        if (lstTestData == null) {
            JsonParser.log.info("Data for the method '" + strMethodName + "' was not found. The test will be skipped.");
        }
        return lstTestData;
    }
    
    private static HashMap<String, ArrayList<HashMap<String, Object>>> parseJsonFile(final String filepath) throws Exception {
        final JSONParser parser = new JSONParser();
        try {
            final Object obj = parser.parse((Reader)new FileReader(filepath));
            final JSONObject jsonObject = (JSONObject)obj;
            final JSONArray dataList = (JSONArray)jsonObject.get((Object)"data");
            for (final Object data : dataList) {
                final JSONObject jsonObject2 = (JSONObject)data;
                final JSONArray jsonArrTestData = (JSONArray)jsonObject2.get((Object)"testdata");
                final String mname = (String)jsonObject2.get((Object)"methodName");
                String[] arrMethod = null;
                if (mname.contains(",")) {
                    arrMethod = mname.split(",");
                }
                final ArrayList<HashMap<String, Object>> lstTestDataMap = new ArrayList<HashMap<String, Object>>();
                for (final Object testdata : jsonArrTestData) {
                    final JSONObject testdatajsonObject = (JSONObject)testdata;
                    final String testdataString = testdatajsonObject.toJSONString();
                    final HashMap<String, Object> resultMap = (HashMap<String, Object>)new Gson().fromJson(testdataString, new TypeToken<HashMap<String, Object>>() {}.getType());
                    lstTestDataMap.add(resultMap);
                }
                if (arrMethod != null) {
                    for (final String key : arrMethod) {
                        JsonParser.hmapAllDataMap.put(filepath + "/" + key, (ArrayList<HashMap<String, Object>>)jsonArrTestData);
                    }
                }
                else {
                    JsonParser.hmapAllDataMap.put(filepath + "/" + mname, (ArrayList<HashMap<String, Object>>)jsonArrTestData);
                }
            }
        }
        catch (IOException e) {
            throw new Exception("FileNotFoundException: Not able to find or parse Json " + e.getMessage(), e);
        }
        catch (ParseException e2) {
            throw new Exception("Not able to find or parse Json" + e2.getMessage(), (Throwable)e2);
        }
        catch (NullPointerException e3) {
            throw new Exception("Verify that you have data inside the file and there are 'methodName' and 'testdata'=", e3);
        }
        return JsonParser.hmapAllDataMap;
    }
    
    static {
        log = LoggerFactory.getLogger((Class)JsonParser.class);
        JsonParser.INSTANCE = null;
        JsonParser.hmapAllDataMap = new HashMap<String, ArrayList<HashMap<String, Object>>>();
        JsonParser.lstFile = new ArrayList<String>();
        JsonParser.rLock = new ReentrantLock(true);
    }
}
