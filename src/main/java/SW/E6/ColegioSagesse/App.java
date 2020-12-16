package SW.E6.ColegioSagesse;
import com.google.gson.*;

import static spark.Spark.*;
import spark.ModelAndView;
import spark.Route;
import static spark.Spark.staticFileLocation;
import spark.Spark;
import spark.template.thymeleaf.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App {
    private static Gson gson = new Gson();

    public static void main(String[] args) {
        staticFileLocation("/templates");
        metodosJorge mj = new metodosJorge();
        options("/*", (request,response)->{
            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }
            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if(accessControlRequestMethod != null){
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }
    
            return "OK";
        });
        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));
        //before((req, res)->res.type("application/json"));
        //before((req, res)->res.type("*/*"));
        post("/tablaMaestros", (req, res) -> gson.toJson(mj.getMaestros()));
        get("/eliminar", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("mtro", new Maestro(request.queryParams("name"), Integer.parseInt(request.queryParams("id"))));
            return new ModelAndView(model, "verifiEliminar"); // located in resources/templates
        }, new ThymeleafTemplateEngine());
        get("/deleteMtro", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("mensaje", mj.delete(Integer.parseInt(request.queryParams("id"))));
            return new ModelAndView(model, "eliminado"); // located in resources/templates
        }, new ThymeleafTemplateEngine());
        get("/getDatos", (request, response) -> {
            response.type("text/html");
            Map<String, Object> model = new HashMap<>();
            model.put("mtr", mj.verInfoMtro(Integer.parseInt(request.queryParams("id"))));
            return new ModelAndView(model, "modificarMtro"); // located in resources/templates
        }, new ThymeleafTemplateEngine());
        get("/verInfo", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("mtr", mj.verInfoMtro(Integer.parseInt(request.queryParams("id"))));
            return new ModelAndView(model, "verInfo"); // located in resources/templates
        }, new ThymeleafTemplateEngine());
        post("/modificar", (request, response) -> {
            String query = request.body();
            System.out.println( "Petición: "+query);
            Maestro m = gson.fromJson(query, Maestro.class);
            Map<String, Object> model = new HashMap<>();
            model.put("mtr", m);
            return new ModelAndView(model, "confirmarModificación"); // located in resources/templates
        }, new ThymeleafTemplateEngine());
        get("/maestrosPorGrado", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            //model.put("msj", "mensaje");
            model.put("mtros", mj.getMaestrosPublico(Integer.parseInt(request.queryParams("id"))));
            return new ModelAndView(model, "verMaestrosPublico"); // located in resources/templates
        }, new ThymeleafTemplateEngine());
    }
}