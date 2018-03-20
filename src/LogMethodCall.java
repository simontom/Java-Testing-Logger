import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention (RetentionPolicy.RUNTIME) // The annotation will be available during runtime
@Target (ElementType.METHOD)         // This can just used in methods
public @interface LogMethodCall {
    Logger logLevel() default Logger.INFO;
}
