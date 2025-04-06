package com.shawn.generator;

import com.shawn.model.MainTemplateConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;

public class DynamicGenerator {
    public static void main(String[] args) throws IOException, TemplateException {
        Configuration configuration=new Configuration(Configuration.VERSION_2_3_32);

        String projectPath=System.getProperty("user.dir");
        String inputPath=projectPath+File.separator+ "src/main/resources/templates/MainTemplate.java.ftl";
        String outputPath=projectPath+File.separator+"MainTemplate.java";
        MainTemplateConfig mainTemplateConfig=new MainTemplateConfig();
        mainTemplateConfig.setAuthor("shawn");
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setOutputText("sum=");

        doGeneration(inputPath,outputPath,mainTemplateConfig);
    }

    public static void doGeneration(String inputPath,String outputPath,Object model)
        throws IOException,TemplateException{

        Configuration configuration=new Configuration(Configuration.VERSION_2_3_32);

        File templateDir=new File(inputPath).getParentFile();
        configuration.setDirectoryForTemplateLoading(templateDir);

        configuration.setDefaultEncoding("utf-8");

        String templateName=new File(inputPath).getName();

        Template template=configuration.getTemplate(templateName);


        Writer out=new FileWriter(outputPath);
        template.process(model,out);

        out.close();


    }
}
