package yzq.io;

import java.io.*;

public class TestBuffer {

    public static void main(String[] args) {
        InputStream inputStream = null;
        BufferedInputStream bufferedInputStream = null;
        OutputStream outputStream = null;
        BufferedOutputStream bufferedOutputStream = null;


        try {
            inputStream = new FileInputStream("D:\\workspace\\Java\\JavaSETest\\src\\yzq\\io\\动画.gif");
            bufferedInputStream = new BufferedInputStream(inputStream);
            outputStream = new FileOutputStream("D:\\workspace\\Java\\JavaSETest\\src\\yzq\\io\\动画1.gif");
            bufferedOutputStream = new BufferedOutputStream(outputStream);

            int temp;
            while ((temp = bufferedInputStream.read()) != -1) {

                bufferedOutputStream.write(temp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                bufferedOutputStream.flush();

                inputStream.close();
                bufferedInputStream.close();
                outputStream.close();
                bufferedOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }


    }
}
