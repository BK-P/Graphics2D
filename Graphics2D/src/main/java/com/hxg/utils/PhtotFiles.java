package com.hxg.utils;

import com.hxg.dao.StudentOnlineCard;

import java.io.File;

/**
 * 调用PhotoFile类的photofile方法发 查询 文件夹内所有照片的地址
 * @author : Dot
 * @date :  2020-09-11 12:48
 */
public class PhtotFiles {
    Graphics2D graphics2D = new Graphics2D();
    PhotoFile photoFile = new PhotoFile();
    public void photofiles(File file, File outfile, StudentOnlineCard studentOnlineCard){
        photoFile.photofile(file);
        for (File photofilepath : photoFile.photoFilePaths) {
            graphics2D.step1(photofilepath,outfile, studentOnlineCard);
        }
    }
}
