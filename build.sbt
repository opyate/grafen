organization := "com.opyate"

name := "grafen"

version := "0.1.0-SNAPSHOT"

seq(sbtappengine.Plugin.webSettings:  _*)

libraryDependencies ++= Seq(
  "net.databinder" %% "unfiltered-filter" % "0.5.3",
  "net.databinder" %% "unfiltered-spec" % "0.5.3" % "test"
  // uncomment the following line for persistence
  //, val jdo = "javax.jdo" % "jdo2-api" % "2.3-ea"
) ++ Seq( // local testing
  "javax.servlet" % "servlet-api" % "2.3" % "provided",
   "org.eclipse.jetty" % "jetty-webapp" % "7.4.5.v20110725" % "container"
)

resolvers ++= Seq(
 "jboss" at  "https://repository.jboss.org/nexus/content/groups/public/"
  // app engine repo, uncomment the following line for persistence resolver
  //, "nexus" at "http://maven-gae-plugin.googlecode.com/svn/repository/"
)

seq(lsSettings :_*)

