import java.io.File
import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName = "tz-viewer"
  val appVersion = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    javaCore,
    cache,

    "com.classactionpl.tz" % "zoneinfo-tz" % "1.0.1",
    "com.google.inject" % "guice" % "3.0",
    "javax.inject" % "javax.inject" % "1",

    "org.webjars" %% "webjars-play" % "2.2.0-SNAPSHOT",

    "org.webjars" % "angular-ui-bootstrap" % "0.3.0-1",
    "org.webjars" % "angularjs" % "1.1.5-1"
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
    resolvers += Resolver.mavenLocal,
    resolvers += Resolver.file("LocalIvy", file(Path.userHome +
      File.separator + ".ivy2" + File.separator +
      "local"))(Resolver.ivyStylePatterns)
  )

}
