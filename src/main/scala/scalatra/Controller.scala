package scalatra


import org.scalatra.{FutureSupport, ScalatraServlet}

import scala.concurrent.{ExecutionContext, Future}
import scalaz.std.scalaFuture._
import scalaz.syntax.applicative._

class Controller extends ScalatraServlet with FutureSupport {

  override implicit val executor: ExecutionContext = ExecutionContext.global

  post("/test1") {
    request.body.point[Future]
  }

  post("/test2") {
    Future(request.body)
  }

}
