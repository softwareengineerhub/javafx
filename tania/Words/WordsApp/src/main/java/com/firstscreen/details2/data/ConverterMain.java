package com.firstscreen.details2.data;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Properties;

public class ConverterMain {

    public static void main(String[] args) throws Exception {
        Map<String, String> map = Berries.getData();
        Properties props = new Properties();
        props.putAll(map);
        props.store(new FileOutputStream(new File("details.properties")),"");

    }
}
