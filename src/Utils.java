import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Utils {

    public static void log(Object o, String methodName) {

        // Gets the object class
        Class klass = o.getClass();

        // Iterate over its methods
        for (Method m : klass.getMethods()) {

            // Verify if the method is the wanted one
            if (m.getName().equals(methodName)) {

                // Yes, it is
                // So, iterate over its annotations
                for (Annotation a : m.getAnnotations()) {

                    // Verify if it is a LogMethodCall annotation
                    if (a instanceof LogMethodCall) {

                        // Yes, it is
                        // So, cast it
                        LogMethodCall lmc = (LogMethodCall) a;

                        // Verify the log level
                        switch (lmc.logLevel()) {
                            case INFO:
                                System.out.println("performing info log for \"" + m.getName() + "\" method");
                                break;
                            case DEBUG:
                                System.out.println("performing debug log for \"" + m.getName() + "\" method");
                                break;
                        }

                    }
                }

                // Method encountered, so the loop can be break
                break;

            }

        }

    }

}
