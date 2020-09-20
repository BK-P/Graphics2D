package com.hxg.utils;

import com.hxg.dao.StudentOnlineCard;

import java.io.File;
import java.util.ArrayList;

/**
 * 从文件中获取照片路径
 * @author : Dot
 * @date :  2020-09-10 15:30
 */
public class PhotoFile {

    ArrayList<File> photoFilePaths = new ArrayList<>();
    public void photofile (File file){
        File[] photofiles = file.listFiles();

        for(File photofile:photofiles){
            if(photofile.isDirectory())	//若是目录，则递归打印该目录下的文件
                photofile(photofile);
            if(photofile.isFile())		//若是文件，直接赋值
                photoFilePaths.add(photofile);
        }

    }



}
