package com.hxg.utils;

import java.awt.image.BufferedImage;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

/**
 * @author: Mr.J
 * @Date: 2020/9/10 15:20
 */
public class QRCode {

    /**
     * 根据内容，生成指定宽高、指定格式的二维码图片
     *
     * @return 生成的二维码图片路径
     * @param file 图片地址
     * @param outfile 图片输出地址
     */
    public  String generateQRCode(File file,File outfile,String Prometric){
        try {
            Hashtable<EncodeHintType,Object> hints = new Hashtable<>() ;
            hints.put(EncodeHintType.CHARACTER_SET, "utf-8") ;
            BitMatrix bitMatrix = new MultiFormatWriter().encode("http://dorm.greathiit.com/check/"+Prometric, BarcodeFormat.QR_CODE, 100, 100);
            bitMatrix = deleteWhite(bitMatrix);
            String pathName = outfile+"/"+file.getName() ;
            File outputFile = new File(pathName);
            if (!outputFile.exists()){
                outputFile.mkdirs() ;
            }
            MatrixToImageWriter.writeToFile(bitMatrix, "jpg", outputFile);
            return pathName ;
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "pathName";
    }
    /**
     * 删除二维码白边
     *
     * @param bitMatrix bitMatrix
     * @return BitMatrix
     */
    public static BitMatrix deleteWhite(BitMatrix bitMatrix) {
        int[] rec = bitMatrix.getEnclosingRectangle();
        int resWidth = rec[2] + 1;
        int resHeight = rec[3] + 1;

        BitMatrix resMatrix = new BitMatrix(resWidth, resHeight);
        resMatrix.clear();
        for (int i = 0; i < resWidth; i++) {
            for (int j = 0; j < resHeight; j++) {
                if (bitMatrix.get(i + rec[0], j + rec[1])) {
                    resMatrix.set(i, j);
                }
            }
        }
        return resMatrix;
    }


}
