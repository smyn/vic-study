import org.apache.catalina.startup.Bootstrap;
import org.apache.catalina.startup.Tomcat;

/**
 * @author vic
 * @date 9/11/2021 9:32 AM
 * @description TODO
 */
public class Main {

    public static void main(String[] args) {
        String [] runaArgs = {
            "-Dcatalina.home=D:/code/github/apache-tomcat-9.0.52-src/",
            "-Dcatalina.base=D:/code:/github:/apache-tomcat-9.0.52-src:/",
            "-Djava.endorsed.dirs=D:/code:/github:/apache-tomcat-9.0.52-src://endorsed",
            "-Djava.io.tmpdir=D:/code:/github:/apache-tomcat-9.0.52-src://temp",
            "-Djava.util.logging.manager=org.apache.juli.ClassLoaderLogManager",
            "-Djava.util.logging.config.file=D:/code:/github:/apache-tomcat-9.0.52-src://conf/logging.properties",
            "-Duser.language=en",
            "-Duser.region=US"};
        Bootstrap.main(runaArgs);
    }
}
