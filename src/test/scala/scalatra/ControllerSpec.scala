package scalatra

import org.scalacheck.{Prop, Gen}
import org.scalatra.test.specs2.ScalatraSpec
import org.specs2.ScalaCheck

class ControllerSpec extends ScalatraSpec with ScalaCheck {
  def is = Prop.forAll(Gen.alphaStr.suchThat(!_.isEmpty)) { s =>
    post("/", s) {
      body must_== s
    }
  }

  addServlet(new Controller, "/*")
}
