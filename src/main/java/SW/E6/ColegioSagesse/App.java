package SW.E6.ColegioSagesse;
import com.google.gson.*;

import static spark.Spark.*;
import spark.ModelAndView;
import static spark.Spark.staticFileLocation;
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
        port(getHerokuAssignedPort());
        
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
        post("/tablaMaestros", (req, res) -> gson.toJson(metodosJorge.getMaestros()));
        
        get("/mainAdmin", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "html/mainAdmin");
        }, new ThymeleafTemplateEngine());
       
        get("/Instalaciones", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "html/intalaciones");
        }, new ThymeleafTemplateEngine());
        
        get("/eliminar", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("mtro", new Maestro(request.queryParams("name"), Integer.parseInt(request.queryParams("id"))));
            return new ModelAndView(model, "html/verifiEliminar"); // located in resources/templates
        }, new ThymeleafTemplateEngine());
        
        get("/deleteMtro", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("mensaje", mj.delete(Integer.parseInt(request.queryParams("id"))));
            return new ModelAndView(model, "html/eliminado"); // located in resources/templates
        }, new ThymeleafTemplateEngine());
        
        get("/getDatos", (request, response) -> {
            response.type("text/html");
            Map<String, Object> model = new HashMap<>();
            model.put("mtr", mj.verInfoMtro(Integer.parseInt(request.queryParams("id"))));
            return new ModelAndView(model, "html/modificarMtro"); // located in resources/templates
        }, new ThymeleafTemplateEngine());
        
        get("/verInfo", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("mtr", mj.verInfoMtro(Integer.parseInt(request.queryParams("id"))));
            return new ModelAndView(model, "html/verInfo"); // located in resources/templates
        }, new ThymeleafTemplateEngine());
        
        post("/modificar", (request, response) -> {
            String query = request.body();
            System.out.println( "Petición: "+query);
            Maestro m = gson.fromJson(query, Maestro.class);
            /*Map<String, Object> model = new HashMap<>();
            model.put("mtr", m);*/
            return mj.update(m);
        });
        
        get("/maestrosPorGrado", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            //model.put("msj", "mensaje");
            model.put("mtros", metodosJorge.getMaestrosPublico(Integer.parseInt(request.queryParams("id"))));
            return new ModelAndView(model, "html/verMaestrosPublico"); // located in resources/templates
        }, new ThymeleafTemplateEngine());

        /*                parte de Sam y Jessi <3*/ 
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "html/index");
        }, new ThymeleafTemplateEngine());
        
        get("/Acceso", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "html/logeo");
        }, new ThymeleafTemplateEngine());

        get("/VerDocentes", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "html/maestros");
        }, new ThymeleafTemplateEngine());
        
        get("/VerMaterias", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "html/materias");
        }, new ThymeleafTemplateEngine());
        
        get("/VerTalleres", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "html/talleres");
        }, new ThymeleafTemplateEngine());
        
        get("/MatPrimero", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "html/materiasPrimero");
        }, new ThymeleafTemplateEngine());
        
        get("/MatSegundo", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "html/materiasSegundo");
        }, new ThymeleafTemplateEngine());
        
        get("/MatTercero", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "html/materiasTercero");
        }, new ThymeleafTemplateEngine());
        
        get("/TalleresPrimero", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "html/talleresPrimero");
        }, new ThymeleafTemplateEngine());
        
        get("/TalleresSegundo", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "html/talleresSegundo");
        }, new ThymeleafTemplateEngine());
        
        get("/TalleresTercero", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "html/talleresTercero");
        }, new ThymeleafTemplateEngine());
        
        /*                parte de Richard                       */ 
        post("/agregarMaestro", (request, response) -> {
            String query = request.body();
            System.out.println("Se solicitó" +query);
            Maestro master = gson.fromJson(query, Maestro.class);
            master.setID(0);
            return mj.guardarMaestro(master);
        });

        get("/agregar", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "html/agregarMaestro");
        }, new ThymeleafTemplateEngine());

}
static int getHerokuAssignedPort() {
    ProcessBuilder processBuilder = new ProcessBuilder();
    if (processBuilder.environment().get("PORT") != null) {
        return Integer.parseInt(processBuilder.environment().get("PORT"));
    }
    return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
}

}