package com.company;

import java.io.IOException;
import org.json.*;

public class Main {

    public static void main(String[] args) throws IOException {
        JSONObject obj = new JSONObject();
        obj.put("folderPath", "/users/skousei/nipai");
        obj.put("fileName", "bak14_db_202322.xls");
        obj.put("ftpHost", "10.1.43.190");
        obj.put("ftpPort", "21");
        obj.put("ftpUser", "kien.letrung");
        obj.put("ftpPassword", "Bac@!123..");
        String newArgs = obj.toString().replace("\"", "\\^\"");
        ProcessBuilder pb = new ProcessBuilder("node ../nodejs-ftp-file/index.js --data ^\"" + newArgs + "\"");
        pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        pb.redirectError(ProcessBuilder.Redirect.INHERIT);
        Process p = pb.start();
        System.out.println(p);
    }
}
