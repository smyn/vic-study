import org.apache.catalina.startup.Bootstrap;
import org.apache.catalina.startup.Tomcat;

/**
 * @author vic
 * @date 9/11/2021 9:32 AM
 * @description TODO
 */
public class Main {

    public static void main(String[] args) {
//-Dcatalina.home=D:/code/github/vic-study/tomcat-study/source-tomcat.9.0.52/
//-Dcatalina.base=D:/code/github/vic-study/tomcat-study/source-tomcat.9.0.52/
//-Djava.endorsed.dirs=D:/code/github/vic-study/tomcat-study/source-tomcat.9.0.52/endorsed
//-Djava.io.tmpdir=D:/code/github/vic-study/tomcat-study/source-tomcat.9.0.52/temp
//-Djava.util.logging.manager=org.apache.juli.ClassLoaderLogManager
//-Djava.util.logging.config.file=D:/code/github/vic-study/tomcat-study/source-tomcat.9.0.52/conf/logging.properties
//-Duser.language=en
//-Duser.region=US
        Bootstrap.main(args);
    }
}
