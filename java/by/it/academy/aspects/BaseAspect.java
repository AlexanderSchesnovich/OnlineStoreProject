package by.it.academy.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.CodeSignature;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
public class BaseAspect {
    public static final String ARGS = "Arguments: ";
    public static final String RESULT = "Result: ";
    public static final String URI = "URI: ";
    public static final String PREFIX_BEFORE = " ---> ";
    public static final String PREFIX_AFTER = " <--- ";

    public static final String BEFORE_SERVICE_PATTERN = "{}" + ARGS + "{}";
    public static final String AFTER_SERVICE_PATTERN = "{}" +RESULT + "{{}}," + ARGS + "{}";
    public static final String BEFORE_CONTROLLER_PATTERN = PREFIX_BEFORE + "{}" + "{}: " + URI + "{}," + ARGS + "{}";
    public static final String AFTER_CONTROLLER_PATTERN = PREFIX_AFTER + "{}" + "{}: " + URI + "{}, result is {}," + ARGS + "{}";

    protected String getArgsWithNames(JoinPoint point) {
        String[] parameterNames = ((CodeSignature) point.getSignature()).getParameterNames();
        Object[] args = point.getArgs();
        StringBuilder stringBuilder = new StringBuilder("{");
        for (int i = 0; i < args.length; i++) {
            stringBuilder
                    .append(parameterNames[i])
                    .append("=")
                    .append(getStringInstanceOf(Optional.ofNullable(args[i]).orElse("not defined")));
            if (i != args.length - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    protected String getStringInstanceOf(Object result) {
        if (result instanceof Object[]) {
            return Arrays.toString((Object[]) result);
        }
        if (result instanceof HashMap) {
            Map<Object, Object> resultMap = (Map) result;
            return resultMap.entrySet()
                    .stream()
                    .map(entry -> String.join(":", entry.getKey().toString(), entry.getValue().toString()))
                    .collect(Collectors.joining(", ", "{", "}"));
        }
        return Optional.ofNullable(result).orElse("noy defined").toString();
    }
}
