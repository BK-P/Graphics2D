package com.hxg;

import com.hxg.dao.StudentOnlineCard;
import com.hxg.utils.PhotoFile;
import com.hxg.utils.PhtotFiles;

import java.io.File;

/**
 * @author : Dot
 * @date :  2020-09-09 17:36
 */
public class test {
    public static void main(String[] args) {
        PhtotFiles phtotFiles = new PhtotFiles();
        String path ="C:\\Users\\gxp43\\Desktop\\photofile";
        File outfile = new File("D:/abc/");
        StudentOnlineCard studentOnlineCard = new StudentOnlineCard();
        studentOnlineCard.setName("高新鹏");
        studentOnlineCard.setApartment("软件工程");
        studentOnlineCard.setProfession("五公寓");
        studentOnlineCard.setBedroom("2");
        studentOnlineCard.setPrometric("123123");
        phtotFiles.photofiles(new File(path),outfile, studentOnlineCard);






    }

}
