import sbt._
import Keys._

object GrafenBuild extends Build {

  lazy val grafen = Project(
    id = "grafen",
    base = file("."),
    settings = defaultSettings ++ Seq(
      name := "grafen",
      organization := "com.opyate",
      version := "0.0.1-SNAPSHOT"
    )
  ) dependsOn(scalaGraph)

  lazy val scalaGraph = RootProject(uri("git://github.com/opyate/scala-graph-assembla.git"))

  //lazy val scalaGraph = RootProject(file("/Users/juanuys/Documents/src/github/graph-projects/scala-graph-combo/trunk"))

  lazy val defaultSettings =
    Defaults.defaultSettings ++
    Seq(
      scalaVersion := "2.9.1",
      parallelExecution in Test := false,
      scalacOptions ++= Opts.compile.encoding("utf8") :+
                        Opts.compile.deprecation :+
                        Opts.compile.unchecked,
      scalacOptions in (Compile, doc) <++= (name, version) map {
                                           Opts.doc.title(_) ++ Opts.doc.version(_) },
      testOptions in Test := Seq(Tests.Filter(s => s.endsWith("Test"))),
      libraryDependencies ++= Seq(
        "net.databinder" %% "unfiltered-filter" % "0.5.3",
        "net.databinder" %% "unfiltered-spec" % "0.5.3" % "test",
        // uncomment the following line for persistence
        //, val jdo = "javax.jdo" % "jdo2-api" % "2.3-ea"
        "junit" % "junit" % "4.8.2" % "test",
        "org.scalatest" % "scalatest_2.9.0" % "1.6.1" % "test",
        "javax.servlet" % "servlet-api" % "2.3" % "provided",
        "org.eclipse.jetty" % "jetty-webapp" % "7.4.5.v20110725" % "container"
      )
    )
}