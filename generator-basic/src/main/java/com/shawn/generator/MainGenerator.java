package com.shawn.generator;

import com.shawn.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

public class MainGenerator {
    public static void main(String[] args) throws TemplateException, IOException {
        MainTemplateConfig mainTemplateConfig=new MainTemplateConfig();
        mainTemplateConfig.setAuthor("Shawn");
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setOutputText("Sum:  ");
        doGeneration(mainTemplateConfig);

    }

    public static void doGeneration(Object model) throws TemplateException, IOException{
        String projectPath=System.getProperty("user.dir");
        File parentFile=new File(projectPath).getParentFile();
        String inputPath=new File(parentFile,"generator-demo-project/acm-template").getAbsolutePath();
        String outputPath=projectPath;
        StaticGenerator.copyFilesByHutool(inputPath,outputPath);

        String inputDynamicFilePath=projectPath+File.separator+"src/main/resources/templates/MainTemplate.java.ftl";
        String outputDynamicFilePath=outputPath+File.separator+"acm-template/src/com/shawn/acm/MainTemplate.java";
        DynamicGenerator.doGeneration(inputDynamicFilePath,outputDynamicFilePath,model);
    }
}
