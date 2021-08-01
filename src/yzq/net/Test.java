package yzq.net;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Test {
    private static InputStream inputStream;
    private static FileOutputStream fileOutputStream;

    public static void main(String[] args) {

        try {
            URL url = new URL("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fcdn.duitang.com%2Fuploads%2Fitem%2F201303%2F29%2F20130329205806_kTTnv.thumb.700_0.jpeg&refer=http%3A%2F%2Fcdn.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1628168101&t=f7c546a7934b7a8071a76644d8797798");


            inputStream = url.openStream();
            byte[] bytes = inputStream.readAllBytes();


            File file = new File("src/yzq/net/2.png");

            if (!file.exists()) {
                boolean newFile = file.createNewFile();
                System.out.println("newFile = " + newFile);
            }
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(bytes);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
