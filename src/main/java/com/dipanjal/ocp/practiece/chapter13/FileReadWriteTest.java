package com.dipanjal.ocp.practiece.chapter13;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

/**
 * @author dipanjal
 * @since 4/22/2021
 */

public class FileReadWriteTest {

    public static void readAndWriteFile(){
        String filePathToRead = "C:\\Users\\BS-308\\Desktop\\trash\\dynamic_report_experiment.txt";
        String filePathToWrite = "C:\\Users\\BS-308\\Desktop\\trash\\dynamic_report_out.txt";

        try(InputStream in = new FileInputStream(filePathToRead); OutputStream out = new FileOutputStream(filePathToWrite)) {
            byte[] buffer = new byte[1024]; //setting a chunk size;
            int length; //how many buffer is reading is done;

            /** writing chunk by chunk */
            while( (length = in.read(buffer)) != -1){ //-1 indicates the end of the stream
                out.write(buffer, 0, length);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readBinaryFileWriteAsCharFile(){
        String filePathToRead = "C:\\Users\\BS-308\\Desktop\\trash\\Profile.pdf";
        String filePathToWrite = "C:\\Users\\BS-308\\Desktop\\trash\\Profile.txt";

        try(BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(filePathToRead)));

            PrintWriter out = new PrintWriter(
                    new OutputStreamWriter(
                            new FileOutputStream(filePathToWrite)))) {

            /** writing chunk by chunk */
            String line;
            while((line = in.readLine()) != null) {
                out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void httpResourceLoader(){
        Path path = Path.of("C:\\Users\\BS-308\\Desktop\\trash", "index.html"); //fictional path, doesn't really exists right now
//        URI uri = URI.create("http://127.0.0.1/dashboard/");
        URI uri = URI.create("https://www.citytouch.com.bd/login.html");
        HttpRequest request = HttpRequest
                .newBuilder(uri)
                .GET()
                .build();
        try {
            HttpResponse<Path> response = HttpClient
                    .newHttpClient()
                    .send(
                            request,
                            HttpResponse
                                    .BodyHandlers
                                    .ofFile(path)
                    );
            System.out.println(response.statusCode());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void fictionalPathTest(){
//        Path backup = Path.of("C:\\Users\\BS-308\\Desktop\\trash\\backup\\docs");
        Path backup = Path.of("C:\\Users\\BS-308\\Desktop\\trash", "backup", "docs");
        try {
            Files.createDirectory(backup);
        } catch (IOException e) {
            e.printStackTrace();
            try {
                Files.createDirectories(backup);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
//        readAndWriteFile();
//        readBinaryFileWriteAsCharFile();

/*        Optional.ofNullable(System.console())
                .ifPresent(console -> System.out.println("Has Console"));*/

//        httpResourceLoader();
        fictionalPathTest();

    }
}
