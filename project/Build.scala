import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "tz-viewer"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    javaCore,

    "com.classactionpl.tz" % "zoneinfo-tz" % "1.0.1",
    "com.google.inject" % "guice" % "3.0",
    "javax.inject" % "javax.inject" % "1",

    "org.webjars" % "webjars-play" % "2.1.0-1",

    "org.webjars" % "bootstrap" % "2.3.1-1"
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
    resolvers += Resolver.mavenLocal
  )

}
