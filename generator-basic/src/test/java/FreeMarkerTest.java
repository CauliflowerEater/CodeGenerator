import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreeMarkerTest {
    @Test
    public void test() throws IOException, TemplateException {

        Configuration configuration=new Configuration(Configuration.VERSION_2_3_32);
        configuration.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));
        configuration.setDefaultEncoding("utf-8");

        Template template =configuration.getTemplate("myweb.html.ftl");


        Map<String,Object> dataModel=new HashMap<>();
        dataModel.put("currentYear",2025);
        List<Map<String,Object>> menuList=new ArrayList<>();
        Map<String,Object> menuItem1=new HashMap<>();
        menuItem1.put("url","https://baidu.com");
        menuItem1.put("label","fake medicine");
        Map<String,Object> menuItem2=new HashMap<>();
        menuItem2.put("url","https://taobao.com");
        menuItem2.put("label","robber");
        menuList.add(menuItem1);
        menuList.add(menuItem2);
        dataModel.put("menuItems",menuList);

        Writer out=new FileWriter("myweb.html");

        template.process(dataModel,out);

        out.close();

    }


}
