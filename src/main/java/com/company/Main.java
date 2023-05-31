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

        Runtime rt = Runtime.getRuntime();
        Process nodeProc = rt.exec(new String[] {"which", "node"});

        BufferedReader nodePath = new BufferedReader(new
                InputStreamReader(nodeProc.getInputStream()));
        String nodejsFilePath = "../nodejs-ftp-file/index.js";
        ProcessBuilder pb = new ProcessBuilder(nodePath.readLine(), nodejsFilePath, " ", obj.toString());
        pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        pb.redirectError(ProcessBuilder.Redirect.INHERIT);
        pb.start();
    }
}
