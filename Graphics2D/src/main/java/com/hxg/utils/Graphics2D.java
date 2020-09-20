package com.hxg.utils;

import com.hxg.dao.StudentOnlineCard;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 该方法将用户输入的图片和文字画入背景中
 * @author : Dot
 * @version 1.0
 */
public class Graphics2D {
    private java.awt.Graphics2D graphics2D;
    //文字 x 轴位置
    private Integer x = 545;
    //背景图片位置
    String backgroundImgPath = "src/main/java/com/hxg/img/StudentOnlineCard.png";
    //字体及大小
    Font font = new Font("宋体", Font.BOLD, 46);

    /**
     * 这个方法从用户获取一个照片位置和一个学生卡片信息
     * 将这些信息及图片画到的学生网上卡片上并生成一个考试信息二维码
     * 之后将画好的图片发送到指定位置
     * @param photofile 照片位置
     * @param outPhotoFile 卡片输出位置
     * @param studentOnlineCard 学生信息
     */
    public void step1(File photofile,File outPhotoFile, StudentOnlineCard studentOnlineCard) {

        try {
            BufferedImage img = new BufferedImage(1063, 650, BufferedImage.TYPE_INT_RGB);
            graphics2D = img.createGraphics() ;
            BufferedImage bg = ImageIO.read(new File(backgroundImgPath));
            BufferedImage content = ImageIO.read(photofile);


            // 中间内容框画到背景图上
            Graphics g = img.getGraphics();
            g.drawImage(bg.getScaledInstance(1063, 650, Image.SCALE_DEFAULT), 0, 0, null);
            g.drawImage(content.getScaledInstance(240, 294, Image.SCALE_DEFAULT), 145, 215, null);
            //文字

            graphics2D.setPaint(Color.black);
            graphics2D.setFont(font);
            this.graphics2D.drawString(studentOnlineCard.getName(), x, 286);
            this.graphics2D.drawString(studentOnlineCard.getProfession(), x, 359);
            this.graphics2D.drawString(studentOnlineCard.getApartment(), x, 434);
            this.graphics2D.drawString(studentOnlineCard.getBedroom(), x, 509);
            //二维码
            QRCode qrCode = new QRCode();
            qrCode.generateQRCode(photofile,outPhotoFile,studentOnlineCard.getPrometric());
            BufferedImage rq = ImageIO.read(new File(outPhotoFile+"/"+photofile.getName()));
            g.drawImage(rq.getScaledInstance(100, 100, Image.SCALE_DEFAULT), 900,500 , null);

            g.dispose();
            ImageIO.write(img, "png", new File(outPhotoFile+"/"+photofile.getName()));
            System.out.println("生成成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
