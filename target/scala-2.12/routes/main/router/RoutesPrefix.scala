
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Andreas/Desktop/IuK/IuK_II_W/Uebungen/iuk_ii_w-fs18/conf/routes
// @DATE:Tue Feb 20 17:05:45 CET 2018


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
