package scalatra

import org.scalacheck.{Prop, Gen}
import org.scalatra.test.specs2.ScalatraSpec
import org.specs2.ScalaCheck

class PointFutureSpec extends ScalatraSpec with ScalaCheck {
  def is =
    s2"""
       Fails with a point future $test
      """
    
  def test = Prop.forAll(Gen.alphaStr.suchThat(!_.isEmpty)) { s =>
    post("/test1", s) {
      body must_== s
    }
  }

  addServlet(new Controller, "/*")
}
