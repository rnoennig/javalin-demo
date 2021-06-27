package snippet;

import io.javalin.Javalin;
import static io.javalin.apibuilder.ApiBuilder.*;

import java.util.HashMap;

public class Snippet {
	private static int PORT = 5000;

	public static void main(String[] args) {
		Javalin.create(config -> {
		    config.enableCorsForAllOrigins();
		    config.asyncRequestTimeout = 10_000L;
		    config.enforceSsl = false;
		}).routes(() -> {
		    path("hello", () -> {
		    	get(ctx -> {
		    		ctx.result("hello world");
		    		ctx.status(200);
		    	});
		    });
		    
		    path("json", () -> {
		    	get(ctx -> {
		    		ctx.json(new HashMap<String, String>() {{
		    	        put("prop1", "value1");
		    	        put("prop2", "value2");
		    	    }});
		    		ctx.status(200);
		    	});
		    });
		}).start(PORT );
	}
}

