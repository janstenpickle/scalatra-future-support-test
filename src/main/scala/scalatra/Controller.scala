package scalatra


import org.scalatra.{FutureSupport, ScalatraServlet}

import scala.concurrent.{Future, ExecutionContext}
import scalaz.std.scalaFuture._
import scalaz.syntax.applicative._
import scalaz.syntax.either._

class Controller extends ScalatraServlet with FutureSupport {

  override implicit val executor: ExecutionContext = ExecutionContext.global

  post("/") {
    request.body.point[Future]
  }

}
