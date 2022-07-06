package com.example.ty.test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Base64;

public class Base64Test {

    /**
     * base64 编码转换为 BufferedImage
     * @param base64
     * @return
     */
    public BufferedImage base64ToBufferedImage(String base64) {
        Base64.Decoder decoder = Base64.getDecoder();
        try {
            byte[] bytes1 = decoder.decode(base64);
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes1);
            return ImageIO.read(bais);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public BufferedImage getImage(String filePath) throws IOException {
        BufferedImage image = ImageIO.read(new File(filePath));
        return image;
    }

    public String bufferImageToBase64(BufferedImage image) throws IOException {
        Base64.Encoder encoder = Base64.getEncoder();
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ImageIO.write(image, "png", os);
        byte[] bytes = os.toByteArray();
        String s = encoder.encodeToString(bytes);
        return s;
    }

    public static void main(String[] args) throws IOException {
        Base64Test test = new Base64Test();
//        BufferedImage image = test.getImage("C:/Users/lenovo/Pictures/IMG_1509.jpg");
//        String s = test.bufferImageToBase64(image);
        File file = new File("1.txt");

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        String s = "";
        String line = "";
        while ((line = br.readLine()) != null) {
            s += line;
        }
        br.close();
        fr.close();

        BufferedImage bufferedImage = test.base64ToBufferedImage(s);

        File outputFile = new File("saved1.png");
        ImageIO.write(bufferedImage, "png", outputFile);

        FileWriter fw = new FileWriter("2.txt", true);

        BufferedWriter bw = new BufferedWriter(fw);

        bw.write(s);

        bw.close();
        fw.close();
    }
}
