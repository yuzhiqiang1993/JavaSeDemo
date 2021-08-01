package yzq.io;

import java.io.*;

public class TestFile {
    public static void main(String[] args) {


        int availableProcessors = Runtime.getRuntime().availableProcessors();

        System.out.println("availableProcessors = " + availableProcessors);
        File file = new File("D:\\workspace\\Java\\JavaSETest\\src\\yzq\\io\\xeon.txt");

//        if (!file.exists()) {
//            try {
//                boolean newFile = file.createNewFile();
//
//                System.out.println("创建成功" + newFile);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        System.out.println("file.canWrite() = " + file.canWrite());
//
//        try {
//            FileOutputStream fileOutputStream = new FileOutputStream(file);
//            byte[] bytes = "xeon".getBytes(StandardCharsets.UTF_8);
//            fileOutputStream.write(bytes);
//
//            fileOutputStream.flush();
//            fileOutputStream.close();
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        System.out.println("file.length() = " + file.length());

        FileInputStream fileInputStream = null;

        FileReader fileReader = null;
        BufferedReader bufferedReader;
        try {
            fileInputStream = new FileInputStream(file);
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);


            String str = "";
            while ((str = bufferedReader.readLine()) != null) {

                System.out.println("str = " + str);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
