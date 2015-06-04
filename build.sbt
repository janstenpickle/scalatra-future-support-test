name := "scalatra-broken-future-support"

version := "0.1"

scalaVersion := "2.11.6"

resolvers ++= Seq(
  "bintray/non"         at "http://dl.bintray.com/non/maven",
  "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases",
  "Spray Repo"          at "http://repo.spray.io"
)

libraryDependencies ++= {
  object Versions {
    val scalaz        = "7.1.1"
    val scalatra      = "2.3.1"
    val specs2        = "2.4.15"
    val servlet       = "3.1.0"
  }
  import Versions._
  Seq(
    "org.scalaz"                 %% "scalaz-core"               % scalaz,
    "org.scalatra"               %% "scalatra"                  % scalatra,
    "javax.servlet"              % "javax.servlet-api"          % servlet,
    "org.scalatra"               %% "scalatra-specs2"           % scalatra         % "test"      exclude("org.specs2", "specs2"),
    "org.specs2"                 %% "specs2"                    % specs2           % "test"      excludeAll ExclusionRule("org.scalaz"),
    "org.specs2"                 %% "specs2-scalacheck"         % specs2           % "test"      excludeAll ExclusionRule("org.scalaz")
  )
}

addCompilerPlugin("org.spire-math" % "kind-projector_2.11" % "0.5.2")


scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

incOptions := incOptions.value.withNameHashing(true)

