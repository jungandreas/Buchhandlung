package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import models.Book;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import services.BookService;
import services.DefaultBookService;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
@Api(value = "Book Controller", produces = "application/json")
public class BookController extends Controller {

    private final BookService bookService;

    public BookController() {
        bookService = new DefaultBookService();
    }

    @ApiOperation(value = "Get Books", notes = "Get list of books.")
    public Result books(String q) {
        return ok(Json.toJson(bookService.get()));
    }

    // This way, a 400 HTTP response will be automatically returned for non JSON requests with Content-type set to application/json.
    @BodyParser.Of(BodyParser.Json.class)
    public Result create() {
        final JsonNode json = request().body().asJson();
        final Book book = Json.fromJson(json, Book.class);
        return ok(Json.toJson(bookService.add(book)));
    }

    @BodyParser.Of(BodyParser.Json.class)
    public Result update(Long id) {
        final JsonNode json = request().body().asJson();
        final Book book = Json.fromJson(json, Book.class);
        book.setId(id);
        final Book updatedBook = bookService.update(book);
        if(null != updatedBook) {
            return ok(Json.toJson(updatedBook));
        }
        return internalServerError();

    }

    public Result details(Long id) {
        Book book = bookService.get(id);
        if(null == book) {
            return notFound();
        }
        return ok(Json.toJson(book));
    }

    public Result delete(Long id) {
        if(bookService.delete(id)) {
            return ok();
        }
        return internalServerError();
    }

}
