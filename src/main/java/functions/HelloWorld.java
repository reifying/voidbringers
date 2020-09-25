package functions;

import com.google.cloud.functions.HttpFunction;
import com.google.cloud.functions.HttpRequest;
import com.google.cloud.functions.HttpResponse;
import java.io.BufferedWriter;
import java.io.IOException;

import clojure.java.api.Clojure;
import clojure.lang.IFn;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.Callable;

public class HelloWorld implements HttpFunction {

    public static Object callClojure(String ns, String fn, HttpRequest request, HttpResponse response) throws Exception {
        // load Clojure lib. See
        // https://clojure.github.io/clojure/javadoc/clojure/java/api/Clojure.html
        IFn require = Clojure.var("clojure.core", "require");
        require.invoke(Clojure.read(ns));

        IFn fun = Clojure.var(ns, fn);
        return fun.invoke(request, response);
    }

    // Simple function to return "Hello World"
    @Override
    public void service(HttpRequest request, HttpResponse response) throws IOException {
        try {
        callClojure("serverless.core", "hello", request, response);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }
}