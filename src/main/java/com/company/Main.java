package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

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
        Iterator<String> keys = obj.keys();
        StringBuilder params = new StringBuilder();

        while(keys.hasNext()) {
            String key = keys.next();
            String subParam = "--" +
                    key +
                    "=" +
                    obj.get(key);
            params.append(subParam);
            params.append(" ");
        }
        String workingDirectory = "../nodejs-ftp-file";
        Runtime rt = Runtime.getRuntime();
        Process nodeProc = rt.exec(new String[] {"which", "node"});

        BufferedReader stdInput = new BufferedReader(new
                InputStreamReader(nodeProc.getInputStream()));
        System.out.println("================" + stdInput.readLine());
        ProcessBuilder pb = new ProcessBuilder("/opt/nodejs/node-v16.16.0-linux-x64/bin/node", "../nodejs-ftp-file/index.js", " ", obj.toString());
        pb.directory(new File(workingDirectory));
        pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        pb.redirectError(ProcessBuilder.Redirect.INHERIT);
        Process p = pb.start();
        BufferedReader errorReader = new BufferedReader(new InputStreamReader(p.getErrorStream()));
        String errorLine;
        while ((errorLine = errorReader.readLine()) != null) {
            System.err.println(errorLine);
        }
        System.out.println(p);
    }
}
