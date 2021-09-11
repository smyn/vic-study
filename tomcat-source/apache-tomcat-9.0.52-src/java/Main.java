import org.apache.catalina.startup.Bootstrap;
import org.apache.catalina.startup.Tomcat;

/**
 * @author vic
 * @date 9/11/2021 9:32 AM
 * @description TODO
 */
public class Main {

    public static void main(String[] args) {
        String catalina = "D:/code/github/spring-demo/tomcat-source/apache-tomcat-9.0.52-src";
        String [] runaArgs = {
            "-Dcatalina.home="+catalina+"/",
            "-Dcatalina.base="+ catalina+"/",
            "-Djava.endorsed.dirs="+catalina+"://endorsed",
            "-Djava.io.tmpdir="+catalina+"://temp",
            "-Djava.util.logging.manager=org.apache.juli.ClassLoaderLogManager",
            "-Djava.util.logging.config.file="+catalina+"://conf/logging.properties",
            "-Duser.language=en",
            "-Duser.region=US"};
        Bootstrap.main(runaArgs);
    }
}
