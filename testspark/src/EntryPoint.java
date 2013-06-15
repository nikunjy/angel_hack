import static spark.Spark.get;
import spark.Request;
import spark.Response;
import spark.Route;

import com.google.gson.Gson;

public class EntryPoint {

	public static void main(String[] args) {

		get(new Route("/hello") {
			@Override
			public Object handle(Request request, Response response) {
				System.out.println(request.toString());
				String req = request.queryParams("payload");
				Gson gson = new Gson();
				BagOfPrimitives obj = gson.fromJson(req, BagOfPrimitives.class);   
				obj.name="Deepak";
				obj.data="Neralla";
				return gson.toJson(obj);

			}
		});

	}

}
