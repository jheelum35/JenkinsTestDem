
package utils;

import java.io.FileNotFoundException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import com.google.gson.reflect.TypeToken;
import java.util.Map;
import java.lang.reflect.Type;
import com.google.gson.Gson;

public class JsonUtils
{
    public String toJson(final Object object, final Class<?> cType) {
        return new Gson().toJson(object, (Type)cType);
    }
    
    public String toJson(final Object object) {
        return new Gson().toJson(object);
    }
    
    public <T> T fromJson(final String strJson, final Class<T> cType) {
        return (T)new Gson().fromJson(strJson, (Class)cType);
    }
    
    public Map<String, Object> jsonToMap(final String strJsonString) {
        final Type type = new TypeToken<HashMap<String, Object>>() {}.getType();
        return (Map<String, Object>)new Gson().fromJson(strJsonString, type);
    }
    
    public Map<String, Object> jsonFileToMap(final String strFilePath) throws FileNotFoundException {
        final BufferedReader br = new BufferedReader(new FileReader(strFilePath));
        return this.jsonToMap(new Gson().toJson((Object)br, (Type)Object.class));
    }
}
