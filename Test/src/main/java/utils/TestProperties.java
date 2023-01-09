package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;

public class TestProperties {
	// private static final Logger log;
	    private TestProperties instance;
	    private Properties prop;
	    private static final String PROPERTIES = ".properties";
	    private static final String CONFIG = "config";
	    private static final String LOCAL_CONFIG = "local.config";
	    private String strEnvConfig;
	    
	    public synchronized TestProperties getInstance() {
	        if (this.instance == null) {
	            this.instance = new TestProperties();
	        }
	        return this.instance;
	    }
	    
	    public TestProperties() {
	        this.instance = null;
	        this.prop = null;
	        this.strEnvConfig = "";
	        if (this.prop == null) {
	            this.prop = this.getProperties();
	            this.strEnvConfig = this.prop.getProperty("ENV_CONFIG");
	        }
	    }
	    
	    private Properties getProperties() {
	        final Properties properties = new Properties();
	        try {
	            final InputStream in = this.getClass().getClassLoader().getResourceAsStream("Config.properties");
	            properties.load(in);
	            in.close();
	            this.storeProperies(properties);
	        }
	        catch (FileNotFoundException ex) {
	            //TestProperties.log.error(this.getClass().getName() + " property file not found in the classpath");
	        }
	        catch (IOException ex2) {
	            //TestProperties.log.error(this.getClass().getName() + " Error reading file");
	        }
	        return properties;
	    }
	    
	    private void storeProperies(final Properties prop) {
	        try {
	            final InputStream inLocal = this.getClass().getClassLoader().getResourceAsStream("local.config.properties");
	            final Properties properties = new Properties();
	            properties.load(inLocal);
	            inLocal.close();
	            final Enumeration<Object> enumKeys = properties.keys();
	            while (enumKeys.hasMoreElements()) {
	                final String strLocalKey = enumKeys.nextElement().toString();
	                if (prop.containsKey(strLocalKey)) {
	                    prop.setProperty(strLocalKey, properties.getProperty(strLocalKey));
	                }
	                else {
	                    prop.put(strLocalKey, properties.getProperty(strLocalKey));
	                }
	            }
	        }
	        catch (Exception ex) {}
	    }
	    
	    public String getPropertyValue(final String strPropertyName) {
	        return this.getPropertyValue(strPropertyName, this.strEnvConfig);
	    }
	    
	    private String getPropertyValue(String strPropertyName, final String strEnvConfig) {
	        if (strEnvConfig != null && !strEnvConfig.equals("")) {
	            strPropertyName = strPropertyName + "[" + strEnvConfig + "]";
	        }
	        return (this.prop.getProperty(strPropertyName) != null) ? this.prop.getProperty(strPropertyName).trim() : "";
	    }
	    
	    public String getRootPropertyValue(final String strPropertyName) {
	        return this.prop.getProperty(strPropertyName);
	    }
	    
	    public void setRootPropertyValue(final String strPropertyName, final String strPropertyValue) {
	        this.prop.setProperty(strPropertyName, strPropertyValue);
	        if (strPropertyName.equalsIgnoreCase("ENV_CONFIG")) {
	            this.strEnvConfig = strPropertyValue;
	        }
	    }
	    
	    public void setPropertyValue(final String strPropertyName, final String strPropertyValue) {
	        this.prop.setProperty(strPropertyName, strPropertyValue);
	    }
	    
	    public boolean isPropertyExists(final String strPropertyName) {
	        return this.prop.getProperty(strPropertyName) != null;
	    }
	    
	    public Enumeration<?> getPropertyNames() {
	        return this.prop.propertyNames();
	    }
	    
	    static {
	      //  log = (Logger) LoggerFactory.getLogger((Class)TestProperties.class);
	    }
	}
