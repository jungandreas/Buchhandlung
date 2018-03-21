package controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
@Api(value = "Book Controller", produces = "application/json")
public class BookController extends Controller {

    @ApiOperation(value = "Get Books", notes = "Get list of books.")
    public Result books(String q) {
        return ok("Books"+ q);
    }

    public Result create() {
        return ok("Create books");
    }

    public Result update(Long id) {
        if(id == 5) {
            return notFound("Book with given id not found");
        }
        return ok("Update book with id " + id);
    }

    public Result details(Long id) {
        if(id == 5) {
            return notFound("Book with given id not found");
        }
        return ok("Book details for book with id " + id);
    }

    public Result delete(Long id) {
        if(id == 5) {
            return notFound("Book with given id not found");
        }
        return ok("Delete book with id " + id);
    }
}
