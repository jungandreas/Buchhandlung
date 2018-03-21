
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Andreas/Desktop/IuK/IuK_II_W/Uebungen/iuk_ii_w-fs18/conf/routes
// @DATE:Mon Mar 19 14:36:12 CET 2018

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:10
  class ReverseBookController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def delete(id:Long): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "api/books/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:11
    def create(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "api/books")
    }
  
    // @LINE:10
    def books(q:String = null): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/books" + play.core.routing.queryString(List(if(q == null) None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("q", q)))))
    }
  
    // @LINE:13
    def update(id:Long): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "api/books/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:12
    def details(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/books/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
  }

  // @LINE:20
  class ReverseApiHelpController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:20
    def getResources(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "docs/swagger.json")
    }
  
  }

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:17
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:17
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }


}
