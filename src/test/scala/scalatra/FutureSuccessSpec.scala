package scalatra

import org.scalacheck.{Gen, Prop}
import org.scalatra.test.specs2.ScalatraSpec
import org.specs2.ScalaCheck

class FutureSuccessSpec extends ScalatraSpec with ScalaCheck {
  def is =
    s2"""
       Passes with a future success $test
      """
    
  def test = Prop.forAll(Gen.alphaStr.suchThat(!_.isEmpty)) { s =>
    post("/test2", s) {
      body must_== s
    }
  }

  addServlet(new Controller, "/*")
}
