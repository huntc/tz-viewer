import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "tz-viewer"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    javaCore,

    "com.classactionpl.tz" % "zoneinfo-tz" % "1.0.1"
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
  )

}
