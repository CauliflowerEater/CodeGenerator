package com.shawn.generator;

import cn.hutool.core.io.FileUtil;

import java.io.File;

public class StaticGenerator {
    public static void main(String[] args){
        String projectPath=System.getProperty("user.dir");
        File parentFile=new File(projectPath).getParentFile();

        String inputPath=new File(parentFile,"generator-demo-projects/acm-template").getAbsolutePath();

        String outputPath=projectPath;
        copyFilesByHutool(inputPath,outputPath);
    }

    public static void copyFilesByHutool(String inputPath,String outputPath){
        FileUtil.copy(inputPath,outputPath,false);
    }
}
